package net.sta.webserver.web.modules;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;

import java.util.concurrent.TimeUnit;

import static net.sta.managers.BotManager.jda;

public class BanUser {

    private String uuid;
    private String reason;

    private Integer Time;

    public BanUser(String userId, String kickReason){
        this.uuid = userId;
        this.reason = kickReason;
        userGetBanned();
    }


    private void userGetBanned(){
        Member member = jda.getGuilds().get(0).getMemberById(uuid);
        AuditableRestAction<Void> banUnit;

        switch(Time){
            case 1:
                banUnit = member.ban(Time, TimeUnit.DAYS);
            case 2:


        }



        if (reason.isEmpty()){
            member.ban(1, TimeUnit.DAYS).reason("Keine Begründung Angegeben");
        }else {
            member.ban(2, TimeUnit.DAYS).reason(reason);
        }
    }
}
