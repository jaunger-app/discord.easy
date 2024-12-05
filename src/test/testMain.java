package test;

import net.sta.commands.Levelcommand;
import net.sta.event.level.LevelEvent;
import net.sta.event.listener.EventAdapter;
import net.sta.BotManager;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.sta.webserver.Webserver;
import test.jdatest.msg1;
import test.jdatest.msg2;


import javax.security.auth.login.LoginException;

public class testMain extends EventAdapter {


    public static Boolean on_of = false;
    public static void main(String[] args) throws LoginException, InterruptedException {

        BotManager b = new BotManager("MTA1NjM0NDA5OTM2OTc4NzQ3Mw.GZNrKS.ZKx_v7J7wqFF6dTbB6AGqOxfB8qzmG06Thgkjs", Activity.watching("to the Moon"), OnlineStatus.ONLINE);
        Object[] events = {
                new testMain(),
                new Levelcommand()
        };


        b.addListener(new msg1());
        b.addListener(new msg2());
        teste.tes();
        //b.addListener(new levelCommand());
       // b.setEvents(new levelCommand());


        //  b.setEvents(new levelCommand());
        //( b.setEvents(new MessageLevel());

        Webserver webserver = new Webserver(b.getBot());
        // b.addListener(new L);
        b.setPrefix("!");

        LevelEvent levelEvent = new LevelEvent(true);
        levelEvent.startLevel();



        /*
        System.out.println(Prefix.getPrefix());
        Webserver webserver = new Webserver(BotManager.jda);

*/
        /*
        Guild ab= testMain.class.getAnnotation(Guild.class);
        if (ab != null) {
            System.out.print(ab.value() + "; ");
        }

         */


        // System.out.println(testMain.class.getAnnotation(Guild.class).value());








    }
}
