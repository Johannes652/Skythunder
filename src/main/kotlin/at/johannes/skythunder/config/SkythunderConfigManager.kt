package at.johannes.skythunder.config

import at.johannes.skythunder.util.SkythunderLogger
import io.github.notenoughupdates.moulconfig.managed.ManagedConfig
import net.fabricmc.loader.api.FabricLoader
import java.util.function.BiConsumer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents

object SkythunderConfigManager {
    private lateinit var managed: ManagedConfig<SkythunderConfig>
    private var loadError: Exception? = null

    fun init() {
        val file = FabricLoader.getInstance().configDir.resolve("skythunder.json").toFile()
        managed = ManagedConfig.create(file, SkythunderConfig::class.java) {
            jsonMapper { gsonBuilder.setPrettyPrinting() }
            loadFailed = BiConsumer { _, ex -> SkythunderLogger.error("Failed to load config", ex) }
            saveFailed = BiConsumer { _, ex -> SkythunderLogger.error("Failed to save config", ex) }
        }

        // Create the file on first run, and add any new fields to an existing one
        managed.saveToFile()

        // Safety net: persist if the game closes without the GUI being closed first.
        ClientLifecycleEvents.CLIENT_STOPPING.register { managed.saveToFile() }

        SkythunderLogger.info("Skythunder config initialized.")
    }

    fun reload(): Boolean {
        loadError = null
        managed.reloadFromFile()
        return loadError == null
    }

    // Always call this rather than caching the result: the instance is replaced on reload.
    fun getConfig(): SkythunderConfig = managed.instance

    fun save() = managed.saveToFile()

    fun openGui() = managed.openConfigGui()
}