package de.rissi.SearchTheBlock.Events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.rissi.SearchTheBlock.SearchTheBlock;

public class SearchTheBlock_WinEvent implements Listener
{

	@SuppressWarnings("unused")
	private SearchTheBlock plugin;

	public SearchTheBlock_WinEvent(SearchTheBlock searchTheBlock)
	{
		this.plugin = searchTheBlock;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getData() == 12)
		{
			event.getClickedBlock().setType(Material.AIR);
		}
	}

}
