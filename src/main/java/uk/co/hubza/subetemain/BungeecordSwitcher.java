package uk.co.hubza.subetemain;

// by riles

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class BungeecordSwitcher implements PluginMessageListener {
    
    Logger logger = Bukkit.getServer().getLogger();
    
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) return;
        
        logger.log(Level.INFO, "BungeeCord packet recieved.");
    }
    
    public static void SendPlayerToSubServer(String server, Player player) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);
        
        player.sendPluginMessage(subetemain.getInstance(), "BungeeCord", out.toByteArray());
    }
}