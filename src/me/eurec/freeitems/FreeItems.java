package me.eurec.freeitems;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.eurec.freeitems.enchantments.FreeItemEnchantment;
import me.eurec.freeitems.handlers.GuiInteract;
import me.eurec.freeitems.handlers.ItemFrameInteract;

public class FreeItems extends JavaPlugin {

	public static final FreeItemEnchantment FREE_ITEM_ENCHANTMENT = new FreeItemEnchantment();

	@Override
	public void onEnable() {
		Bukkit.getConsoleSender()
				.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eFreeItem&7> &aLoading The Plugin..."));

		if (Enchantment.getByName(FREE_ITEM_ENCHANTMENT.getName()) == null) {
			try {
				Field field = Enchantment.class.getDeclaredField("acceptingNew");
				field.setAccessible(true);
				field.set(null, true);
				Enchantment.registerEnchantment(FREE_ITEM_ENCHANTMENT);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&cThere has been an error registering the Free Item Enchantment &7&o(check stacktrace for more details)&c."));
				Bukkit.getConsoleSender()
						.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cDisabling the plugin."));
			}
		}

		Bukkit.getPluginManager().registerEvents(new ItemFrameInteract(), this);
		Bukkit.getPluginManager().registerEvents(new GuiInteract(), this);

		Bukkit.getConsoleSender()
				.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eFreeItem&7> &aPlugin Enabled."));
	}

	@Override
	public void onDisable() {
		Bukkit.getConsoleSender()
				.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eFreeItem&7> &cPlugin Disabled."));
	}

	public static boolean isFreeItem(ItemStack item) {
		return (item != null && item.getEnchantments().containsKey(FREE_ITEM_ENCHANTMENT));
	}

}