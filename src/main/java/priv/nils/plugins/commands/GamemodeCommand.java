package priv.nils.plugins.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static priv.nils.plugins.Bessentials.Prefix;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission("bessentials.gamemode") || !player.isOp()) {
            player.sendMessage("Unknown command. Type \"/help\" for help.");
            return true;
        }

        GameMode targetGameMode = getTargetGameMode(args[0]);

        if (targetGameMode == null) {
            player.sendMessage("Invalid gamemode specified.");
            return true;
        }

        player.setGameMode(targetGameMode);
        player.sendMessage(Prefix + "gamemode: " + targetGameMode.toString() + ".");
        return true;
    }

    private GameMode getTargetGameMode(String gamemodeArg) {
        GameMode bestMatch = null;
        int bestMatchLength = Integer.MAX_VALUE;

        for (GameMode gameMode : GameMode.values()) {
            String gameModeName = gameMode.name().toLowerCase();

            if (gameModeName.startsWith(gamemodeArg.toLowerCase())) {
                int matchLength = gameModeName.length() - gamemodeArg.length();

                if (matchLength < bestMatchLength) {
                    bestMatch = gameMode;
                    bestMatchLength = matchLength;
                }

                if (matchLength == 0) {
                    // Exact match found, no need to search further
                    break;
                }
            }
        }

        return bestMatch;
    }
}
