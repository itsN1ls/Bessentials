package priv.nils.plugins.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static priv.nils.plugins.Bessentials.Prefix;

public class SuicideCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Prefix + ChatColor.RED + "error: player only");
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("bessentials.suicide") || !player.isOp()) {
            player.sendMessage("Unknown command. Type \"/help\" for help.");
            return true;
        }

        // Store the player's original display name
        String originalDisplayName = player.displayName().toString();

        // Temporarily set an empty display name to disable the death message
        player.displayName(Component.empty());

        // Kill the player
        player.setHealth(0.0D);
        Bukkit.broadcastMessage(player.getName() + " uh.. killed themselves.");
        // Restore the player's original display name
        player.displayName(Component.text(originalDisplayName));
        player.sendMessage(Prefix + "suicide.");

        return false;
    }
}
