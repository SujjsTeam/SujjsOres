package net.sujjsteam.ores.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sujjsteam.ores.SujjsOres;
import net.sujjsteam.ores.material.AlloyMaterial;
import net.sujjsteam.ores.material.GemMaterial;
import net.sujjsteam.ores.material.OreMaterial;

import java.util.List;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SujjsOres.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SUJJS_ORES = TABS.register("sujjsores_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.sujjsores"))
                    .icon(() -> ModItems.INGOTS.get(OreMaterial.URANIUM).get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        for (OreMaterial material : OreMaterial.values()) {
                            accept(output, ModItems.BY_MATERIAL.get(material));
                        }
                        for (GemMaterial gem : GemMaterial.values()) {
                            accept(output, ModItems.BY_GEM.get(gem));
                        }
                        for (AlloyMaterial alloy : AlloyMaterial.values()) {
                            accept(output, ModItems.BY_ALLOY.get(alloy));
                        }
                        for (DeferredItem<?> item : ModItems.VANILLA_EXTRAS) {
                            output.accept(item.get());
                        }
                    })
                    .build());

    private static void accept(CreativeModeTab.Output output, List<DeferredItem<?>> items) {
        for (DeferredItem<?> item : items) {
            output.accept(item.get());
        }
    }
}
