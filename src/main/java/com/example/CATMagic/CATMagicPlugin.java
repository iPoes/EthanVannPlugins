package com.example.CATMagic;

import com.example.EthanApiPlugin.EthanApiPlugin;
import com.example.CATMagic.CATMagicConfig;
import com.example.PacketUtils.PacketUtilsPlugin;
import com.google.inject.Inject;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;


@PluginDescriptor(
        name = "CATMagic",
        enabledByDefault = false
)
@PluginDependency(EthanApiPlugin.class)
@PluginDependency(PacketUtilsPlugin.class)

public class CATMagicPlugin extends Plugin {

    public int timeout = 0;
    @Inject
    Client client;
    @Inject
    PluginManager pluginManager;
    @Inject
    CATMagicConfig config;
    @Inject
    EthanApiPlugin api;


    @Provides
    public CATMagicConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(CATMagicConfig.class);

}
}
