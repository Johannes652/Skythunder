package at.johannes.skythunder.util

import at.johannes.skythunder.Skythunder.MOD_ID
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import at.johannes.skythunder.config.SkythunderConfigManager

object SkythunderLogger {
    private val delegate: Logger = LoggerFactory.getLogger(MOD_ID)
    private const val PREFIX_MOD = "[Skythunder]"
    private const val PREFIX_INFO = "[INFO]"
    private const val PREFIX_DEBUG = "[DEBUG]"
    private const val PREFIX_WARN = "[WARN]"
    private const val PREFIX_ERROR = "[ERROR]"

    fun info(msg: String) {
        delegate.info("$PREFIX_MOD $PREFIX_INFO $msg")
    }

    fun debug(msg: String) {
        if (!SkythunderConfigManager.getConfig().general.debugLogs) {
            return
        }
        delegate.info("$PREFIX_MOD $PREFIX_DEBUG $msg")
    }

    fun warn(msg: String) {
        delegate.warn("$PREFIX_MOD $PREFIX_WARN $msg")
    }

    fun error(msg: String, throwable: Throwable? = null) {
        delegate.error("$PREFIX_MOD $PREFIX_ERROR $msg", throwable)
    }
}