package fr.scorpio.lbp.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
//import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.scorpio.lbp.Main;

public class DeathEvent implements Listener {

	public Main main;

	public DeathEvent(Main main) {
		this.main = main;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDie(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			e.setDeathMessage("");
		}
		ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
		ItemMeta sm = item.getItemMeta();
		((SkullMeta) sm).setOwner(e.getEntity().getName());
		item.setItemMeta(sm);

		e.getDrops().add(item);
	}

//	@EventHandler
//	public void onDeath(EntityDamageByEntityEvent e) {
//		if (e.getEntity() instanceof Player) {
//			Player p = (Player) e.getEntity();
//
//			double health = p.getHealth();
//			double damage = e.getDamage();
//			if (damage >= health) {
//				if (p instanceof Player) {
//					Bukkit.broadcastMessage("§6" + p.getName() + "§7 a été tué par §6" + p.getKiller().getName());
//					p.setHealth(0);
//				}
//			}
//		}
//	}

	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		Entity ent = e.getEntity();
		EntityDamageEvent ede = ent.getLastDamageCause();
		EntityDamageEvent.DamageCause dc = ede.getCause();
		if (ent instanceof Player) {
			if (dc == EntityDamageEvent.DamageCause.FALL) {
				Player p = (Player) ent;
				Bukkit.broadcastMessage("§b§o" + p.getName() + "§7 est tombé de haut.");
			} else if (dc == EntityDamageEvent.DamageCause.DROWNING) {
				Player p = (Player) ent;
				Bukkit.broadcastMessage("§b§o" + p.getName() + "§7 s'est noyé.");
			} else if (dc == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION
					|| dc == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
				Player p = (Player) ent;
				Bukkit.broadcastMessage("§b§o" + p.getName() + "§7 a explosé.");
			} else if (dc == EntityDamageEvent.DamageCause.LIGHTNING) {
				Player p = (Player) ent;
				Bukkit.broadcastMessage("§b§o" + p.getName() + "§7 a été foudroyé.");
			} else if (dc == EntityDamageEvent.DamageCause.SUFFOCATION) {
				Player p = (Player) ent;
				Bukkit.broadcastMessage("§b§o" + p.getName() + "§7 a été étouffé.");
			} else if (dc == EntityDamageEvent.DamageCause.VOID) {
				Player p = (Player) ent;
				Bukkit.broadcastMessage("§b§o" + p.getName() + "§7 a sauté dans le vide.");
			} else if (dc == EntityDamageEvent.DamageCause.SUICIDE) {
				Player p = (Player) ent;
				Bukkit.broadcastMessage("§b§o" + p.getName() + "§7 s'est suicidé.");
			} else if (dc == EntityDamageEvent.DamageCause.FIRE || dc == EntityDamageEvent.DamageCause.FIRE_TICK) {
				Player p = (Player) ent;
				Bukkit.broadcastMessage("§b§o" + p.getName() + "§7 a brûlé.");
			} else if (dc == EntityDamageEvent.DamageCause.FLY_INTO_WALL) {
				Player p = (Player) ent;
				Bukkit.broadcastMessage("§b§o" + p.getName() + "§7 s'est prit un mur.");
			} else if (dc == EntityDamageEvent.DamageCause.LAVA) {
				Player p = (Player) ent;
				Bukkit.broadcastMessage("§b§o" + p.getName() + "§7 a tenté de nager dans la lave.");
			} else if (dc == EntityDamageEvent.DamageCause.DRAGON_BREATH) {
				Player p = (Player) ent;
				Bukkit.broadcastMessage("§b§o" + p.getName() + "§7 a essayé de battre l'Ender Dragon.");
			} else if (dc == EntityDamageEvent.DamageCause.HOT_FLOOR) {
				Player p = (Player) ent;
				Bukkit.broadcastMessage("§b§o" + p.getName() + "§7 a marché sur un bloc de magma.");
			}
		}
	}

}
