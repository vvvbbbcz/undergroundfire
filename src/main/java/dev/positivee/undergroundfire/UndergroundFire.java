package dev.positivee.undergroundfire;

import com.mojang.logging.LogUtils;
import dev.positivee.undergroundfire.block.BlockRegistry;
import dev.positivee.undergroundfire.block.entity.BlockEntityRegistry;
import dev.positivee.undergroundfire.creative.CreativeTabRegistry;
import dev.positivee.undergroundfire.item.ItemRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

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
		BlockEntityRegistry.BLOCK_ENTITY_TYPE.register(bus);
		CreativeTabRegistry.CREATIVE_MODE_TAB.register(bus);
	}

	public void clientSetup(FMLClientSetupEvent event)
	{
	}

	private void setup(final FMLCommonSetupEvent event)
	{
	}
}