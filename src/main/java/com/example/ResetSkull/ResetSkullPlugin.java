package com.example.ResetSkull;

import com.example.EthanApiPlugin.EthanApiPlugin;
import com.example.PacketUtils.PacketUtilsPlugin;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.SkullIcon;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.WorldService;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import com.google.inject.Inject;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.WorldUtil;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldRegion;
import net.runelite.http.api.worlds.WorldResult;


import java.util.ArrayList;
import java.util.List;

import static com.example.PacketUtils.PacketReflection.client;


@PluginDescriptor(
        name = "<html><font color=\"#d65c37\">[HP]</font> Reset Skull</html>",
        enabledByDefault = false,
        tags = "HP"
)
@PluginDependency(EthanApiPlugin.class)
@PluginDependency(PacketUtilsPlugin.class)
@Slf4j
public class ResetSkullPlugin extends Plugin {
    @Inject
    private WorldService worldService;
    @Inject
    PluginManager pluginManager;
    @Inject
    private ResetSkullOverlay overlay;
    @Inject
    private OverlayManager overlayManager;
    @Inject
    ResetSkullIConfig config;
    @Inject
    EthanApiPlugin api;

    @Provides
    public ResetSkullIConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(ResetSkullIConfig.class);
    }

    private int timeout;
    public String getState;

    @Override
    protected void startUp() throws Exception {
        this.overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception {
        this.overlayManager.remove(overlay);
    }

    @Subscribe
    private void onGameTick(GameTick event) {
        if (client.getGameState() != GameState.LOGGED_IN) {

        }
        if (isSkulled()){
            getState = "We are skulled";
            EthanApiPlugin.sendClientMessage("Skulled");


        }
    }
    public boolean isSkulled() {
        getState = "Check Skull";
        Player local = client.getLocalPlayer();
        return local.getSkullIcon() == SkullIcon.SKULL;

    }
    public void resetSkull() {

    }
    public void atFeroxEncalve() {

    }

    }

}
