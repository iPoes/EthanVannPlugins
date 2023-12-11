package com.example.TradeHelper;

import com.example.EthanApiPlugin.EthanApiPlugin;
import com.example.PacketUtils.PacketUtilsPlugin;
import com.google.inject.Inject;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;

@PluginDescriptor(
        name = "[HP] Trade Helper",
        enabledByDefault = false
)
@PluginDependency(EthanApiPlugin.class)
@PluginDependency(PacketUtilsPlugin.class)

public class TradeHelperPlugin extends Plugin {
    public int timeout = 0;
    @Inject
    Client client;
    @Inject
    PluginManager pluginManager;
    @Inject
    TradeHelperConfig config;
    @Inject
    EthanApiPlugin api;

    @Provides
    public TradeHelperConfig getConfig (ConfigManager configManager) {
        return configManager.getConfig(TradeHelperConfig.class);
    }
}
