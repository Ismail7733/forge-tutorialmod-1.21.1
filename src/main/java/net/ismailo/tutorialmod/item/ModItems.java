package net.ismailo.tutorialmod.item;

import net.ismailo.tutorialmod.TutorialMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ItemsDefferedRegister = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    //Create banana
    public static final RegistryObject<Item> BANANA = ItemsDefferedRegister.register("banana", () -> new Item(new Item.Properties().
            food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3f).build())));

    public static void register (IEventBus modEventBus) {
        ItemsDefferedRegister.register(modEventBus);
    }
}
