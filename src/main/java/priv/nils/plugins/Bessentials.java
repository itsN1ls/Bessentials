package priv.nils.plugins;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import priv.nils.plugins.commands.*;
import priv.nils.plugins.listeners.BeerListener;


public final class Bessentials extends JavaPlugin {
    public static String Prefix = ChatColor.GOLD+"[Bessentials] ";
    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("flyspeed").setExecutor(new SpeedCommand());
        getCommand("suicide").setExecutor(new SuicideCommand());
        getCommand("beer").setExecutor(new BeerCommand());
        Bukkit.getPluginManager().registerEvents(new BeerListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
