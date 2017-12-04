package de.rissi.SearchTheBlock.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.rissi.SearchTheBlock.SearchTheBlock_Values;

public class SearchTheBlock_CreateArena
{

	public static boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if (args.length == 1)
		{
			String arenaName = args[0];
			String world = p.getWorld().getName();
			
			SearchTheBlock_Values.loadFile();

			if (!SearchTheBlock_Values.CFG.contains(args[0]))
			{
				SearchTheBlock_Values.CFG.set(arenaName + "." + "world", world);
				SearchTheBlock_Values.saveFile();
				p.sendMessage(SearchTheBlock_Values.ARENACREATED);
			} else
				p.sendMessage(SearchTheBlock_Values.ARENAALREDYEXIST);

		} else
		{
			p.sendMessage(SearchTheBlock_Values.USECREATEARENACOMMAND);
		}
		return true;
	}

}
