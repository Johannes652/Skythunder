package at.johannes.skythunder.util

import at.johannes.skythunder.Skythunder.MOD_ID
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import at.johannes.skythunder.config.SkythunderConfigManager

object SkythunderLogger {
    private val delegate: Logger = LoggerFactory.getLogger(MOD_ID)

    fun info(msg: String) {
        delegate.info("[Skythunder] [INFO] $msg")
    }

    fun debug(msg: String) {
        if (!SkythunderConfigManager.getConfig().general.debugLogs) {
            return
        }
        delegate.info("[Skythunder] [DEBUG] $msg")
    }

    fun warn(msg: String) {
        delegate.warn("[Skythunder] [WARN] $msg")
    }

    fun error(msg: String, throwable: Throwable? = null) {
        if (throwable == null) {
            delegate.error("[Skythunder] [ERROR] $msg")
        } else {
            delegate.error("[Skythunder] [ERROR] $msg", throwable)
        }
    }
}