package me.eurec.freeitems.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.eurec.freeitems.FreeItems;

public class FreeItemFrameGui {

	private final Inventory inventory;

	public FreeItemFrameGui(ItemStack item) {
		this.inventory = Bukkit.createInventory(null, 9, "Get this item for free!");

		ItemStack bordersItem = new ItemStack(Material.STAINED_GLASS_PANE);
		bordersItem.setDurability((short) 7);
		ItemMeta bordersItemMeta = bordersItem.getItemMeta();
		bordersItemMeta.setDisplayName("");
		bordersItem.setItemMeta(bordersItemMeta);

		ItemStack[] contents = new ItemStack[9];
		contents[0] = contents[1] = contents[7] = contents[8] = bordersItem;

		for (int i = 2; i < contents.length - 2; i++) {
			contents[i] = item.clone();
			contents[i].setAmount((int) Math.pow(2, i));
			contents[i].addEnchantment(FreeItems.FREE_ITEM_ENCHANTMENT, 0);
		}

		inventory.setContents(contents);
	}

	public void openGui(Player player) {
		player.openInventory(inventory);
	}

	public boolean hasGuiOpen(Player player) {
		return player.getOpenInventory().getTopInventory().equals(inventory);
	}

}