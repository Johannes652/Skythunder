package at.johannes.skythunder.commands

import com.mojang.brigadier.Command
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal
import net.minecraft.network.chat.Component
import at.johannes.skythunder.util.SkythunderLogger

object SkythunderCommands {

    fun init() {
        register()
        SkythunderLogger.info("SkythunderCommands initialized.")
    }

    private fun register() {
        ClientCommandRegistrationCallback.EVENT.register { dispatcher, _ ->
            dispatcher.register(
                literal("skythunder")
                    .executes { context ->
                        context.source.sendFeedback(Component.literal("§b[Skythunder]§r Command executed!"))
                        Command.SINGLE_SUCCESS
                    }
            )
        }
    }
}