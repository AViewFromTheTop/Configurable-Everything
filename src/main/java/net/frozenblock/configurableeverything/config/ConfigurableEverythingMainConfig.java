package net.frozenblock.configurableeverything.config;

import blue.endless.jankson.Comment;
import com.google.gson.GsonBuilder;
import net.frozenblock.configurableeverything.util.ConfigurableEverythingSharedConstants;
import net.frozenblock.configurableeverything.util.ConfigurableEverythingUtils;
import net.frozenblock.lib.config.api.instance.Config;
import net.frozenblock.lib.config.api.instance.json.JsonConfig;
import net.frozenblock.lib.config.api.registry.ConfigRegistry;

public class ConfigurableEverythingMainConfig {

	private static final Config<ConfigurableEverythingMainConfig> INSTANCE = ConfigRegistry.register(
		new JsonConfig<>(
			ConfigurableEverythingSharedConstants.MOD_ID,
			ConfigurableEverythingMainConfig.class,
			ConfigurableEverythingUtils.makePath("main", true),
			true,
			new GsonBuilder()
		)
	);

	@Comment(
		"""
		This is a test
		"""
	)
	public int testValue = 69;

	public static ConfigurableEverythingMainConfig get() {
		return INSTANCE.config();
	}
}
