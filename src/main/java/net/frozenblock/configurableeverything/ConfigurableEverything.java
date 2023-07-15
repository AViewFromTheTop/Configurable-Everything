package net.frozenblock.configurableeverything;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.ModContainer;
import net.frozenblock.configurableeverything.biome.util.BiomeConfigUtil;
import net.frozenblock.configurableeverything.config.BiomePlacementConfig;
import net.frozenblock.configurableeverything.config.FluidConfig;
import net.frozenblock.configurableeverything.config.MainConfig;
import net.frozenblock.configurableeverything.mod_compat.ConfigurableEverythingIntegrations;
import net.frozenblock.configurableeverything.surface_rule.util.SurfaceRuleConfigUtil;
import net.frozenblock.configurableeverything.util.ConfigurableEverythingSharedConstants;
import net.frozenblock.configurableeverything.util.ConfigurableEverythingUtils;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.QuiltDataFixerBuilder;
import org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.QuiltDataFixes;

public class ConfigurableEverything implements ModInitializer {

	@Override
	public void onInitialize() {
		ConfigurableEverythingUtils.startMeasuring(this);
		applyDataFixes(ConfigurableEverythingSharedConstants.MOD_CONTAINER);

		ConfigurableEverythingIntegrations.init();
		MainConfig.get();
		BiomeConfigUtil.init();
		BiomePlacementConfig.get();
		SurfaceRuleConfigUtil.init();
		FluidConfig.get();

		ConfigurableEverythingUtils.stopMeasuring(this);
	}

	private static void applyDataFixes(final @NotNull ModContainer mod) {
		ConfigurableEverythingUtils.log("Applying DataFixes for Configurable Everything with Data Version " + ConfigurableEverythingSharedConstants.DATA_VERSION, true);

		var builder = new QuiltDataFixerBuilder(ConfigurableEverythingSharedConstants.DATA_VERSION);
		builder.addSchema(0, QuiltDataFixes.BASE_SCHEMA);

		QuiltDataFixes.buildAndRegisterFixer(mod, builder);
		ConfigurableEverythingUtils.log("DataFixes for Configurable Everything have been applied", true);
	}
}
