package com.Solver.TheSolverMode.Module.imlp;

//import net.minecraft.client.gui.font.
import com.Solver.TheSolverMode.Module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class GUI extends Module{

    public int input;
    public GUI() {
        super("GUI", 75);
    }

    @SubscribeEvent
    public void onUpdate(RenderGameOverlayEvent e) {
        final Level world;
        final int x, y, z;
        final Player entity;
        EditBox a;
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();

    }

}
