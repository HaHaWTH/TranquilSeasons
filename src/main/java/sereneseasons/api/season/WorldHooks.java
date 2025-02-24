package sereneseasons.api.season;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sereneseasons.util.ReflectionUtils;

import java.lang.reflect.Method;

public class WorldHooks
{
    private static final String className = "sereneseasons.season.SeasonASMHelper";
    private static final Method METHOD_canSnowAtInSeason = ReflectionUtils.getMethod(className, "canSnowAtInSeason", World.class, BlockPos.class, boolean.class, ISeasonState.class);
    private static final Method METHOD_canBlockFreezeInSeason = ReflectionUtils.getMethod(className, "canBlockFreezeInSeason", World.class, BlockPos.class, boolean.class, ISeasonState.class);
    private static final Method METHOD_isRainingAtInSeason = ReflectionUtils.getMethod(className, "isRainingAtInSeason", World.class, BlockPos.class, ISeasonState.class);
    /**
     * An override of {@link World#canSnowAt(BlockPos, boolean)}
     */
    public static boolean canSnowAtInSeason(World world, BlockPos pos, boolean checkLight, ISeasonState seasonState)
    {
        try
        {
            return (Boolean) METHOD_canSnowAtInSeason.invoke(null, world, pos, checkLight, seasonState);
        }
        catch (Exception e)
        {
            throw new RuntimeException("An error occurred calling canSnowAtInSeason", e);
        }
    }

    /**
     * An override of {@link World#canBlockFreeze(BlockPos, boolean)}
     */
    public static boolean canBlockFreezeInSeason(World world, BlockPos pos, boolean noWaterAdj, ISeasonState seasonState)
    {
        try
        {
            return (Boolean) METHOD_canBlockFreezeInSeason.invoke(null, world, pos, noWaterAdj, seasonState);
        }
        catch (Exception e)
        {
            throw new RuntimeException("An error occurred calling canBlockFreezeInSeason", e);
        }
    }

    /**
     * An override of {@link World#isRainingAt(BlockPos)}
     */
    public static boolean isRainingAtInSeason(World world, BlockPos pos, ISeasonState seasonState)
    {
        try
        {
            return (Boolean) METHOD_isRainingAtInSeason.invoke(null, world, pos, seasonState);
        }
        catch (Exception e)
        {
            throw new RuntimeException("An error occurred calling isRainingAtInSeason", e);
        }
    }


}
