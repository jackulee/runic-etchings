package com.teamconcord.runic_etchings.mixin;

import com.teamconcord.runic_etchings.core.other.tags.REItemTags;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.inventory.SmithingMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SmithingMenu.class)
public class RESmithingMixin {

    @Inject(method = "createResult", at = @At("TAIL"))
    private void runic_etchings$preserveRuneComponents(CallbackInfo ci) {
        SmithingMenu menu = (SmithingMenu) (Object) this;
        ItemStack template = menu.getSlot(0).getItem();
        ItemStack base = menu.getSlot(1).getItem();
        ItemStack result = menu.getSlot(3).getItem();

        if (!result.isEmpty() && !base.isEmpty() && template.is(REItemTags.ENCHANTMENT_RUNES)) {
            ItemEnchantments newEnchants = result.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);

            result.applyComponents(base.getComponentsPatch());

            if (!newEnchants.isEmpty()) {
                EnchantmentHelper.updateEnchantments(result, (mutable) -> {
                    for (var entry : newEnchants.entrySet()) {
                        mutable.upgrade(entry.getKey(), entry.getIntValue());
                    }
                });
            }
        }
    }
}