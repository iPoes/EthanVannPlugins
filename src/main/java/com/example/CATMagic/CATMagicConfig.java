package com.example.CATMagic;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.Range;

@ConfigGroup("CATMagic")
public interface CATMagicConfig extends Config {
    @ConfigItem(
            keyName = "Toggle",
            name = "Toggle",
            description = "Set a key to run it",
            position = 0
    )
    default Keybind toggle() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            name = "Items to alch",
            keyName = "itemsToAlch",
            description = "Will low alch or high alch items depending on magic lvl",
            position = 1
    )
    default String itemsToAlch () {
        return "";
    }

    @ConfigItem(
            keyName = "F2P",
            name = "F2POnly",
            description = "Will only use F2P spells to level up magic",
            position = 2
    )
    default boolean F2POnly() {
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
}
