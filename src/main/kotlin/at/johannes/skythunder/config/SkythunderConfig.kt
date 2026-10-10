package at.johannes.skythunder.config

import at.johannes.skythunder.features.fishing.SeaCreature

class SkythunderConfig {
    var general: General = General()
    var fishing: Fishing = Fishing()

    class General {
        var debugLogs: Boolean = false
    }

    class Fishing {
        var playCatchSounds: Boolean = true
        var catchSoundVolume: Float = 0.5f

        var catchSounds: MutableMap<SeaCreature, String> = mutableMapOf(
            SeaCreature.THUNDER to "skythunder:thunderstruck_short",
            SeaCreature.LORD_JAWBUS to "skythunder:vine_boom",
            SeaCreature.RAGNAROK to "skythunder:yippe"
        )
    }
}