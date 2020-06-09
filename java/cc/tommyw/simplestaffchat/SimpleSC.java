package cc.tommyw.simplestaffchat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class SimpleSC extends JavaPlugin {

		private static File configFile = new File("plugins/SimpleStaffChat/config.yml");
		private static YamlConfiguration config = new YamlConfiguration();

		public void loadConfiguration() {
			getConfig().options().header("SimpleStaffChat - No clutter, just staffchat.");
			String path = "prefix";
			this.getConfig().addDefault(path, "&7[&4StaffChat&7] &r");
			this.getConfig().options().copyDefaults(true);
			this.saveConfig();
		}

	@Override
	public void onEnable() {
		loadConfiguration();
		this.reloadConfig();
		Metrics metrics = new Metrics(this);
		this.getCommand("sc").setExecutor(new SimpleSCMain(this));
	}
	
	@Override
	public void onDisable() {
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {		
		
		return false;
	}
	
}
