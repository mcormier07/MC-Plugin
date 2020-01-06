package fr.scorpio.lbp.cmd.tp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.scorpio.lbp.Main;

public class ClanCmd implements CommandExecutor {

	private Main main;

	public ClanCmd(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (!(sender instanceof Player) && cmd.getName().equalsIgnoreCase("clans"))
			sender.sendMessage(main.getPrefix() + "§4Tu dois être un joueur.");

		Player p = (Player) sender;
		p.teleport(new Location(Bukkit.getWorld("survie"), 0.5D, 56D, 0.5D));
		return false;
	}

}
