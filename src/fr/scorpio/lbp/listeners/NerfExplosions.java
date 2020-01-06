package fr.scorpio.lbp.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class NerfExplosions implements Listener {
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlockPlaced();
		if (!p.isOp()) {
			if (e.getBlock().getType() == Material.TNT) {
				e.setCancelled(true);
				b.setType(Material.AIR);
			}
		}
	}

	@EventHandler
	public void onExplode(EntityExplodeEvent e) {
		if ((e.getEntityType() == EntityType.PRIMED_TNT) && (e.getEntityType() == EntityType.CREEPER)) {
			e.setCancelled(true);
		}
	}

}
