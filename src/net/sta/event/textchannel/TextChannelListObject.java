package net.sta.event.textchannel;

import java.util.ArrayList;
import lombok.Getter;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.IPermissionHolder;

public class TextChannelListObject {
	
	public static ArrayList<TextChannelListObject> textChannelList = new ArrayList<>();
	
	
	@Getter Permission permission;
	@Getter final IPermissionHolder iPermisionHolder;
	@Getter final Boolean bool;
	
	public TextChannelListObject(Permission permission, IPermissionHolder iPermissionHolder, Boolean bool){
		this.permission = permission;
		this.iPermisionHolder = iPermissionHolder;
		this.bool = bool;
	}
}
