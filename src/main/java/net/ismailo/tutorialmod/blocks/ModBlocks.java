package net.ismailo.tutorialmod.blocks;

import net.ismailo.tutorialmod.TutorialMod;
import net.ismailo.tutorialmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

/**
 * Mod for creating blocks and registering them as blocks and items.
 */
public class ModBlocks {
    public static final DeferredRegister<Block> blockDefferedRegister =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> BANANA_BLOCK = registerBlock("banana_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.0f)
                    .sound(SoundType.HARD_CROP)
                    .pushReaction(PushReaction.DESTROY)
                    .mapColor(MapColor.COLOR_YELLOW)
            ));

    /**
     * Register a block and at the same time register the block as a item
     * @param name unique id of block
     * @param block the block itself
     * @return returns the registried object
     * @param <T> Type of block or a subtype of block
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = blockDefferedRegister.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    /**
     * Helper method to use to register blocks as block items at the same call
     * @param name unique id of block
     * @param block the block being registered
     * @param <T> Type of block or a subtype of block
     */
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.itemDefferedRegister.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    /**
     * Method to add the modEventBus to our register
     * @param modEventBus
     */
    public static void register (IEventBus modEventBus) {
        blockDefferedRegister.register(modEventBus);
    }

}
