package com.aye10032.ysmod.item;

import com.aye10032.ysmod.item.artifacts.ArtifactGroup;
import com.google.common.collect.Lists;
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
    public void appendHoverText(
            @NotNull ItemStack stack, @Nullable Level level,
            @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {

        super.appendHoverText(stack, level, tooltip, flag);
        CompoundTag compound = stack.getTag();
        if (compound == null) {
            setCustomNBT(stack);
        }
        // 检查标签是否存在
        if (compound != null && compound.contains("Type")) {
            // 获取NBT值
            int value = compound.getInt("Type");

            // 添加自定义信息到tooltip中
            tooltip.add(new TextComponent("Attack: " + value));
        }
    }
}
