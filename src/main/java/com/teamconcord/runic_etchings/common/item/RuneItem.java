package com.teamconcord.runic_etchings.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import java.util.List;

public class RuneItem extends Item {
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;

    private final Component appliesTo;
    private final Component ingredients;

    public RuneItem(Properties properties, String appliesToKey, String ingredientsKey) {
        super(properties);
        this.appliesTo = Component.translatable(appliesToKey).withStyle(DESCRIPTION_FORMAT);
        this.ingredients = Component.translatable(ingredientsKey).withStyle(DESCRIPTION_FORMAT);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.runic_etchings.rune_type").withStyle(TITLE_FORMAT));
        tooltip.add(Component.empty());
        tooltip.add(Component.translatable("item.minecraft.smithing_template.applies_to").withStyle(TITLE_FORMAT));
        tooltip.add(this.appliesTo);
        tooltip.add(Component.translatable("item.minecraft.smithing_template.ingredients").withStyle(TITLE_FORMAT));
        tooltip.add(this.ingredients);
    }
}