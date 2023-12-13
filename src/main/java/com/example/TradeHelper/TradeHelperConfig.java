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
    default boolean Run() { return false; }

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
            name = "Send trade by player name",
            description = "",
            position = 2,
            section = playerSettingsConfig
    )
    default String playerName () {return "";}

    @ConfigItem(
            keyName = "playerInGear",
            name = "Send trade when player contains gear",
            description = "",
            position = 3,
            section = playerSettingsConfig
    )
    default String playerInGear () {return "";}
    @ConfigItem(
            keyName = "receiveTrade",
            name = "Accept trade request",
            description = "",
            position = 4,
            section = playerSettingsConfig
    )
    default boolean receiveTrade () {return false;}
    @Range(
            max = 50
    )
    @ConfigItem(
            keyName = "playerRange",
            name = "Trade range",
            description = "In what range would you like to send a trade request",
            position = 5,
            section = playerSettingsConfig
    )
    default int playerRange() {
        return 5;
    }




}