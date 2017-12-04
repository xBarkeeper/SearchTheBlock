package de.rissi.SearchTheBlock.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.rissi.SearchTheBlock.SearchTheBlock_Values;

public class SearchTheBlock_StartGame
{

	@SuppressWarnings("deprecation")
	public static boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if (args.length == 1)
		{
			SearchTheBlock_Values.loadFile();
			
			if (SearchTheBlock_Values.CFG.contains(args[0]))
			{
				p.sendMessage("test");
				String world = SearchTheBlock_Values.CFG.getString(args[0] + "." + "world");
				int x = getRandomPosition(SearchTheBlock_Values.CFG.getInt(args[0] + "." + "pos1" + "." + "x"),
						SearchTheBlock_Values.CFG.getInt(args[0] + "." + "pos2" + "." + "x"));
				int z = getRandomPosition(SearchTheBlock_Values.CFG.getInt(args[0] + "." + "pos1" + "." + "z"),
						SearchTheBlock_Values.CFG.getInt(args[0] + "." + "pos2" + "." + "z"));

				Location rdmLoc = new Location(Bukkit.getWorld(world), x, 100, z);
				
				Bukkit.getWorld(world).spawnFallingBlock(rdmLoc, 33, (byte) 7);
				
				p.sendMessage(SearchTheBlock_Values.GAMESTARTED);
			}else {
				p.sendMessage(SearchTheBlock_Values.ARENADOESENTEXIST);
			}
		} else
		{
			p.sendMessage(SearchTheBlock_Values.USESTARTCOMMAND);
		}
		return true;
	}

	public static int getRandomPosition(int pos1, int pos2) {

		int difference;

		if (pos1 > pos2)
		{
			difference = pos1 - pos2;
			return (pos2 + SearchTheBlock_Values.RDM.nextInt(difference - 1)) + 1;
		} else
		{
			difference = pos2 - pos1;
			return (pos1 + SearchTheBlock_Values.RDM.nextInt(difference - 1)) + 1;
		}
	}

}
