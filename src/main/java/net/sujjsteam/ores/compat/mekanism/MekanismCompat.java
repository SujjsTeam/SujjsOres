package net.sujjsteam.ores.compat.mekanism;

import mekanism.api.MekanismAPI;
import mekanism.api.chemical.Chemical;
import mekanism.api.chemical.ChemicalBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sujjsteam.ores.SujjsOres;
import net.sujjsteam.ores.material.OreMaterial;

public final class MekanismCompat {

    public static final DeferredRegister<Chemical> CHEMICALS = DeferredRegister.create(MekanismAPI.CHEMICAL_REGISTRY_NAME, SujjsOres.MOD_ID);

    static {
        for (OreMaterial material : OreMaterial.values()) {
            if (!material.mekanismProcessing) {
                continue;
            }
            TagKey<Item> ore = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ores/" + material.id));
            CHEMICALS.register("dirty_" + material.id, () -> new Chemical(ChemicalBuilder.dirtySlurry().tint(material.color).ore(ore)));
            CHEMICALS.register("clean_" + material.id, () -> new Chemical(ChemicalBuilder.cleanSlurry().tint(material.color).ore(ore)));
        }
    }

    private MekanismCompat() {
    }

    public static void register(IEventBus modEventBus) {
        CHEMICALS.register(modEventBus);
    }
}
