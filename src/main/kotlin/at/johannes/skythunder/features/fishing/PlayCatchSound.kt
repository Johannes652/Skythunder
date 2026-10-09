package at.johannes.skythunder.features.fishing

import at.johannes.skythunder.Skythunder.MOD_ID
import net.minecraft.client.Minecraft
import at.johannes.skythunder.events.ChatEvents
import at.johannes.skythunder.sound.CustomSounds
import at.johannes.skythunder.features.fishing.SeaCreature.*
import net.minecraft.sounds.SoundEvent
import org.slf4j.LoggerFactory

object PlayCatchSound {

    var CLIENT: Minecraft = Minecraft.getInstance()

    var lastSeaCreature: SeaCreature? = null
    var queueSound: Boolean = false

    private val LOGGER = LoggerFactory.getLogger(MOD_ID)

    fun init() {
        ChatEvents.receiveString.register(::onChatMessage)
        LOGGER.info("PlayCatchSound initialized.")
    }

    fun onChatMessage(message: String){
        LOGGER.info("Received chat message: $message")

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
                LOGGER.info("No sound registered for ${lastSeaCreature!!.name}")
            }
        }
        if (soundEvent != null) {
            LOGGER.info("Playing sound for ${lastSeaCreature!!.name}")
            CLIENT.player!!.playSound(soundEvent, 1.0f, 1.0f)
        }
    }
}