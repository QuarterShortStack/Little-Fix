package com.qss.lilfix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lothrazar.cyclic.item.baublefixed.CharmAntidote;
import com.lothrazar.cyclic.item.baublefixed.CharmFire;
import com.lothrazar.cyclic.item.baublefixed.CharmOverpowered;
import com.lothrazar.cyclic.item.baublefixed.CharmVoid;
import com.lothrazar.cyclic.item.baublefixed.CharmWither;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("lilfix")
public class LittleFix {
	// Directly reference a log4j logger.
	public static final Logger LOGGER = LogManager.getLogger();

	public LittleFix() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {

		}

		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
			IForgeRegistry<Item> r = event.getRegistry();
			LOGGER.info("[lilfix] replacing cyclic charms with 1.15 varients");
			r.register(new CharmOverpowered(new Item.Properties().group(com.lothrazar.cyclic.CyclicRegistry.itemGroup).maxDamage(256)).setRegistryName(com.lothrazar.cyclic.ModCyclic.MODID, "charm_ultimate"));
			r.register(new CharmWither(new Item.Properties().group(com.lothrazar.cyclic.CyclicRegistry.itemGroup).maxDamage(64)).setRegistryName(com.lothrazar.cyclic.ModCyclic.MODID, "charm_wither"));
			r.register(new CharmFire(new Item.Properties().group(com.lothrazar.cyclic.CyclicRegistry.itemGroup).maxDamage(64)).setRegistryName(com.lothrazar.cyclic.ModCyclic.MODID, "charm_fire"));
			r.register(new CharmAntidote(new Item.Properties().group(com.lothrazar.cyclic.CyclicRegistry.itemGroup).maxDamage(64)).setRegistryName(com.lothrazar.cyclic.ModCyclic.MODID, "charm_antidote"));
		    r.register(new CharmVoid(new Item.Properties().group(com.lothrazar.cyclic.CyclicRegistry.itemGroup).maxDamage(64)).setRegistryName(com.lothrazar.cyclic.ModCyclic.MODID, "charm_void"));
		}
	}
}
