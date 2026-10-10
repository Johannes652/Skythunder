package at.johannes.skythunder.config

class SkythunderConfig {
    var general: General = General()
    var fishing: Fishing = Fishing()

    class General {
        var debugLogs: Boolean = false
    }

    class Fishing {
        var playCatchSounds: Boolean = true
        var catchSoundVolume: Float = 0.5f
    }
}