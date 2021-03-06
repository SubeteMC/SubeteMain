package uk.co.hubza.subetemain;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class subetemain extends JavaPlugin {
	public static subetemain instance = null;
	
	@Override
    public void onEnable() {
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new BungeecordSwitcher());
		getLogger().info("onEnable has been invoked! The SubeteMain plugin is now active!");
		instance = this;
        // TODO Insert logic to be performed when the plugin is enabled
    }
    
    @Override
    public void onDisable() {
    	getLogger().info("onDisable has been invoked! The SubeteMain plugin is now shutting down.");
        // TODO Insert logic to be performed when the plugin is disabled
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("subete")) {
    		sender.sendMessage(ChatColor.BLUE + "Thanks for playing on Subete! We hope you enjoy the server! Use /help SubeteMain");
    		return true;
    	}
    	else if (cmd.getName().equalsIgnoreCase("subetepl")) {
    		sender.sendMessage(ChatColor.BLUE + "This server uses many plugins created by the spigot and bukkit community (see /pl) and also uses many plugins created by the Subete team. Complete credits will be available at subete.hubza.co.uk/pl but at the moment are not.");
    		return true;
    	}
    	else if (cmd.getName().equalsIgnoreCase("anarchy")) {
    		sender.sendMessage(ChatColor.BLUE + "anarchy time");
    		BungeecordSwitcher.SendPlayerToSubServer("anarchy", (Player) sender);
    		return true;
    	}
            // If this hasn't happened the value of false will be returned.
    	return false; 
    }
    
    public static subetemain getInstance() {
    	 return instance;
    }
    
}
