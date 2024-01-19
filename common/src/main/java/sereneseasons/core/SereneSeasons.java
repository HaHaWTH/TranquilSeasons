/*******************************************************************************
 * Copyright 2024, the Glitchfiend Team.
 * All rights reserved.
 ******************************************************************************/
package sereneseasons.core;

import glitchcore.event.EventManager;
import glitchcore.util.Environment;
import glitchcore.util.RegistryHelper;
import net.minecraft.core.registries.Registries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sereneseasons.command.SeasonCommands;
import sereneseasons.init.*;
import sereneseasons.season.RandomUpdateHandler;
import sereneseasons.season.SeasonHandler;

public class SereneSeasons
{
    public static final String MOD_ID = "sereneseasons";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static void init()
    {
        ModConfig.init();
        ModTags.setup();
        addRegistrars();
        addHandlers();
        ModGameRules.init();
        ModPackets.init();
        ModAPI.init();
    }

    private static void addRegistrars()
    {
        var regHelper = RegistryHelper.create();
        regHelper.addRegistrar(Registries.BLOCK, ModBlocks::registerBlocks);
        regHelper.addRegistrar(Registries.BLOCK_ENTITY_TYPE, ModBlockEntities::registerBlockEntities);
        regHelper.addRegistrar(Registries.ITEM, ModItems::setup);
        regHelper.addRegistrar(Registries.CREATIVE_MODE_TAB, ModCreativeTab::registerCreativeTabs);
        regHelper.addRegistrar(Registries.COMMAND_ARGUMENT_TYPE, SeasonCommands::registerArguments);
    }

    private static void addHandlers()
    {
        EventManager.addListener(SeasonHandler::onLevelTick);
        EventManager.addListener(SeasonHandler::onJoinLevel);
        EventManager.addListener(RandomUpdateHandler::onWorldTick);
        EventManager.addListener(SeasonCommands::onRegisterCommands);

        if (Environment.isClient())
        {
            ModClient.addClientHandlers();
        }
    }
}
