package net.sta.event.permissions;

import net.sta.guild.IguildHandler;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.IPermissionHolder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;

public class Ipermission {
	
	private final IPermissionHolder ipermissionholder;
	private Member member = null;
	private User user; 
	private Role role = null;
	private final Guild guild = IguildHandler.getGuild();
	
	
	public Ipermission(IPermissionHolder ipermissionholder) {
		this.ipermissionholder = ipermissionholder;
		checkInputs();
	}
	
	public IPermissionHolder iPermissionHolder() {
		if(member == null) {
			return role;
		}else if (role == null){
			return member;
		}
		return null;	
	}
	
	private void checkInputs() {
		
		if (ipermissionholder instanceof Member)
			this.member = guild.getMemberById(ipermissionholder.getId());
		if (ipermissionholder instanceof Role)
			this.role = guild.getRoleById(ipermissionholder.getId());
	}
	
	public Role getAsRole() {
		return role;
	}
	
	public Member getAsMember() {
		return member;
	}
	
	public User getAsUser() {
		return user;
	}
}
