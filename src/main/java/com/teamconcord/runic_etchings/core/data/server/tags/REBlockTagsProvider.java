package com.teamconcord.runic_etchings.core.data.server.tags;

import com.teamabnormals.blueprint.core.data.server.tags.BlueprintBlockTagsProvider;
import com.teamconcord.runic_etchings.core.RunicEtchings;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class REBlockTagsProvider extends BlueprintBlockTagsProvider {

    public REBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(RunicEtchings.MOD_ID, output, provider, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
    }
}