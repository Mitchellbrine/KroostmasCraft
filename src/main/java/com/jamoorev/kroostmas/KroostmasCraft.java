package com.jamoorev.kroostmas;

import com.jamoorev.kroostmas.block.BlockRegistry;
import com.jamoorev.kroostmas.item.ItemRegistry;
import com.jamoorev.kroostmas.proxy.IProxy;
import com.jamoorev.kroostmas.util.References;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid=References.MODID,name=References.NAME,version=References.VERSION)
public class KroostmasCraft {

    public static Logger logger = LogManager.getLogger("KroostmasCraft");

    @SidedProxy(clientSide = "com.jamoorev.kroostmas.proxy.ClientProxy",serverSide = "com.jamoorev.kroostmas.proxy.CommonProxy")
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("Merry Kroostmas! The mod is registering now!");

        ItemRegistry.init();
        BlockRegistry.init();

        proxy.registerStuff();

        logger.info("Finished with this stuff!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}
