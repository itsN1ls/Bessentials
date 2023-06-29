package priv.nils.plugins.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectListener implements Listener {

    @EventHandler
    public void onConnect(PlayerJoinEvent e) {
        e.setJoinMessage(ChatColor.GREEN + ""+ChatColor.BOLD+"+ "+ ChatColor.RESET + e.getPlayer().getName());
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent quit) {
        quit.setQuitMessage(ChatColor.RED + ""+ChatColor.BOLD+"- "+ChatColor.RESET + quit.getPlayer().getName());
    }
}
