package priv.nils.plugins.commands;

import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import static priv.nils.plugins.Bessentials.Prefix;

public class RepairCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Prefix + NamedTextColor.RED + "Error: Only players can use this command.");
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("bessentials.repair") && !player.isOp()) {
            player.sendMessage("Unknown command. Type \"/help\" for help.");
            return true;
        }

        if (args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase("all"))) {
            ItemStack itemInHand = player.getItemInHand();

            if (itemInHand == null || itemInHand.getType() == Material.AIR) {
                player.sendMessage(Prefix + "You are not holding an item.");
                return true;
            }

            if (args.length == 1 && args[0].equalsIgnoreCase("all")) {
                for (ItemStack item : player.getInventory().getContents()) {
                    repairItem(item);
                }
                player.sendMessage(Prefix + "All items repaired.");
            } else {
                repairItem(itemInHand);
                player.sendMessage(Prefix + "Item " + getItemDisplayName(itemInHand) + " repaired.");
            }
        } else {
            player.sendMessage(Prefix + "usage: /repair [all]");
        }

        return true;
    }

    private void repairItem(ItemStack item) {
        if (item != null && item.getType() != Material.AIR) {
            item.setDurability((short) 0);
        }
    }

    private String getItemDisplayName(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null && meta.hasDisplayName()) {
            return meta.getDisplayName();
        }
        return item.getType().name();
    }
}
