package com.jamoorev.kroostmas.proxy;

import com.jamoorev.kroostmas.client.render.RenderPresent;
import com.jamoorev.kroostmas.tileentity.TileEntityPresent;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy implements IProxy {
    @Override
    public void registerStuff() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPresent.class, new RenderPresent());
    }
}
