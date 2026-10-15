package at.johannes.skythunder.compat

import at.johannes.skythunder.config.SkythunderConfigManager
import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.Component

object SkythunderModMenuImpl : ModMenuApi {
    override fun getModConfigScreenFactory(): ConfigScreenFactory<*> =
        ConfigScreenFactory { parent -> OpenConfigScreen(parent) }

    // MoulConfig opens its own screen, so this placeholder hands off to it right away.
    private class OpenConfigScreen(private val parent: Screen) : Screen(Component.empty()) {
        private var opened = false

        override fun init() {
            if (opened) return
            opened = true
            Minecraft.getInstance().schedule { SkythunderConfigManager.openGui() }
        }
    }
}