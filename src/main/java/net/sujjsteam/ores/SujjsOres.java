package net.sujjsteam.ores;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.sujjsteam.ores.compat.mekanism.MekanismCompat;
import net.sujjsteam.ores.registry.ModBlocks;
import net.sujjsteam.ores.registry.ModCreativeTabs;
import net.sujjsteam.ores.registry.ModItems;

@Mod(SujjsOres.MOD_ID)
public class SujjsOres {

    public static final String MOD_ID = "sujjsores";

    public SujjsOres(IEventBus modEventBus) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.TABS.register(modEventBus);
        if (ModList.get().isLoaded("mekanism")) {
            MekanismCompat.register(modEventBus);
        }
    }
}
