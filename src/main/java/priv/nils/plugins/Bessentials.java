package priv.nils.plugins;

import net.kyori.adventure.text.format.NamedTextColor;

import org.bukkit.plugin.java.JavaPlugin;
import priv.nils.plugins.commands.FlyCommand;
import priv.nils.plugins.commands.GamemodeCommand;



public final class Bessentials extends JavaPlugin {
    public static String Prefix = NamedTextColor.GOLD+"[Bessentials] ";
    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
