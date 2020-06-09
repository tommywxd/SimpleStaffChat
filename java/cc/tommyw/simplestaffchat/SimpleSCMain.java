package cc.tommyw.simplestaffchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SimpleSCMain implements CommandExecutor {

	private final SimpleSC plugin;
	
	public SimpleSCMain(SimpleSC plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender pSender, Command pCmd, String arg2, String[] arg3) {
		if (pSender.hasPermission("staffchat.send")) {
			Player lPlayer = (Player) pSender;
			String colored = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix"));
			String SenderName = ((Player) pSender).getDisplayName();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arg3.length; i++){
				sb.append(arg3[i]).append(" ");
			}

			String allArgs = sb.toString().trim();
			Bukkit.broadcast(colored + ChatColor.WHITE + SenderName + ": " + allArgs, "staffchat.receive");
			return true;
		} else {
			pSender.sendMessage(ChatColor.RED + "You do not have permissions to perform this command!");
		}
		return true;
	}
}
