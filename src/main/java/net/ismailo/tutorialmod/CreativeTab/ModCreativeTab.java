package net.ismailo.tutorialmod.CreativeTab;

import net.ismailo.tutorialmod.TutorialMod;
import net.ismailo.tutorialmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CreativeModeTabRegister = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CreativeModeTabRegister.register("example", () -> CreativeModeTab.builder()
            // Set name of tab to display
            .title(Component.translatable("item_group." + TutorialMod.MOD_ID + ".example"))
            // Set icon of creative tab
            .icon(() -> new ItemStack(ModItems.BANANA.get()))
            // Add default items to tab
            .displayItems((params, output) -> {
                output.accept(ModItems.BANANA.get());
            })
            .build()
    );

    public static void register(IEventBus modEventBus) {
        CreativeModeTabRegister.register(modEventBus);
    }
}
