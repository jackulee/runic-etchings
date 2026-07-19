package com.teamconcord.runic_etchings.core.registry;

import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamconcord.runic_etchings.common.item.RuneItem;
import com.teamconcord.runic_etchings.core.RunicEtchings;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;

import static net.minecraft.world.item.CreativeModeTabs.INGREDIENTS;
import static net.minecraft.world.item.crafting.Ingredient.of;

public class REItems {
    public static final ItemSubRegistryHelper ITEMS = RunicEtchings.REGISTRY_HELPER.getItemSubHelper();

    public static final DeferredItem<Item> ARMOR_RUNE = ITEMS.createItem("armor_rune", () -> new RuneItem(new Item.Properties().rarity(Rarity.UNCOMMON), "tooltip.runic_etchings.applies_to.armor", "tooltip.runic_etchings.ingredients.rune"));
    public static final DeferredItem<Item> RANGED_WEAPON_RUNE = ITEMS.createItem("ranged_weapon_rune", () -> new RuneItem(new Item.Properties().rarity(Rarity.UNCOMMON), "tooltip.runic_etchings.applies_to.ranged", "tooltip.runic_etchings.ingredients.rune"));
    public static final DeferredItem<Item> TOOL_RUNE = ITEMS.createItem("tool_rune", () -> new RuneItem(new Item.Properties().rarity(Rarity.UNCOMMON), "tooltip.runic_etchings.applies_to.tools", "tooltip.runic_etchings.ingredients.rune"));
    public static final DeferredItem<Item> WEAPON_RUNE = ITEMS.createItem("weapon_rune", () -> new RuneItem(new Item.Properties().rarity(Rarity.UNCOMMON), "tooltip.runic_etchings.applies_to.weapons", "tooltip.runic_etchings.ingredients.rune"));

    public static void setupTabEditors() {
        CreativeModeTabContentsPopulator.mod(RunicEtchings.MOD_ID)
                .tab(INGREDIENTS)
                .addItemsAfter(of(Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE), ARMOR_RUNE, RANGED_WEAPON_RUNE, TOOL_RUNE, WEAPON_RUNE);
    }
}