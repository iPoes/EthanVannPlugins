package com.example.bPowerSkill;

import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import java.awt.*;

public class bPowerSkillOverlay extends OverlayPanel {

    private final bPowerSkill plugin;

    @Inject
    public bPowerSkillOverlay(bPowerSkill plugin) {
        this.plugin = plugin;
    }

    @Inject
    Client client;

    @Override
    public Dimension render(Graphics2D graphics) {
        panelComponent.setPreferredSize(new Dimension(175, 250));
        panelComponent.setBackgroundColor(Color.pink);
        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Power Skiller - by BEARS")
                .color(Color.white)
                .build());

        panelComponent.getChildren().add(LineComponent.builder()
                .left("Debug: ")
                .leftColor(Color.WHITE)

                .right(""+plugin.countone+" , "+plugin.counttwo)
                .rightColor(Color.WHITE)
                .build());

        panelComponent.getChildren().add(LineComponent.builder()
                .left("State: ")
                .leftColor(Color.WHITE)

                .right(""+plugin.getState)
                .rightColor(Color.WHITE)
                .build());
        return super.render(graphics);
    }

}