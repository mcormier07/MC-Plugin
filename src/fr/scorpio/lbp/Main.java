package fr.scorpio.lbp;

import fr.scorpio.lbp.cmd.HelpCmd;
import fr.scorpio.lbp.cmd.tp.ClanCmd;
import fr.scorpio.lbp.cmd.tp.SpawnCmd;
import fr.scorpio.lbp.listeners.DeathEvent;
import fr.scorpio.lbp.listeners.NerfExplosions;
import fr.scorpio.lbp.listeners.PlayerListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static Main instance;
	public String prefix = "§6[Lives de Boblennon] ";

	public static Main getInstane() {
		return instance;
	}

	public void onEnable() {

		instance = this;

		System.out.println("Le plugin est actif");

		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new PlayerListeners(this), this);
		pm.registerEvents(new NerfExplosions(), this);
		pm.registerEvents(new DeathEvent(this), this);

		getCommand("help").setExecutor(new HelpCmd(this));
		getCommand("clans").setExecutor(new ClanCmd(this));
		getCommand("spawn").setExecutor(new SpawnCmd(this));
	}

	public void onDisable() {
		System.out.println("Le plugin est inactif");
	}
	
	public String getPrefix() {
		return prefix;
	}
}
