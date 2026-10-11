package at.johannes.skythunder.config

import at.johannes.skythunder.util.SkythunderLogger
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

object SkythunderConfigManager {
    val GSON: Gson = GsonBuilder().setPrettyPrinting().create()
    val PATH: Path = FabricLoader.getInstance().configDir.resolve("skythunder.json")

    private var CONFIG: SkythunderConfig = SkythunderConfig()

    fun init() {
        try {
            if (Files.exists(PATH)) {
                CONFIG = GSON.fromJson(Files.readString(PATH), SkythunderConfig::class.java)
                update()
            }
            else {
                save();
            }
        } catch (e: IOException) {
            SkythunderLogger.error("Error while reading config file", e)
        }
        SkythunderLogger.info("Skythunder config initialized.")
    }

    fun save() {
        try {
            Files.createDirectories(PATH.parent)
            Files.writeString(PATH, GSON.toJson(CONFIG))
        } catch (e: IOException) {
            SkythunderLogger.error("Error while saving config", e)
        }
    }

    fun update() {
        // Check if a config from class SkythunderConfig is missing in json file on PATH,
        // if so, add config to file without overwriting previous from default values.
        val currentConfig = GSON.toJson(CONFIG)
        val existingConfig = if (Files.exists(PATH)) Files.readString(PATH) else "{}"
        if (currentConfig != existingConfig) {
            save()
        }
    }

    fun getConfig(): SkythunderConfig {
        return CONFIG
    }
}