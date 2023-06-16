package com.mcxufly.positivee.undergroundfire;

import com.mcxufly.positivee.undergroundfire.block.entity.BlockEntityRegistry;
import com.mcxufly.positivee.undergroundfire.item.ItemRegistry;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import com.mcxufly.positivee.undergroundfire.block.BlockRegistry;
import com.mcxufly.positivee.undergroundfire.client.gui.menu.MenuRegistry;
import com.mcxufly.positivee.undergroundfire.client.gui.screen.ScreenRegistry;

@Mod(UndergroundFire.MODID)
public class UndergroundFire
{
	public static final String MODID = "undergroundfire";
	private static final Logger LOGGER = LogUtils.getLogger();

	public UndergroundFire()
	{


		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);
		bus.addListener(this::clientSetup);

		MinecraftForge.EVENT_BUS.register(this);

		ItemRegistry.ITEMS.register(bus);
		BlockRegistry.BLOCKS.register(bus);
		BlockEntityRegistry.BLOCK_ENTITIES.register(bus);
		MenuRegistry.MENU.register(bus);
	}

	public void clientSetup(FMLClientSetupEvent event)
	{
		ScreenRegistry.register();
	}

	private void setup(final FMLCommonSetupEvent event)
	{
	}
}