package fr.scorpio.lbp.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.scorpio.lbp.Main;

public class HelpCmd implements CommandExecutor {
	public Main main;

	public HelpCmd(Main main) {
		this.main = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (!(sender instanceof Player) && (cmd.getName().equalsIgnoreCase("help"))) {

			sender.sendMessage(ChatColor.DARK_RED + "Tu dois être un joueur.");

		} else {

			Player p = (Player) sender;

			p.sendMessage(
					main.getPrefix() + "§9Voici l'aide du serveur :" + "\n§f- §aHelp &f: §7Affiche la page d'aide ;"
							+ "\n§f- §aRegles §f: §7Affiche les règles du serveur ;"
							+ "\n§f- §aClans §f: §7Téléporte à la salle des clans ;"
							+ "\n§f- §aSpawn §f: §7Téléporte au spawn ;");
			if (p.hasPermission("lbp.help")) {
				p.sendMessage("\n§f- §cInvsee §f: §7Ouvre l'inventaire d'un joueur ;"
							+ "\n§f- §cRank §f: §7Permet de modifier le grade d'un joueur ;");
			}
		}
		return false;
	}
}
