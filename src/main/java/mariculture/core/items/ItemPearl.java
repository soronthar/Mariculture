package mariculture.core.items;

import java.util.List;
import java.util.Random;

import mariculture.core.helpers.SpawnItemHelper;
import mariculture.core.lib.PearlColor;
import mariculture.core.util.Rand;
import mariculture.magic.Magic;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPearl extends ItemMariculture {
	@Override
	public int getMetaCount() {
		return PearlColor.COUNT;
	}
	
	@Override
	public int getItemEnchantability() {
        return 2;
    }
	
	@Override
	public boolean isItemTool(ItemStack stack) {
        return true;
    }

	@Override
	public String getName(ItemStack stack) {
		String name = "";
		switch (stack.getItemDamage()) {
			case PearlColor.WHITE:	return "pearlWhite";
			case PearlColor.GREEN:	return "pearlGreen";
			case PearlColor.YELLOW: return "pearlYellow";
			case PearlColor.ORANGE: return "pearlOrange";
			case PearlColor.RED: 	return "pearlRed";
			case PearlColor.GOLD: 	return "pearlGold";
			case PearlColor.BROWN: 	return "pearlBrown";
			case PearlColor.PURPLE: return "pearlPurple";
			case PearlColor.BLUE: 	return "pearlBlue";
			case PearlColor.BLACK: 	return "pearlBlack";
			case PearlColor.PINK:	return "pearlPink";
			case PearlColor.SILVER: return "pearlSilver";
			default: 				return "pearl";
		}
	}

	public Enchantment getBiasedEnchantment(Random rand, int level, int dmg) {
		switch (dmg) {
			case PearlColor.WHITE:	return (level > 55 && rand.nextInt(5) == 0)? Magic.flight: null;
			case PearlColor.GREEN:	return (rand.nextInt(5) == 0)? Magic.jump: null;
			case PearlColor.YELLOW: return (level > 45 && rand.nextInt(6) == 0)? Magic.hungry: null;
			case PearlColor.ORANGE: return (level > 40 && rand.nextInt(6) == 0)? Magic.repair: null;
			case PearlColor.RED: 	return (level > 30 && rand.nextInt(6) == 0)? Magic.health: null;
			case PearlColor.GOLD: 	return (rand.nextInt(5) == 0)? Magic.fall: null;
			case PearlColor.BROWN: 	return (rand.nextInt(8) == 0)? Magic.stepUp: null;
			case PearlColor.PURPLE: return (rand.nextInt(10) == 0)? Magic.glide: null;
			case PearlColor.BLUE: 	return (rand.nextInt(6) == 0)? Magic.speed: null;
			case PearlColor.BLACK: 	return (rand.nextInt(12) == 0)? Magic.spider: null;
			case PearlColor.PINK:	return (level > 50 && rand.nextInt(6) == 0)? Magic.resurrection: null;
			case PearlColor.SILVER: return (rand.nextInt(6) == 0)? Enchantment.unbreaking: null;
			default: 				return null;
		}
	}
}
