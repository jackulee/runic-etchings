package com.teamconcord.runic_etchings.core;

import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.teamconcord.runic_etchings.core.data.client.REItemModelProvider;
import com.teamconcord.runic_etchings.core.data.server.tags.REBlockTagsProvider;
import com.teamconcord.runic_etchings.core.data.server.tags.REItemTagsProvider;
import com.teamconcord.runic_etchings.core.registry.REItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;

@Mod(RunicEtchings.MOD_ID)
public class RunicEtchings {
    public static final String MOD_ID = "runic_etchings";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID.toUpperCase());
    public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MOD_ID, helper -> {});

    public RunicEtchings(IEventBus bus, ModContainer container) {
        REItems.ITEMS.register(bus);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            REItems.setupTabEditors();
        }

        bus.addListener(this::dataSetup);
    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        boolean server = event.includeServer();
        REBlockTagsProvider blockTags = new REBlockTagsProvider(output, provider, helper);
        generator.addProvider(server, blockTags);
        generator.addProvider(server, new REItemTagsProvider(output, provider, blockTags.contentsGetter(), helper));

        boolean client = event.includeClient();
        generator.addProvider(client, new REItemModelProvider(output, helper));
    }

    public static ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}