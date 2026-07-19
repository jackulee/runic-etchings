package com.teamconcord.runic_etchings.core.data.server.tags;

import com.teamabnormals.blueprint.core.data.server.tags.BlueprintItemTagsProvider;
import com.teamconcord.runic_etchings.core.RunicEtchings;
import com.teamconcord.runic_etchings.core.other.tags.REItemTags;
import com.teamconcord.runic_etchings.core.registry.REItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class REItemTagsProvider extends BlueprintItemTagsProvider {

    public REItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> lookup, ExistingFileHelper helper) {
        super(RunicEtchings.MOD_ID, output, provider, lookup, helper);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(REItemTags.ENCHANTMENT_RUNES).add(
                REItems.ARMOR_RUNE.get(),
                REItems.TOOL_RUNE.get(),
                REItems.WEAPON_RUNE.get(),
                REItems.RANGED_WEAPON_RUNE.get()
        );
    }
}