package com.example.CATMagic;

import com.example.EthanApiPlugin.EthanApiPlugin;
import com.example.PacketUtils.PacketUtilsPlugin;
import com.google.inject.Provides;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
        name = "AIO Magic",
        description = "AIO Magic trainer",
        enabledByDefault = false,
        tags = {"ethan", "Poes", "iPoes", "Magic"}
)
@PluginDependency(PacketUtilsPlugin.class)
@PluginDependency(EthanApiPlugin.class)

public class CATMagicPlugin extends Plugin {

    @Provides
    public CATMagicConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(CATMagicConfig.class);
    }
}
