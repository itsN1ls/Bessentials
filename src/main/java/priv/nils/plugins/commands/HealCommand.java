package priv.nils.plugins.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static priv.nils.plugins.Bessentials.Prefix;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) sender;

        if (!player.hasPermission("bessentials.heal") || !player.isOp()) {
            player.sendMessage("Unknown command. Type \"/help\" for help.");
            return true;
        }

        if (args.length == 1) {
            Player target = player.getServer().getPlayer(args[0]);
            target.getPlayer().setHealth(20);
            target.getPlayer().setFoodLevel(20);
            target.getPlayer().setSaturation(40);
            player.sendMessage(Prefix + "healed "+target.getName()+".");
            target.sendMessage(Prefix + "you were healed by "+player.getName() + ".");
        }else if(args.length == 0) {
            player.getPlayer().setHealth(20);
            player.getPlayer().setFoodLevel(20);
            player.getPlayer().setSaturation(40);
            player.sendMessage(Prefix + "healed "+player.getName() + ".");
        }else player.sendMessage(Prefix + ChatColor.RED+ "wrong usage");





        return false;
    }
}
