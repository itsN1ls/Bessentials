package priv.nils.plugins.commands;

import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.bukkit.entity.Item;

import static priv.nils.plugins.Bessentials.Prefix;

public class RepairCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Prefix + NamedTextColor.RED + "error: player only");
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("bessentials.repair") || !player.isOp()) {
            player.sendMessage("Unknown command. Type \"/help\" for help.");
            return true;
        }
        if (args.length == 0) {
            player.getItemInHand().setDurability((short) 0);
            player.sendMessage(Prefix + "item "+player.getItemInHand().getItemMeta().displayName() + " repaired.");
        }











        return false;
    }
}
