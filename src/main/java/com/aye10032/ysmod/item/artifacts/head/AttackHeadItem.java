package com.aye10032.ysmod.item.artifacts.head;

import com.aye10032.ysmod.item.artifacts.ArtifactGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class AttackHeadItem extends Item implements ICurioItem {
    public AttackHeadItem(Properties properties) {
        super(properties);
    }

    public AttackHeadItem(){
        super(new Item.Properties()
                .rarity(Rarity.RARE)
                .stacksTo(1)
                .tab(ArtifactGroup.instance));
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        ICurioItem.super.curioTick(slotContext, stack);
    }
}
