package com.example.TradeHelper;

import com.example.EthanApiPlugin.Collections.Inventory;
import com.example.EthanApiPlugin.Collections.Players;
import com.example.EthanApiPlugin.Collections.Widgets;
import com.example.EthanApiPlugin.EthanApiPlugin;
import com.example.PacketUtils.PacketUtilsPlugin;
import com.example.Packets.MousePackets;
import com.example.Packets.PlayerPackets;
import com.google.inject.Inject;
import com.google.inject.Provides;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;

import java.util.Optional;

import static com.example.PacketUtils.PacketReflection.client;

@PluginDescriptor(
        name = "<html><font color=\"#d65c37\">[HP]</font> Trade Helper</html>",
        enabledByDefault = false
)
@PluginDependency(EthanApiPlugin.class)
@PluginDependency(PacketUtilsPlugin.class)

public class TradeHelperPlugin extends Plugin {

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
    private int timeout;
    public String getState;

    @Subscribe
    private void onGameTick(GameTick event) {
        if (client.getGameState() != GameState.LOGGED_IN) {
            return;
        }
        if (timeout > 0) {
            timeout--;
            return;
        }
        System.out.println("Trade window open: " + isTradeWindowOpen());
        if (!isTradeWindowOpen())
            TradeHelper();
    }


    public void TradeHelper() {
        getState = "Sending trade";
        for (String playerName : config.playerName().split(",")) {
            Optional<Player> player = Players.search().withName(playerName).first();
            if (player.isPresent()) {
                MousePackets.queueClickPacket();
                PlayerPackets.queuePlayerAction(player.get(), "Trade with");
                System.out.println("Sending trade with " + playerName);
                timeout += 10;
            }
        }
    }

    public boolean isTradeWindowOpen() {
        System.out.println("Trade window opened");
        return (!Widgets.search().withId(21954564).empty());
    }



    public boolean hasEssenceToTrade() {
        Optional<Widget> Essence = Inventory.search().onlyUnnoted().nameContains("Pure essence").first();
        if(Essence.isPresent()
            && Essence.get().getItemQuantity() > 20
            && Inventory.full()) {
            System.out.println("We got Essence to trade");
            return true;
        } else {
            System.out.println("We don't have Essence to trade");
            return false;

        }
    }

    }

