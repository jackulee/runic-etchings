package com.teamconcord.runic_etchings.core.data.client;

import com.teamabnormals.blueprint.core.data.client.BlueprintItemModelProvider;
import com.teamconcord.runic_etchings.core.RunicEtchings;
import com.teamconcord.runic_etchings.core.registry.REItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class REItemModelProvider extends BlueprintItemModelProvider {

    public REItemModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, RunicEtchings.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        this.generatedItem(
                REItems.ARMOR_RUNE,
                REItems.TOOL_RUNE,
                REItems.WEAPON_RUNE,
                REItems.RANGED_WEAPON_RUNE
        );
    }
}