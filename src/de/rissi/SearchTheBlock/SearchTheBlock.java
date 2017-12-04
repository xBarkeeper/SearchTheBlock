package de.rissi.SearchTheBlock;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.rissi.SearchTheBlock.Events.SearchTheBlock_WinEvent;

public class SearchTheBlock extends JavaPlugin implements CommandExecutor, Listener
{
	@Override
	public void onEnable() {
		super.onEnable();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents((Listener) this, this);
		registerCommands();
		registerEvents();
	}

	private void registerCommands() {
		SearchTheBlock_OutsourcingCommands cSearchTheBlock_OutsourcingCommands = new SearchTheBlock_OutsourcingCommands(
				this);
		getCommand("SearchTheBlock").setExecutor(cSearchTheBlock_OutsourcingCommands);
	}
	
	private void registerEvents() {
		new SearchTheBlock_WinEvent(this);
	}

}
