package at.johannes.skythunder.commands

import at.johannes.skythunder.config.SkythunderConfigManager
import com.mojang.brigadier.Command
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal
import net.minecraft.client.Minecraft
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
                        Minecraft.getInstance().schedule { SkythunderConfigManager.openGui() }
                        Command.SINGLE_SUCCESS
                    }
            )
        }
    }
}