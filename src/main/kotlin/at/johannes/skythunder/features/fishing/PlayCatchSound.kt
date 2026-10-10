package at.johannes.skythunder.features.fishing

import at.johannes.skythunder.Skythunder.MOD_ID
import net.minecraft.client.Minecraft
import at.johannes.skythunder.events.ChatEvents
import at.johannes.skythunder.sound.CustomSounds
import at.johannes.skythunder.features.fishing.SeaCreature.*
import net.minecraft.sounds.SoundEvent
import at.johannes.skythunder.util.SkythunderLogger
import at.johannes.skythunder.config.SkythunderConfigManager

object PlayCatchSound {

    var CLIENT: Minecraft = Minecraft.getInstance()

    var lastSeaCreature: SeaCreature? = null
    var queueSound: Boolean = false
    var soundVolume: Float = 1.0f

    val doulbeHookPrefix: String = "DOUBLE HOOK! "

    fun init() {
        ChatEvents.receiveString.register(::onChatMessage)
        SkythunderLogger.info("PlayCatchSound initialized.")
    }

    fun onChatMessage(message: String){
        if (!SkythunderConfigManager.getConfig().fishing.playCatchSounds) {
            return
        }
        soundVolume = SkythunderConfigManager.getConfig().fishing.catchSoundVolume

        SkythunderLogger.debug("Received chat message: $message")

        queueSound = false;

        val catchMessage: String = message.replaceFirst(doulbeHookPrefix, "")

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

        var soundEvent: SoundEvent? = null
        when(lastSeaCreature) {
            THUNDER -> {
                soundEvent = CustomSounds.THUNDERSTRUCK_SHORT
            }
            LORD_JAWBUS -> {
                soundEvent = CustomSounds.VINE_BOOM
            }
            RAGNAROK -> {
                soundEvent = CustomSounds.YIPPE
            }
            else -> {
                SkythunderLogger.debug("No sound registered for ${lastSeaCreature!!.name}")
            }
        }
        if (soundEvent != null) {
            SkythunderLogger.debug("Playing sound for ${lastSeaCreature!!.name}")
            CLIENT.player!!.playSound(soundEvent, soundVolume, 1.0f)
        }
    }
}