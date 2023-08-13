package net.frozenblock.configurableeverything.util

import net.fabricmc.loader.api.FabricLoader
import org.slf4j.LoggerFactory
import java.nio.file.Path

object ConfigurableEverythingSharedConstants {

    const val MOD_ID = "configurable_everything"

    @JvmField
    val LOGGER = LoggerFactory.getLogger(MOD_ID)

    var DEV_LOGGING = false

    /**
     * Used for features that may be unstable and crash in public builds.
     *
     *
     * It's smart to use this for at least registries.
     */
    @JvmField
    var UNSTABLE_LOGGING = FabricLoader.getInstance().isDevelopmentEnvironment

    @JvmField
    val MOD_CONTAINER = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow()

    @JvmField
    val DATAPACKS_PATH = Path.of("./config/" + MOD_ID + "/datapacks")
}
