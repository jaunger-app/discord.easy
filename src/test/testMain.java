package test;

import net.sta.Anotation.Guild;
import net.sta.event.EventPublisher;
import net.sta.event.level.LevelEvent;
import net.sta.managers.BotManager;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.sta.webserver.Webserver;
import test.jdatest.tste;

import javax.security.auth.login.LoginException;

@Guild("1037829795725197383")

public class testMain extends EventPublisher {

  
	public static Boolean on_of = false;
    public static void main(String[] args) throws LoginException, InterruptedException {

        BotManager b = new BotManager("MTA1NjM0NDA5OTM2OTc4NzQ3Mw.GwPFbg.AFTT4X0GDALz74dUfnotQVFn8YJwQltRDZSWTE", Activity.watching("to the Moon"), OnlineStatus.ONLINE);
        Object[] events = {
            new test0(),
            new testMain(),
        };

        Webserver webserver = new Webserver(b.jda);
       // b.addListener(new tste());
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
