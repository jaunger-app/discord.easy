package net.sta.event.textchannel;

import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.IPermissionHolder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.requests.restaction.ChannelAction;
import java.util.*;

public class PermissionChannelManager {

	@Getter private static List<String> ticketId = new ArrayList<>();
	@Getter private final String categoryId;
	@Getter private TextChannel textChannel;
	@Getter private final Guild guild;
	@Getter @Setter private String textChannelName = "TextChannel";

	public PermissionChannelManager(Guild guild, String categoryId) {		
		this.guild = guild;
		this.categoryId = categoryId;
	}

	public PermissionChannelManager setPermissions(Permission permission, Boolean bool, IPermissionHolder holder) {
		TextChannelListObject.textChannelList.add(new TextChannelListObject(permission, holder, bool));
		return this;
	}

	ChannelAction<TextChannel> action;
	public TextChannel toCreate() {

		ArrayList<TextChannelListObject> list = TextChannelListObject.textChannelList;
		ArrayList<Permission> allowedPermissions = new ArrayList<>();
		ArrayList<Permission> deniedPermissions = new ArrayList<>();

		if (list.isEmpty()) {
			action = guild.getCategoryById(categoryId).createTextChannel(textChannelName);
		}else {
		assert !list.isEmpty();
		for(TextChannelListObject textChannelListObject : list) {
			if (Boolean.TRUE.equals(textChannelListObject.getIsAllowed())) {
				allowedPermissions.add(textChannelListObject.getPermission());
			}else deniedPermissions.add(textChannelListObject.getPermission());


			TextChannelListObject.
			action.addPermissionOverride(TextChannelListObject.getIpermisionholder(), allowedPermissions, deniedPermissions);
			}
			list.remove(0);
			allowedPermissions.clear();
			deniedPermissions.clear();
		}
		textChannel = action.complete();
		ticketId.add(textChannel.getId());
		return textChannel;
	}
	public static TextChannel getTextChannelById(String textChannelID, Guild guild) {
		return guild.getTextChannelById(textChannelID);
	}

	public PermissionChannelManager setName(String textChannelName) {
		this.textChannelName = textChannelName;
		return this;
	}

}
