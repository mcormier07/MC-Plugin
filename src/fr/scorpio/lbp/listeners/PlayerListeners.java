package fr.scorpio.lbp.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.scorpio.lbp.Main;

public class PlayerListeners implements Listener {
	
	public Main main;
	
	public PlayerListeners(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent pje) {
		Player p = pje.getPlayer();
		Bukkit.broadcastMessage(main.getPrefix() + "§9" + p.getName() + "§a a rejoint le serveur !");
		pje.setJoinMessage("");
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent pqe) {
		Player p = pqe.getPlayer();
		Bukkit.broadcastMessage(main.getPrefix() + "§9" + p.getName() + "§c a quitté le serveur !");
		pqe.setQuitMessage("");
	}
}
