package at.johannes.skythunder.features.fishing

import net.minecraft.client.Minecraft
import net.minecraft.sounds.SoundEvent
import at.johannes.skythunder.util.SkythunderLogger
import at.johannes.skythunder.config.SkythunderConfigManager
import at.johannes.skythunder.skyblock.SeaCreature
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.Identifier
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents
import net.minecraft.network.chat.Component

object PlayCatchSound {
    fun init() {
        ClientReceiveMessageEvents.GAME.register { message: Component, overlay: Boolean ->
            onChatMessage(message.string)
        }
        SkythunderLogger.info("PlayCatchSound initialized.")
    }

    private fun getSoundForSeaCreature(creature: SeaCreature): SoundEvent? {
        val soundIdString: String = SkythunderConfigManager.getConfig().fishing.catchSounds[creature] ?: return null
        val identifier: Identifier = Identifier.tryParse(soundIdString) ?: return null

        // Fetch the SoundEvent from the registry using the identifier. If it doesn't exist, return null.
        return BuiltInRegistries.SOUND_EVENT.getOptional(identifier).orElse(null)
    }

    private fun onChatMessage(message: String){
        if (!SkythunderConfigManager.getConfig().fishing.playCatchSounds) {
            return
        }

        var lastSeaCreature: SeaCreature? = null
        for (creature: SeaCreature in SeaCreature.entries) {
            if (message == creature.chatMessage) {
                lastSeaCreature = creature
                break
            }
        }
        if (lastSeaCreature == null) return

        val soundEvent: SoundEvent? = getSoundForSeaCreature(lastSeaCreature)
        if (soundEvent == null) {
            SkythunderLogger.debug("No sound registered for ${lastSeaCreature.name}")
            return
        }
        SkythunderLogger.debug("Playing sound for ${lastSeaCreature.name}")
        val client: Minecraft = Minecraft.getInstance()
        val soundVolume: Float = SkythunderConfigManager.getConfig().fishing.catchSoundVolume
        try {
            client.player!!.playSound(soundEvent, soundVolume, 1.0f)
        } catch (e: Exception) {
            SkythunderLogger.error("Error playing sound for ${lastSeaCreature.name}: ${e.message}")
        }
    }
}