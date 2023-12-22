package com.Solver.TheSolverMode.localCommandUtilits.Advanced.GpuWarnlistManager;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class GpuWarnList {
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("Advanced.GpuWarnlistManager.printWarn")
                .executes(ctx -> execute(ctx.getSource())));
    }
    private static int execute(CommandSourceStack source) {
        boolean a = Minecraft.getInstance().getGpuWarnlistManager().hasWarnings();
        if(a == false){
            Minecraft.getInstance().player.chat("No warnings");
            return 1;
        }
        String warning = Minecraft.getInstance().getGpuWarnlistManager().getAllWarnings();
        String vecWarn = Minecraft.getInstance().getGpuWarnlistManager().getVendorWarnings();
        String renderWarn = Minecraft.getInstance().getGpuWarnlistManager().getRendererWarnings();
        String vwarn = Minecraft.getInstance().getGpuWarnlistManager().getVersionWarnings();
        Minecraft.getInstance().player.chat("Gpu Warning list: " + warning + "VendorWarnings: " + vecWarn);
        Minecraft.getInstance().player.chat("Render Warning: " + renderWarn + "Version warning: " + vwarn);
        return 0;
    }
}