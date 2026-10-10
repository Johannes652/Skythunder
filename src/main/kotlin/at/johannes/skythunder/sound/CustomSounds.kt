package at.johannes.skythunder.sound

import at.johannes.skythunder.Skythunder.MOD_ID
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.Registry
import net.minecraft.sounds.SoundEvent
import net.minecraft.resources.Identifier
import at.johannes.skythunder.util.SkythunderLogger

object CustomSounds {

    fun init() {
        SkythunderLogger.info("CustomSounds initialized.")
    }

    // Register sounds here
    val YIPPE: SoundEvent = register("yippe")
    val VINE_BOOM: SoundEvent = register("vine_boom")
    val THUNDERSTRUCK_SHORT: SoundEvent = register("thunderstruck_short")
    //

    fun register(name: String): SoundEvent {
        val id: Identifier = Identifier.fromNamespaceAndPath(MOD_ID, name)
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id))
    }
}