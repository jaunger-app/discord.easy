package net.sta.event.level;

import net.sta.event.listener.EventAdapter;
import net.sta.event.listener.MessageLevel;
import net.sta.event.message.MessageReceivedEvent;
import net.sta.managers.XpManager;
import org.jetbrains.annotations.NotNull;


public class SetmessageLevel extends EventAdapter implements MessageLevel, XpManager {
    @Override
    public void onMessageReceivedEvent(@NotNull MessageReceivedEvent event) {
        if (event.getMessage().getAuthor().isBot())return;
        if (canGetMessageXp(event.getMessage().getMember())){
            setMessagePlayerTime(event.getMessage().getMember(), 10);
            randXp(event.getMessage().getMember(), 10);

        }
    }
}
