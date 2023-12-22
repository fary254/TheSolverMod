package com.Solver.TheSolverMode.Module.imlp;

import com.Solver.TheSolverMode.Module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", 73);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (!mc.player.horizontalCollision && mc.player.input.hasForwardImpulse()) {
            mc.player.setSprinting(true);
        }
    }
}
