package com.example;

import com.example.CATMagic.CATMagicPlugin;
import com.example.EthanApiPlugin.EthanApiPlugin;
import com.example.PacketUtils.PacketUtilsPlugin;
import com.example.ResetSkull.ResetSkullPlugin;
import com.example.TradeHelper.TradeHelperPlugin;
import com.example.bPowerSkill.bPowerSkill;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ExamplePluginTest {
    public static void main(String[] args) throws Exception {
        ExternalPluginManager.loadBuiltin(EthanApiPlugin.class, PacketUtilsPlugin.class, CATMagicPlugin.class, TradeHelperPlugin.class, bPowerSkill.class, ResetSkullPlugin.class);
        RuneLite.main(args);
    }
}