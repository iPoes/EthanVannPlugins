package com.example.TradeHelper;

import net.runelite.client.config.*;

@ConfigGroup("TradeHelper")
public interface TradeHelperConfig extends Config {

    @ConfigItem(
            keyName = "Run",
            name = "Run Plugin",
            description = "Run it now",
            position = 0
    )
    default boolean Run() {
        return true;
    }

    @ConfigSection(
            name = "Game Tick Configuration",
            description = "Configure how the bot handles game tick delays, 1 game tick equates to roughly 600ms",
            position = 1
    )
    String delayTickConfig = "delayTickConfig";

    @Range(
            max = 10
    )
    @ConfigItem(
            keyName = "tickDelayMin",
            name = "Game Tick Min",
            description = "",
            position = 2,
            section = delayTickConfig
    )
    default int tickDelayMin() {
        return 1;
    }

    @Range(
            max = 10
    )
    @ConfigItem(
            keyName = "tickDelayMax",
            name = "Game Tick Max",
            description = "",
            position = 3,
            section = delayTickConfig
    )
    default int tickDelayMax() {
        return 3;
    }

    @ConfigSection(
            name = "Player Settings",
            description = "Configure on what conditions it should interact with other players",
            position = 1
    )
    String playerSettingsConfig = "playerSettingsConfig";

    @ConfigItem(
            keyName = "playerName",
            name = "Trade Player by name",
            description = "",
            position = 2,
            section = playerSettingsConfig
    )
    default String playerName () {return "";}
    @Range(
            max = 50
    )
    @ConfigItem(
            keyName = "playerRange",
            name = "Trade range",
            description = "In what range would you like to send a trade request",
            position = 3,
            section = playerSettingsConfig
    )
    default int playerRange() {
        return 5;
    }

    @ConfigItem(
            keyName = "tradeGear",
            name = "Trade when player contains gear",
            description = "",
            position = 4,
            section = playerSettingsConfig
    )
    default String playerInGear () {return "";}

}