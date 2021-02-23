package me.eurec.freeitems.handlers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.eurec.freeitems.FreeItems;

public class GuiInteract implements Listener {

	@EventHandler
	public void onClickGui(InventoryClickEvent event) {
		ItemStack item = event.getCurrentItem();

		item = event.getCurrentItem();

		if (event.getInventory().getSize() < 3 || FreeItems.isFreeItem(event.getInventory().getContents()[3]))
			event.setCancelled(true);

		if (!(FreeItems.isFreeItem(item)))
			return;

		if (!(event.getWhoClicked() instanceof Player))
			return;

		Player player = (Player) event.getWhoClicked();

		item = item.clone();
		item.removeEnchantment(FreeItems.FREE_ITEM_ENCHANTMENT);

		player.getInventory().addItem(item);

		event.setCancelled(true);
	}

}