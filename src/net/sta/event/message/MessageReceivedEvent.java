package net.sta.event.message;

import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.sta.event.events.Event;

@Getter
public class MessageReceivedEvent extends Event implements net.sta.event.message.Message {

    private final Message message = new MessageGetter().getMessage();
    public MessageReceivedEvent(JDA jda) {
        super(jda);
    }
}
