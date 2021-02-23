package me.eurec.freeitems.enchantments;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class FreeItemEnchantment extends Enchantment {

	/** ID: 105 
	 *	This enchantment is used to distinguish free items inside of inventories.
	 **/
	public FreeItemEnchantment() {
		super(105);
	}

	@Override
	public boolean canEnchantItem(ItemStack arg0) {
		return true;
	}

	@Override
	public boolean conflictsWith(Enchantment arg0) {
		return false;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return null;
	}

	@Override
	public int getMaxLevel() {
		return 0;
	}

	@Override
	public String getName() {
		return "FreeItem";
	}

	@Override
	public int getStartLevel() {
		return 0;
	}
	
}