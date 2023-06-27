package priv.nils.plugins.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import static priv.nils.plugins.Bessentials.Prefix;

public class BeerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Prefix + ChatColor.RED + "error: player only");
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("bessentials.beer") || !player.isOp()) {
            player.sendMessage("Unknown command. Type \"/help\" for help.");
            return true;
        }
        ItemStack beer = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta meta = beer.getItemMeta();
        SkullMeta skull = (SkullMeta) beer.getItemMeta();
        meta.setDisplayName("Beer");
        skull.setOwner("Thanauser");

        player.getInventory().addItem(beer);


        return false;
    }
}
