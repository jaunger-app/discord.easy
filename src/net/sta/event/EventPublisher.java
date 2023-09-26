package net.sta.event;

import net.dv8tion.jda.api.JDA;
import net.sta.event.listener.EventListener;

import java.util.ArrayList;
import java.util.List;

public class EventPublisher {
    protected JDA jda;
    protected static List<EventListener> listeners = new ArrayList<>();

    public void addEventListener(EventListener listener) {
        listeners.add(listener);
        new EventRegister();
    }

    public void setJda(JDA jda) {
        new Event(jda);
        this.jda = jda;
    }
}