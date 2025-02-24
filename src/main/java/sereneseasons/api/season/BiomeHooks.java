package sereneseasons.api.season;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import sereneseasons.util.ReflectionUtils;

import java.lang.reflect.Method;

public class BiomeHooks
{
    private static final String className = "sereneseasons.season.SeasonASMHelper";
    private static final Method getFloatTemperature_World_Biome_BlockPos = ReflectionUtils.getMethod(className, "getFloatTemperature", World.class, Biome.class, BlockPos.class);
    private static final Method getFloatTemperature_SubSeason_Biome_BlockPos = ReflectionUtils.getMethod(className, "getFloatTemperature", Season.SubSeason.class, Biome.class, BlockPos.class);
    /**
     * An override of {@link Biome#getFloatTemperature(BlockPos)}
     */
    public static float getFloatTemperature(World world, Biome biome, BlockPos pos)
    {
        try
        {
            return (float) getFloatTemperature_World_Biome_BlockPos.invoke(null, world, biome, pos);
        }
        catch (Exception e)
        {
            throw new RuntimeException("An error occurred calling getFloatTemperature", e);
        }
    }

    /**
     * An override of {@link Biome#getFloatTemperature(BlockPos)}
     */
    public static float getFloatTemperature(Season.SubSeason subSeason, Biome biome, BlockPos pos)
    {
        try
        {
            return (float) getFloatTemperature_SubSeason_Biome_BlockPos.invoke(null, subSeason, biome, pos);
        }
        catch (Exception e)
        {
            throw new RuntimeException("An error occurred calling getFloatTemperature", e);
        }
    }
}
