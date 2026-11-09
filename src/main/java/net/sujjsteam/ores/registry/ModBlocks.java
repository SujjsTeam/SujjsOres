package net.sujjsteam.ores.registry;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sujjsteam.ores.SujjsOres;
import net.sujjsteam.ores.material.AlloyMaterial;
import net.sujjsteam.ores.material.GemMaterial;
import net.sujjsteam.ores.material.OreMaterial;

import java.util.EnumMap;
import java.util.Map;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SujjsOres.MOD_ID);

    public static final Map<OreMaterial, DeferredBlock<Block>> STONE_ORES = new EnumMap<>(OreMaterial.class);
    public static final Map<OreMaterial, DeferredBlock<Block>> DEEPSLATE_ORES = new EnumMap<>(OreMaterial.class);
    public static final Map<OreMaterial, DeferredBlock<Block>> NETHER_ORES = new EnumMap<>(OreMaterial.class);
    public static final Map<OreMaterial, DeferredBlock<Block>> END_ORES = new EnumMap<>(OreMaterial.class);
    public static final Map<OreMaterial, DeferredBlock<Block>> RAW_BLOCKS = new EnumMap<>(OreMaterial.class);
    public static final Map<OreMaterial, DeferredBlock<Block>> STORAGE_BLOCKS = new EnumMap<>(OreMaterial.class);

    public static final Map<GemMaterial, DeferredBlock<Block>> GEM_STONE_ORES = new EnumMap<>(GemMaterial.class);
    public static final Map<GemMaterial, DeferredBlock<Block>> GEM_DEEPSLATE_ORES = new EnumMap<>(GemMaterial.class);
    public static final Map<GemMaterial, DeferredBlock<Block>> GEM_NETHER_ORES = new EnumMap<>(GemMaterial.class);
    public static final Map<GemMaterial, DeferredBlock<Block>> GEM_END_ORES = new EnumMap<>(GemMaterial.class);
    public static final Map<GemMaterial, DeferredBlock<Block>> GEM_STORAGE_BLOCKS = new EnumMap<>(GemMaterial.class);

    public static final Map<AlloyMaterial, DeferredBlock<Block>> ALLOY_STORAGE_BLOCKS = new EnumMap<>(AlloyMaterial.class);

    static {
        for (OreMaterial material : OreMaterial.values()) {
            String id = material.id;
            STONE_ORES.put(material, BLOCKS.register(id + "_ore",
                    () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE))));
            DEEPSLATE_ORES.put(material, BLOCKS.register("deepslate_" + id + "_ore",
                    () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE))));
            NETHER_ORES.put(material, BLOCKS.register("nether_" + id + "_ore",
                    () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE))));
            END_ORES.put(material, BLOCKS.register("end_" + id + "_ore",
                    () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).strength(3.0F, 9.0F).requiresCorrectToolForDrops())));
            RAW_BLOCKS.put(material, BLOCKS.register("raw_" + id + "_block",
                    () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK))));
            STORAGE_BLOCKS.put(material, BLOCKS.register(id + "_block",
                    () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))));
        }
        for (GemMaterial gem : GemMaterial.values()) {
            String id = gem.id;
            GEM_STONE_ORES.put(gem, BLOCKS.register(id + "_ore",
                    () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).strength(3.0F, 3.0F))));
            GEM_DEEPSLATE_ORES.put(gem, BLOCKS.register("deepslate_" + id + "_ore",
                    () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE))));
            GEM_NETHER_ORES.put(gem, BLOCKS.register("nether_" + id + "_ore",
                    () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE))));
            GEM_END_ORES.put(gem, BLOCKS.register("end_" + id + "_ore",
                    () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).strength(3.0F, 9.0F).requiresCorrectToolForDrops())));
            GEM_STORAGE_BLOCKS.put(gem, BLOCKS.register(id + "_block",
                    () -> new Block(gem.hasGem ? BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).requiresCorrectToolForDrops() : BlockBehaviour.Properties.ofFullCopy(Blocks.SAND))));
        }
        for (AlloyMaterial alloy : AlloyMaterial.values()) {
            ALLOY_STORAGE_BLOCKS.put(alloy, BLOCKS.register(alloy.id + "_block",
                    () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))));
        }
    }
}
