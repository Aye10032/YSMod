package com.aye10032.ysmod.init;

import com.aye10032.ysmod.item.artifacts.belt.AttackHourglassItem;
import com.aye10032.ysmod.item.artifacts.curio.AttackCupItem;
import com.aye10032.ysmod.item.artifacts.curio.AttackFeatherItem;
import com.aye10032.ysmod.item.artifacts.hands.AttackFlowerItem;
import com.aye10032.ysmod.item.artifacts.head.AttackHeadItem;
import com.aye10032.ysmod.utils.Reference;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);

    public static final RegistryObject<Item> ATTACK_CUP = ITEMS.register("attack_cup", AttackCupItem::new);
    public static final RegistryObject<Item> ATTACK_FEATHER = ITEMS.register("attack_feather", AttackFeatherItem::new);
    public static final RegistryObject<Item> ATTACK_FLOWER = ITEMS.register("attack_flower", AttackFlowerItem::new);
    public static final RegistryObject<Item> ATTACK_HEAD = ITEMS.register("attack_head", AttackHeadItem::new);
    public static final RegistryObject<Item> ATTACK_HOURGLASS = ITEMS.register("attack_hourglass", AttackHourglassItem::new);

    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
