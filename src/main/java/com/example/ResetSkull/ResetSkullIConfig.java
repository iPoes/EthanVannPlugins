package com.example.ResetSkull;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("ResetSkull")
public interface ResetSkullIConfig extends Config {

    @ConfigItem(
            keyName = "ResetOwnSkull",
            name = "Lets reset our dirty skull",
            description = "Trying something here",
            position = 0
    )
    default boolean ResetOwnSkull () {return false;}

}
