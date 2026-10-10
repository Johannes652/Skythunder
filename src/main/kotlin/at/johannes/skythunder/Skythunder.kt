package at.johannes.skythunder

import net.fabricmc.api.ClientModInitializer
import net.minecraft.resources.Identifier
import at.johannes.skythunder.util.SkythunderLogger

import at.johannes.skythunder.features.fishing.PlayCatchSound
import at.johannes.skythunder.sound.CustomSounds
import at.johannes.skythunder.config.SkythunderConfigManager
import at.johannes.skythunder.commands.SkythunderCommands

object Skythunder : ClientModInitializer {
	const val MOD_ID: String = "skythunder"

	override fun onInitializeClient() {
		SkythunderLogger.info("Initializing Skythunder mod...")

		SkythunderConfigManager.init()
		CustomSounds.init()
		PlayCatchSound.init()
		SkythunderCommands.init()

		SkythunderLogger.info("Skythunder mod initialized.")
	}

	fun id(path: String): Identifier
		= Identifier.fromNamespaceAndPath(MOD_ID, path)
}
