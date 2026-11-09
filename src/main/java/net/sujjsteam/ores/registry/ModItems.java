package net.sujjsteam.ores.registry;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sujjsteam.ores.SujjsOres;
import net.sujjsteam.ores.material.AlloyMaterial;
import net.sujjsteam.ores.material.GemMaterial;
import net.sujjsteam.ores.material.OreMaterial;
import net.sujjsteam.ores.material.VanillaForms;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SujjsOres.MOD_ID);

    public static final Map<OreMaterial, DeferredItem<Item>> INGOTS = new EnumMap<>(OreMaterial.class);
    public static final Map<OreMaterial, List<DeferredItem<?>>> BY_MATERIAL = new EnumMap<>(OreMaterial.class);
    public static final Map<GemMaterial, List<DeferredItem<?>>> BY_GEM = new EnumMap<>(GemMaterial.class);
    public static final Map<AlloyMaterial, List<DeferredItem<?>>> BY_ALLOY = new EnumMap<>(AlloyMaterial.class);
    public static final List<DeferredItem<Item>> VANILLA_EXTRAS = new ArrayList<>();

    static {
        for (OreMaterial material : OreMaterial.values()) {
            String id = material.id;
            List<DeferredItem<?>> all = new ArrayList<>();
            for (DeferredBlock<?> block : List.of(ModBlocks.STONE_ORES.get(material), ModBlocks.DEEPSLATE_ORES.get(material),
                    ModBlocks.NETHER_ORES.get(material), ModBlocks.END_ORES.get(material),
                    ModBlocks.RAW_BLOCKS.get(material), ModBlocks.STORAGE_BLOCKS.get(material))) {
                all.add(ITEMS.registerSimpleBlockItem(block));
            }
            all.add(ITEMS.registerSimpleItem("raw_" + id));
            DeferredItem<Item> ingot = ITEMS.registerSimpleItem(id + "_ingot");
            INGOTS.put(material, ingot);
            all.add(ingot);
            for (String form : List.of("nugget", "dust", "plate", "gear", "rod")) {
                all.add(ITEMS.registerSimpleItem(id + "_" + form));
            }
            if (material.mekanismProcessing) {
                for (String form : List.of("clump", "dirty_dust", "shard", "crystal")) {
                    all.add(ITEMS.registerSimpleItem(id + "_" + form));
                }
            }
            BY_MATERIAL.put(material, all);
        }
        for (GemMaterial gem : GemMaterial.values()) {
            List<DeferredItem<?>> all = new ArrayList<>();
            for (DeferredBlock<?> block : List.of(ModBlocks.GEM_STONE_ORES.get(gem), ModBlocks.GEM_DEEPSLATE_ORES.get(gem),
                    ModBlocks.GEM_NETHER_ORES.get(gem), ModBlocks.GEM_END_ORES.get(gem), ModBlocks.GEM_STORAGE_BLOCKS.get(gem))) {
                all.add(ITEMS.registerSimpleBlockItem(block));
            }
            if (gem.hasGem) {
                all.add(ITEMS.registerSimpleItem(gem.id));
            }
            all.add(ITEMS.registerSimpleItem(gem.dustId()));
            BY_GEM.put(gem, all);
        }
        for (AlloyMaterial alloy : AlloyMaterial.values()) {
            List<DeferredItem<?>> all = new ArrayList<>();
            all.add(ITEMS.registerSimpleBlockItem(ModBlocks.ALLOY_STORAGE_BLOCKS.get(alloy)));
            for (String form : List.of("ingot", "nugget", "dust", "plate", "gear", "rod")) {
                all.add(ITEMS.registerSimpleItem(alloy.id + "_" + form));
            }
            BY_ALLOY.put(alloy, all);
        }
        for (Map.Entry<String, List<String>> entry : VanillaForms.FORMS.entrySet()) {
            for (String form : entry.getValue()) {
                VANILLA_EXTRAS.add(ITEMS.registerSimpleItem(entry.getKey() + "_" + form));
            }
        }
    }
}
