package net.sta.event.message;

import net.dv8tion.jda.api.entities.MessageEmbed;

import java.util.Arrays;
@SuppressWarnings("all")

public interface Message{
     default void sendMessage(String message){
         new MessageGetter().getMessage().getChannel().sendMessage(message).queue();
    }

     default void sendEmbed(MessageEmbed... emebeds){
        new MessageGetter().getMessage().getChannel().sendMessageEmbeds(Arrays.asList(emebeds)).queue();
    }
     default void sendMessage(String message, Integer ChannelId){
         new MessageGetter().getMessage().getGuild().getTextChannelById(ChannelId).sendMessage(message).queue();
    }
     default void sendEmbed(Integer ChannelId, MessageEmbed... emebeds){
         new MessageGetter().getMessage().getGuild().getTextChannelById(ChannelId).sendMessageEmbeds(Arrays.asList(emebeds)).queue();
    }

    default Boolean startsWith(String string){
         if (string.startsWith(String.valueOf(new MessageGetter().getMessage().getContentRaw()))) {
             return true;
         }
         return false;
    }
    default Boolean equals(String string){
         if (string.equals(String.valueOf(new MessageGetter().getMessage().getContentRaw()))){
             return true;
         }
        return false;
    }
}
