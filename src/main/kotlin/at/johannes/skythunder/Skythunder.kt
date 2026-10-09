package at.johannes.skythunder

import net.fabricmc.api.ClientModInitializer
import net.minecraft.resources.Identifier
import org.slf4j.LoggerFactory

import at.johannes.skythunder.features.fishing.PlayCatchSound

object Skythunder : ClientModInitializer {
	const val MOD_ID: String = "skythunder"

	private val LOGGER = LoggerFactory.getLogger(MOD_ID)

	override fun onInitializeClient() {
		LOGGER.info("Hello Fabric world!")

		PlayCatchSound.init()
	}

	fun id(path: String): Identifier
		= Identifier.fromNamespaceAndPath(MOD_ID, path)
}
