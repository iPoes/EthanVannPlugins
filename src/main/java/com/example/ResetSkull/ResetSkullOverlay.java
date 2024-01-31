package com.example.ResetSkull;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;

public class ResetSkullOverlay extends OverlayPanel {

    private final ResetSkullPlugin plugin;

    @Inject
    public ResetSkullOverlay(ResetSkullPlugin plugin) {this.plugin = plugin;}
    @Inject
    Client client;

    @Override
    public Dimension render(Graphics2D graphics) {
        panelComponent.setPreferredSize(new Dimension(175, 250));
        panelComponent.setBackgroundColor(Color.MAGENTA);
        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Reset Skull - by Hanky")
                .color(Color.YELLOW)
                .build());

        panelComponent.getChildren().add(LineComponent.builder()
                .left("Debug: ")
                .leftColor(Color.YELLOW)

                .build());

        panelComponent.getChildren().add(LineComponent.builder()
                .left("State: ")
                .leftColor(Color.YELLOW)

                .right(""+plugin.getState)
                .rightColor(Color.YELLOW)
                .build());
        return super.render(graphics);
    }

}
