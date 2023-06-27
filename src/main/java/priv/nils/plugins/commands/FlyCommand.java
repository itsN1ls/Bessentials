package priv.nils.plugins.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static priv.nils.plugins.Bessentials.Prefix;


public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender s, @NotNull Command cmd, @NotNull String string, @NotNull String[] args) {

        Player player = (Player) s;
        boolean fly = player.getAllowFlight();
        if(player.hasPermission("bessentials.fly") || player.isOp()) {
            player.setAllowFlight(!(fly));
            player.setFlying(!(fly));
            fly = !fly;
            player.sendMessage(Prefix +"flying: "+fly+".");
        }else player.sendMessage("Unknown command. Type \"/help\" for help.");




        return false;
    }
}
