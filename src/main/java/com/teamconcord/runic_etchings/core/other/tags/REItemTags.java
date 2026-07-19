package com.teamconcord.runic_etchings.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import com.teamconcord.runic_etchings.core.RunicEtchings;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class REItemTags {

    public static final TagKey<Item> ENCHANTMENT_RUNES = itemTag("enchantment_runes");

    private static TagKey<Item> itemTag(String name) {
        return TagUtil.itemTag(RunicEtchings.MOD_ID, name);
    }
}