package at.johannes.skythunder.commands

import at.johannes.skythunder.config.SkythunderConfigManager
import at.johannes.skythunder.commands.SkythunderCommands
import com.mojang.brigadier.Command
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal
import net.minecraft.client.Minecraft
import at.johannes.skythunder.util.SkythunderLogger

object SkythunderCommandManager {

    fun init() {
        register()
        SkythunderLogger.info("SkythunderCommandManager initialized.")
    }

    private fun register() {
        ClientCommandRegistrationCallback.EVENT.register { dispatcher, _ ->
            val root = literal("skythunder").executes {
                SkythunderCommands.openGui()
                Command.SINGLE_SUCCESS
            }
            for (sub in SkythunderCommands.subCommands) {
                root.then(
                    literal(sub.name).executes { context ->
                        sub.run(context.source)
                        Command.SINGLE_SUCCESS
                    }
                )
            }
            dispatcher.register(root)
        }
    }
}