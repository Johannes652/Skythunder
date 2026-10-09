package at.johannes.skythunder.events

import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory
import net.minecraft.network.chat.Component

object ChatEvents {
    val receiveText: Event<ChatTextEvent> = EventFactory.createArrayBacked(
        ChatTextEvent::class.java
    ) { listeners ->
        ChatTextEvent { message ->
            listeners.forEach { listener -> listener.onMessage(message) }
        }
    }

    val receiveString: Event<ChatStringEvent> = EventFactory.createArrayBacked(
        ChatStringEvent::class.java
    ) { listeners ->
        ChatStringEvent { message ->
            listeners.forEach { listener -> listener.onMessage(message) }
        }
    }

    fun interface ChatTextEvent {
        fun onMessage(message: Component)
    }

    fun interface ChatStringEvent {
        fun onMessage(message: String)
    }
}