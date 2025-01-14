package net.sta.webserver.web.modules;

import com.mysql.cj.xdevapi.DatabaseObject;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.sta.BotManager;

import java.util.List;


public class GetTickets {


    public static Integer TicketAmount = 0;
    static Guild guild = BotManager.getBot().getGuilds().get(0);


    public static List<TextChannel> getTicket(String TicketCategoryName){
        List<TextChannel> TextChannel = guild.getCategoriesByName(TicketCategoryName,true).get(0).getTextChannels();
        TicketAmount = TextChannel.size();


      //  System.out.println(TextChannel.get(0).getHistory().retrievePast(50).complete());

    return TextChannel;
    }


}

