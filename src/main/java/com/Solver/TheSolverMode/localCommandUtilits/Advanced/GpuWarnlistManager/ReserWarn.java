package com.Solver.TheSolverMode.localCommandUtilits.Advanced.GpuWarnlistManager;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ReserWarn {

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("Advanced.GpuWarnlistManager.Reset")
                .executes(ctx -> execute(ctx.getSource())));
    }
    private static int execute(CommandSourceStack source) {
        Minecraft.getInstance().getGpuWarnlistManager().resetWarnings();
        return 0;
    }
}