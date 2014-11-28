package com.jamoorev.kroostmas.client.render;

import com.jamoorev.kroostmas.client.model.ModelPresent;
import com.jamoorev.kroostmas.util.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Mitchellbrine on 2014.
 */
public class RenderPresent extends TileEntitySpecialRenderer{

        private ResourceLocation text = new ResourceLocation(References.MODID.toLowerCase(), "textures/blocks/tileentity/present.png");
        private final ModelPresent model;

        public RenderPresent() {
            model = new ModelPresent();
        }

        @Override
        public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            Minecraft.getMinecraft().renderEngine.bindTexture(text);
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 90.0F, 0.0F, 90.0F);
            this.model.render(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        }

    }