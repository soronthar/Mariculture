package joshie.mariculture.modules.fishery.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.common.BiomeDictionary;

import static joshie.mariculture.core.lib.MaricultureInfo.MODID;

/** This loot condition checks the biome of the bobber **/
public class InBiomeType extends AbstractWorldLocation {
    private final BiomeDictionary.Type biome;

    public InBiomeType(BiomeDictionary.Type biome) {
        this.biome = biome;
    }

    @Override
    public boolean testCondition(World world, BlockPos pos) {
        return BiomeDictionary.isBiomeOfType(world.getBiome(pos), biome);
    }

    public static class Serializer extends LootCondition.Serializer<InBiomeType> {
        public Serializer() {
            super(new ResourceLocation(MODID, "biome_type"), InBiomeType.class);
        }

        public void serialize(JsonObject json, InBiomeType value, JsonSerializationContext context) {
            json.addProperty("type", value.biome.name().toLowerCase());
        }

        public InBiomeType deserialize(JsonObject json, JsonDeserializationContext context) {
            return new InBiomeType(getType(JsonUtils.getString(json, "type", "plains")));
        }

        private BiomeDictionary.Type getType(String string) {
            return BiomeDictionary.Type.valueOf(string.toUpperCase());
        }
    }
}
