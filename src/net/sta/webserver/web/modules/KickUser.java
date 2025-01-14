package net.sta.webserver.web.modules;
import net.dv8tion.jda.api.entities.Member;
import net.sta.BotManager;

import java.time.Instant;

public class KickUser {


    private String uuid;
    private String reason;
    private Integer ChannelId = 12313;

    public KickUser(String userId, String kickReason){
        this.uuid = userId;
        this.reason = kickReason;
        userGetKicked();
    }


    private void userGetKicked(){
        Member member = BotManager.getBot().getGuilds().get(0).getMemberById(uuid);
        member.kick(reason).queue();

        if (ChannelId != null){
            BotManager.getBot().getGuilds().get(0).getTextChannelById("1037868392117436488").sendMessage("User: " + member.getEffectiveName() + " wurde gekickt am " + Instant.now()).queue();
        }

    }
}
