package at.johannes.skythunder.mixin;

import at.johannes.skythunder.events.ChatEvents;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.multiplayer.chat.ChatListener;

@Mixin(ChatListener.class)
public class ChatListenerMixin {
    @Inject(at = @At("HEAD"), method = "handleSystemMessage")
    private void skythunder$onSystemMessage(Component message, boolean overlay, CallbackInfo info) {
        ChatEvents.INSTANCE.getReceiveString().invoker().onMessage(message.getString());
    }
}

