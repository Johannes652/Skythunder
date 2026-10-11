package at.johannes.skythunder.commands

import at.johannes.skythunder.config.SkythunderConfigManager
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource
import net.minecraft.client.Minecraft
import net.minecraft.network.chat.Component

object SkythunderCommands {
    const val prefix: String = "§b[Skythunder]§r "

    val rootCommandAliases: List<String> = listOf(
        "skythunder",
        "st"
    )

    val subCommands: List<SubCommand> = listOf(
        SubCommand("reloadconfig") { source ->
            if (SkythunderConfigManager.reload()) {
                source.sendFeedback(Component.literal("$prefix Config reloaded successfully."))
            } else {
                source.sendError(Component.literal("$prefix Could not read config file, keeping current settings. Check the log."))
            }
        }
    )

    fun openGui() {
        Minecraft.getInstance().schedule { SkythunderConfigManager.openGui() }
    }
}

class SubCommand (val name: String, val run: (FabricClientCommandSource) -> Unit)