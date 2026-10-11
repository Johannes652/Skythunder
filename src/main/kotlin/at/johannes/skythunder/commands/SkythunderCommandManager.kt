package at.johannes.skythunder.commands

import com.mojang.brigadier.Command
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal
import at.johannes.skythunder.util.SkythunderLogger

object SkythunderCommandManager {

    fun init() {
        register()
        SkythunderLogger.info("SkythunderCommandManager initialized.")
    }

    private fun register() {
        ClientCommandRegistrationCallback.EVENT.register { dispatcher, _ ->
            for (root in SkythunderCommands.rootCommandAliases) {
                val rootCommand = literal(root).executes {
                    SkythunderCommands.openGui()
                    Command.SINGLE_SUCCESS
                }
                for (sub in SkythunderCommands.subCommands) {
                    rootCommand.then(
                        literal(sub.name).executes { context ->
                            sub.run(context.source)
                            Command.SINGLE_SUCCESS
                        }
                    )
                }
                dispatcher.register(rootCommand)
            }
        }
    }
}