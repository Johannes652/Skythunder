package at.johannes.skythunder.features.fishing

import net.minecraft.client.Minecraft
import at.johannes.skythunder.events.ChatEvents
import at.johannes.skythunder.sound.CustomSounds
import at.johannes.skythunder.features.fishing.SeaCreature.*
import net.minecraft.sounds.SoundEvent
import at.johannes.skythunder.util.SkythunderLogger
import at.johannes.skythunder.config.SkythunderConfigManager
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.Identifier

object PlayCatchSound {

    var CLIENT: Minecraft = Minecraft.getInstance()

    var lastSeaCreature: SeaCreature? = null
    var queueSound: Boolean = false
    var soundVolume: Float = 1.0f

    const val DOUBLE_HOOK_PREFIX: String = "DOUBLE HOOK! "

    fun init() {
        ChatEvents.receiveString.register(::onChatMessage)
        SkythunderLogger.info("PlayCatchSound initialized.")
    }

    fun getSoundForSeaCreature(creature: SeaCreature): SoundEvent? {
        val soundIdString = SkythunderConfigManager.getConfig().fishing.catchSounds[creature] ?: return null
        val identifier = Identifier.tryParse(soundIdString) ?: return null

        // Fetch the SoundEvent from the registry using the identifier. If it doesn't exist, return null.
        return BuiltInRegistries.SOUND_EVENT.getOptional(identifier).orElse(null)
    }

    fun onChatMessage(message: String){
        if (!SkythunderConfigManager.getConfig().fishing.playCatchSounds) {
            return
        }
        soundVolume = SkythunderConfigManager.getConfig().fishing.catchSoundVolume

        SkythunderLogger.debug("Received chat message: $message")

        queueSound = false;

        val catchMessage: String = message.replaceFirst(DOUBLE_HOOK_PREFIX, "")

        for (creature: SeaCreature in SeaCreature.entries) {
            if (catchMessage == creature.chatMessage) {
                lastSeaCreature = creature
                queueSound = true
                break
            }
        }

        // Some error handling to prevent crashes if the player or level is null - is this necessary?
        if (lastSeaCreature == null ||
            CLIENT.player == null ||
            CLIENT.level == null ||
            !queueSound) {
            return
        }

        val soundEvent: SoundEvent? = getSoundForSeaCreature(lastSeaCreature!!)
        if (soundEvent == null) {
            SkythunderLogger.debug("No sound registered for ${lastSeaCreature!!.name}")
        } else {
            SkythunderLogger.debug("Playing sound for ${lastSeaCreature!!.name}")
            CLIENT.player!!.playSound(soundEvent, soundVolume, 1.0f)
        }
    }
}