package priv.nils.plugins.commands;

import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static priv.nils.plugins.Bessentials.Prefix;

public class SpeedCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String string, @NotNull String[] args) {
        Player player = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage(Prefix + NamedTextColor.RED + "error: player only");
            return true;
        }

        if (!player.hasPermission("bessentials.speed") || !player.isOp()) {
            player.sendMessage("Unknown command. Type \"/help\" for help.");
            return true;
        }
        if (args.length == 1) {
            float speed = Float.parseFloat(args[0]);
            player.setFlySpeed(speed);
            player.sendMessage(Prefix + "flySpeed: " + speed + ".");
        } else if (args.length == 2) {
                float speed;
                try {
                    speed = Float.parseFloat(args[1]);
                } catch (NumberFormatException e) {
                    player.sendMessage(Prefix + NamedTextColor.RED + "error: invalid format at arg 1");
                    return true;
                }

                Player target = player.getServer().getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(Prefix + NamedTextColor.RED + "target doesn't exist.");
                    return true;
                }

                target.setFlySpeed(speed);
                player.sendMessage(Prefix + target.getName() + "'s fly speed: " + speed + ".");
                target.sendMessage(Prefix + player.getName() + "set flySpeed: "+speed + ".");
        }






            return false;
    }
}
