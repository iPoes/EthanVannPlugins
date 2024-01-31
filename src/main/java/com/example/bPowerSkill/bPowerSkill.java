package com.example.bPowerSkill;

import com.example.EthanApiPlugin.Collections.Inventory;
import com.example.EthanApiPlugin.Collections.NPCs;
import com.example.EthanApiPlugin.Collections.TileObjects;
import com.example.EthanApiPlugin.EthanApiPlugin;
import com.example.InteractionApi.InventoryInteraction;
import com.example.InteractionApi.TileObjectInteraction;
import com.example.PacketUtils.PacketUtilsPlugin;
import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import java.util.Optional;

@PluginDependency(EthanApiPlugin.class)
@PluginDependency(PacketUtilsPlugin.class)
@PluginDescriptor(
        name = "<html><font color=\"#FF9DF9\">[BEARS]</font> PowerSkiller </html>",
        description = "Power Skiller"
)

public class bPowerSkill extends Plugin {

    @Inject
    Client client;
    @Inject
    private bPowerSkillOverlay overlay;
    @Inject
    private OverlayManager overlayManager;

    private final String dropVar = "Oak";
    private final String objectVar = "Oak tree";
    private final String actionVar = "Chop down";

    //int[][] rockPos = new int[][]{{3295, 3311}, {3294, 3310}, {3295, 3309}}; AL-KHARID ROCK POS.
    int rock = 0;

    int countone;
    int counttwo;

    public String getState;

    @Override
    protected void startUp() throws Exception {
        this.overlayManager.add(overlay);
        countone = 1;
        counttwo = 0;
    }

    @Override
    protected void shutDown() throws Exception {
        this.overlayManager.remove(overlay);
    }

    @Subscribe
    public void onGameTick(GameTick e) {
        if (client.getGameState() != GameState.LOGGED_IN
        ) {
            return;
        }

        Optional<Widget> logToDrop = Inventory.search().onlyUnnoted().nameContains("Oak logs").first();
        Optional<Widget> capeToEquip = Inventory.search().onlyUnnoted().nameContains("Cabbage cape").first();

        rock = rock == 3 ? 0 : rock + 1;
        //for (int i = 0; i < Math.min(3, Inventory.search().nameContains(dropVar).result().size()); i++) {
        //Inventory.search().nameContains(dropVar).first().ifPresent(item -> {
        //InventoryInteraction.useItem(item, "Drop");
        //});
        //}

        if(countone == 1
                && counttwo == 0) {
            getState = "Chop";
            TileObjects.search().withName(objectVar).nearestToPlayer().ifPresent(obj -> {
                TileObjectInteraction.interact(obj, actionVar);
            });
            countone = 0;
            counttwo = 1;
            return;
        }

        if(countone == 0
                && counttwo == 1
                && logToDrop.isPresent()) {
            getState = "Drop";
            Inventory.search().nameContains(dropVar).first().ifPresent(item -> {
                InventoryInteraction.useItem(item, "Drop");
            });
            countone = 1;
            counttwo = 0;
        }

        if(countone == 0
                && counttwo == 1
                && logToDrop.isEmpty()) {
            getState = "Wear Cape";
            Inventory.search().nameContains("Cabbage cape").first().ifPresent(item -> {
                InventoryInteraction.useItem(item, "Wear");
            });
            countone = 1;
            counttwo = 0;
        }

        //if(client.getLocalPlayer().getAnimation() == -1) {
        //TileObjects.search().withinDistance(3).withName(objectVar).nearestToPlayer().ifPresent(obj -> {
        //TileObjectInteraction.interact(obj, actionVar);
        //});
        //}
        //MousePackets.queueClickPacket();
        //ObjectPackets.queueObjectAction(1, 11364, rockPos[rock][0], rockPos[rock][1], false);
    }

}
