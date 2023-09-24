package com.example.CATMagic;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

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
        return "";    }

    @ConfigItem(
            keyName = "F2P",
            name = "F2POnly",
            description = "Will only use F2P spells to level up magic",
            position = 2
    )
    default boolean F2POnly() {
        return true;
    }
}
