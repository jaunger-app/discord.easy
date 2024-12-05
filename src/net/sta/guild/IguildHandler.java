package net.sta.guild;

import lombok.AccessLevel;
import lombok.Setter;
import net.sta.BotManager;
import net.dv8tion.jda.api.entities.Guild;

public class IguildHandler {
	
	@Setter(AccessLevel.PROTECTED) private static String guildId;
	public IguildHandler() {/*causecausecausecause*/}
	public static Guild getGuild() {
		return BotManager.getBot().getGuildById(guildId);
	}
	
	public static Guild getGuildById(String guildId) {
		return BotManager.getBot().getGuildById(guildId);
	}
}
