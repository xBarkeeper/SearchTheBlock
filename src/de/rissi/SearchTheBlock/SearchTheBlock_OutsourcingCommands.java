package de.rissi.SearchTheBlock;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import de.rissi.SearchTheBlock.Commands.*;

public class SearchTheBlock_OutsourcingCommands implements CommandExecutor
{

	@SuppressWarnings("unused")
	private SearchTheBlock plugin;

	public SearchTheBlock_OutsourcingCommands(SearchTheBlock plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args[0].equalsIgnoreCase("start"))
			SearchTheBlock_StartGame.onCommand(sender, cmd, label, shortArgs(args));
		else if(args[0].equalsIgnoreCase("createArena"))
			SearchTheBlock_CreateArena.onCommand(sender, cmd, label, shortArgs(args));
		else if(args[0].equalsIgnoreCase("setLoc"))
			SearchTheBlock_SetArenaLocation.onCommand(sender, cmd, label, shortArgs(args));
	
		return true;
	}
	
	public String[] shortArgs(String[] args) {
		String[] newArgs = new String[ (args.length-1) ];
		for(int i=1; i<args.length; i++) {
			newArgs[i-1] = args[i];
		}
		return newArgs;
	}

}
