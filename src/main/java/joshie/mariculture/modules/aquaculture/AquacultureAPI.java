package joshie.mariculture.modules.aquaculture;

import joshie.mariculture.core.util.StackHolder;
import joshie.mariculture.modules.EventAPIContainer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@EventAPIContainer(modules = "aquaculture")
public class AquacultureAPI implements joshie.mariculture.api.aquaculture.Aquaculture {
    private static final Set<StackHolder> SANDS = new HashSet<>();
    private static final Map<StackHolder, String> TEXTURES = new HashMap<>();

    public AquacultureAPI() {
        registerSand(new ItemStack(Blocks.SAND, 1, 0), "minecraft:blocks/sand");
        registerSand(new ItemStack(Blocks.SAND, 1, 1), "minecraft:blocks/red_sand");
    }

    public static boolean isSand(ItemStack stack) {
        return SANDS.contains(StackHolder.of(stack));
    }

    public static String getTexture(ItemStack stack) {
        return TEXTURES.get(StackHolder.of(stack));
    }

    @Override
    public void registerSand(ItemStack stack, String texture) {
        StackHolder holder = StackHolder.of(stack);
        AquacultureAPI.SANDS.add(holder);
        AquacultureAPI.TEXTURES.put(holder, texture);
    }
}
