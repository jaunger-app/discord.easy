package net.sta.webserver.web.modules;

import net.dv8tion.jda.api.entities.Member;
import net.sta.BotManager;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class BanUser {

    private String uuid;
    private String reason;

    private Integer ChannelId = 123123;

    public BanUser(String userId, String bannreason){
        this.uuid = userId;
        this.reason = bannreason;
        userGetBanned();
    }

    private void userGetBanned(){

        Member member = BotManager.getBot().getGuilds().get(0).getMemberById(uuid);
        member.ban(1, TimeUnit.DAYS).reason(reason).queue();

        if (ChannelId != null){
            BotManager.getBot().getGuilds().get(0).getTextChannelById("1037868392117436488").sendMessage("User: " + member.getEffectiveName() + " wurde gebannt am " + Instant.now()).queue();
        }
    }
}
