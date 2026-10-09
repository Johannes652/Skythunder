package at.johannes.skythunder.features.fishing

import at.johannes.skythunder.Skythunder.MOD_ID
import net.minecraft.client.Minecraft
import net.minecraft.ChatFormatting
import at.johannes.skythunder.events.ChatEvents
import org.slf4j.LoggerFactory

object PlayCatchSound {

    var client: Minecraft = Minecraft.getInstance()

    var lastSeaCreature: SeaCreature? = null
    var queueSound: Boolean = false

    private val LOGGER = LoggerFactory.getLogger(MOD_ID)

    fun init() {
        ChatEvents.receiveString.register(::onChatMessage)
        LOGGER.info("PlayCatchSound initialized.")
    }

    fun onChatMessage(message: String){
        val msg: String? = ChatFormatting.stripFormatting(message)

        LOGGER.info("Received chat message: $msg")
        LOGGER.info(message)

        for (creature: SeaCreature in SeaCreature.entries) {
            if (msg == creature.chatMessage) {
                lastSeaCreature = creature
                queueSound = true
                break
            }
        }

        // Some error handling to prevent crashes if the player or level is null - is this necessary?
        if (lastSeaCreature == null ||
            client.player == null ||
            client.level == null) {
            queueSound = false
            return
        }

        if (queueSound) {
            queueSound = false

            LOGGER.info("Playing sound for ${lastSeaCreature!!.name} with rarity ${lastSeaCreature!!.rarity} and category ${lastSeaCreature!!.category}")
        }
    }
}