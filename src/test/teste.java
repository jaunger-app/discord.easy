package test;

import net.sta.BotManager;
import net.sta.event.listener.EventAdapter;

import net.dv8tion.jda.api.entities.Member;

import java.util.ArrayList;
import java.util.List;


public class teste extends EventAdapter {

    public static void tes() {

        Member lastwinner = null;

        List<Member> members2 = new ArrayList<>();
        BotManager.getBot().getGuildById("1037829795725197383").getMembers().forEach(Member -> members2.add(Member));



        for (int i = 0; i < 10; i++) {

        }



    }




}
