package me.eurec.freeitems.handlers;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.eurec.freeitems.gui.FreeItemFrameGui;

public class ItemFrameInteract implements Listener {

	@EventHandler
	public void onInteractWithFrame(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		Entity entity = event.getRightClicked();

		if (!(entity instanceof ItemFrame))
			return;

		if (player.isSneaking())
			return;

		ItemFrame itemFrame = (ItemFrame) entity;
		ItemStack item = itemFrame.getItem();

		if (item == null || item.getType() == Material.AIR)
			return;

		new FreeItemFrameGui(item).openGui(player);
		event.setCancelled(true);
	}

}