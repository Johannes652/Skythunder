package at.johannes.skythunder.features.fishing

import net.minecraft.client.Minecraft
import net.minecraft.sounds.SoundEvent
import at.johannes.skythunder.util.SkythunderLogger
import at.johannes.skythunder.config.SkythunderConfigManager
import at.johannes.skythunder.skyblock.SeaCreature
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.Identifier
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents
import net.minecraft.network.chat.Component

object PlayCatchSound {

    var CLIENT: Minecraft = Minecraft.getInstance()

    var lastSeaCreature: SeaCreature? = null
    var queueSound: Boolean = false
    var soundVolume: Float = 1.0f

    fun init() {
        ClientReceiveMessageEvents.GAME.register { message: Component, overlay: Boolean ->
            onChatMessage(message.string)
        }
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
        queueSound = false;

        for (creature: SeaCreature in SeaCreature.entries) {
            if (message == creature.chatMessage) {
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