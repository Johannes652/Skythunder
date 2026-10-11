package at.johannes.skythunder.config

import at.johannes.skythunder.skyblock.SeaCreature
import com.google.gson.annotations.Expose
import io.github.notenoughupdates.moulconfig.Config
import io.github.notenoughupdates.moulconfig.annotations.*

class SkythunderConfig : Config() {

    @Expose @JvmField
    @Category(name = "General", desc = "General settings")
    var general: General = General()

    @Expose @JvmField
    @Category(name = "Fishing", desc = "Fishing settings")
    var fishing: Fishing = Fishing()

    class General {
        @Expose @JvmField
        @ConfigOption(name = "Debug Logs", desc = "Print extra debug output to the log")
        @ConfigEditorBoolean
        var debugLogs: Boolean = false
    }

    class Fishing {
        @Expose @JvmField
        @ConfigOption(name = "Play Catch Sounds", desc = "Play a sound when catching certain sea creatures")
        @ConfigEditorBoolean
        var playCatchSounds: Boolean = true

        @Expose @JvmField
        @ConfigOption(name = "Catch Sound Volume", desc = "Volume of the catch sounds")
        @ConfigEditorSlider(minValue = 0f, maxValue = 1f, minStep = 0.05f)
        var catchSoundVolume: Float = 0.5f

        // No @ConfigOption, so it never shows in the GUI, but @Expose keeps it in the JSON.
        @Expose @JvmField
        var catchSounds: MutableMap<SeaCreature, String> = mutableMapOf(
            SeaCreature.THUNDER to "skythunder:thunderstruck_short",
            SeaCreature.LORD_JAWBUS to "skythunder:vine_boom",
            SeaCreature.RAGNAROK to "skythunder:yippe"
        )
    }
}