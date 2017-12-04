package de.rissi.SearchTheBlock.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.rissi.SearchTheBlock.SearchTheBlock_Values;

public class SearchTheBlock_SetArenaLocation
{

	public static boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if (args.length == 2)
		{
			int x = (int) Math.round(p.getLocation().getX());
			int z = (int) Math.round(p.getLocation().getZ());

			SearchTheBlock_Values.loadFile();

			switch (args[1])
			{
				case "pos1":
					if (SearchTheBlock_Values.CFG.contains(args[0]))
					{
						SearchTheBlock_Values.CFG.set(args[0] + "." + "pos1" + "." + "x", x);
						SearchTheBlock_Values.CFG.set(args[0] + "." + "pos1" + "." + "z", z);
						p.sendMessage(SearchTheBlock_Values.LOCATIONSET);
					} else
					{
						p.sendMessage(SearchTheBlock_Values.ARENADOESENTEXIST);
					}
					break;
				case "pos2":
					if (SearchTheBlock_Values.CFG.contains(args[0]))
					{
						SearchTheBlock_Values.CFG.set(args[0] + "." + "pos2" + "." + "x", x);
						SearchTheBlock_Values.CFG.set(args[0] + "." + "pos2" + "." + "z", z);
						p.sendMessage(SearchTheBlock_Values.LOCATIONSET);
					} else
					{
						p.sendMessage(SearchTheBlock_Values.ARENADOESENTEXIST);
					}
					break;
				default:
					p.sendMessage(SearchTheBlock_Values.USESETLOCCOMMAND);
					break;
			}

			SearchTheBlock_Values.saveFile();
		} else
		{
			p.sendMessage(SearchTheBlock_Values.USESETLOCCOMMAND);
		}
		return true;
	}

}
