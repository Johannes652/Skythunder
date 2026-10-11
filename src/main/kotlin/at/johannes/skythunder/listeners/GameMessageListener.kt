package at.johannes.skythunder.listeners

import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents
import net.minecraft.network.chat.Component
import at.johannes.skythunder.util.SkythunderLogger

object GameMessageListener {
    fun init() {
        register()
        SkythunderLogger.info("GameMessageListener initialized.")
    }

    private fun register() {
        ClientReceiveMessageEvents.GAME.register { message: Component, overlay: Boolean ->
            onReceiveGameMessage(message, overlay)
        }
    }

    private fun onReceiveGameMessage(message: Component, overlay: Boolean) {
        // Handle the received game message here
        SkythunderLogger.info("Received game message: $message, overlay: $overlay")
    }
}