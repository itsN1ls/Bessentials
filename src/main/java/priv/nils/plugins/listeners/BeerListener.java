package priv.nils.plugins.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BeerListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
        if (item.getType() == Material.PLAYER_HEAD && item.getItemMeta() != null) {
            if (item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals("Beer")) {

                PotionEffect nausea = new PotionEffect(PotionEffectType.CONFUSION, 120, 2, false, false, false);
                PotionEffect blindness = new PotionEffect(PotionEffectType.BLINDNESS, 20, 2, false, false, false);
                e.getPlayer().addPotionEffect(nausea);
                e.getPlayer().addPotionEffect(blindness);
                item.setType(Material.AIR);
                e.getPlayer().sendMessage("You drank a mug of beer and feel dizzy...");

            }
        }
    }

}
