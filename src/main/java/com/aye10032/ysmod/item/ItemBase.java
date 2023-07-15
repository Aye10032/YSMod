package com.aye10032.ysmod.item;

import com.aye10032.ysmod.data.ArtifactData;
import com.aye10032.ysmod.item.artifacts.ArtifactGroup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.Random;

public class ItemBase extends Item implements ICurioItem {
    public ItemBase() {
        super(new Item.Properties()
                .rarity(Rarity.RARE)
                .stacksTo(1)
                .tab(ArtifactGroup.instance));
    }

    public void setCustomNBT(ItemStack stack) {
        Random random = new Random();
        int value = random.nextInt(100) + 1;

        CompoundTag compound = stack.getOrCreateTag();
        compound.putInt("Type", value);
        stack.setTag(compound);
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        ICurioItem.super.onEquip(slotContext, prevStack, stack);
    }

    @Override
    public void appendHoverText(
            @NotNull ItemStack stack, @Nullable Level level,
            @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {

        super.appendHoverText(stack, level, tooltip, flag);
        CompoundTag compound = stack.getTag();
        if (compound == null) {
            setCustomNBT(stack);
        }

        if (compound != null && compound.contains("Type")) {
            int value = compound.getInt("Type");

            tooltip.add(new TextComponent("Attack: " + value));
        }
    }

    @Nullable
    public ArtifactData getArtifactData() {
        return null;
    }
}
