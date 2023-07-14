package com.aye10032.ysmod.item.artifacts;

import com.aye10032.ysmod.init.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ArtifactGroup extends CreativeModeTab {

    private ArtifactGroup(int index, String label) {
        super(index, label);
    }
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemRegistry.ATTACK_HEAD.get());
    }

    public static final ArtifactGroup instance = new ArtifactGroup(CreativeModeTab.TABS.length, "ysmod");
}
