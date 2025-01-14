package net.sta;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandEditAction;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.sta.event.EventPublisher;
import net.sta.event.level.SetvoiceLevel;
import net.sta.event.message.MessageGetter;

import java.util.Objects;

public class BotManager extends EventPublisher implements Debugging{
	
	private static JDA bot;
    private String prefix;

    public void setPrefix(String prefix){
        this.prefix = prefix;
    }
    public String getPrefix() {
        return this.prefix == null ? "!" : this.prefix;
    }
    public static JDA getBot() {
        return bot == null ? null : bot;
    }

    public BotManager(String token, Activity activity, OnlineStatus onlineStatus) {
        createBot(token, onlineStatus, activity);
    }

    private static void createBot(String token, OnlineStatus onlineStatus, Activity activity)  {
        JDABuilder builder = JDABuilder.createDefault(token);

        builder.setChunkingFilter(ChunkingFilter.ALL);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.enableIntents( GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.GUILD_VOICE_STATES,
                GatewayIntent.DIRECT_MESSAGE_TYPING,
                GatewayIntent.DIRECT_MESSAGES,
                GatewayIntent.MESSAGE_CONTENT,
                GatewayIntent.GUILD_INVITES);
        builder.enableCache(CacheFlag.ONLINE_STATUS);
        builder.setStatus(onlineStatus == null ? OnlineStatus.ONLINE : onlineStatus);
        builder.setActivity(activity== null ? Activity.watching("Developer Salzstange") : activity);

        //needed for Levelsystem
        builder.addEventListeners(new MessageGetter());
        builder.addEventListeners(new SetvoiceLevel());

        bot = builder.build();



        try {
            Thread.sleep(650);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

    }



    @SuppressWarnings("unused")
    public CommandEditAction upsertGuildCommand(String name, String desc, Object eventListener) {
        try {
            if (jda.awaitReady().getGuildById(jda.getGuilds().get(0).getId()) == null){
                return null;
            }else {
                jda.awaitReady().addEventListener(eventListener);
                Command cmd = Objects.requireNonNull(jda.awaitReady().getGuildById(jda.getGuilds().get(0).getId())).upsertCommand(name, desc).complete();
                return cmd.editCommand();
            }
        } catch (InterruptedException e) {
            debug().info(e.getMessage());
            Thread.currentThread().interrupt();
        }
        return null;
    }

}
