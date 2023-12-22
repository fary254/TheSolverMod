package com.Solver.TheSolverMode.localCommandUtilits.Java;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class JavaInfo {

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("JavaInfo")
                .executes(ctx -> execute(ctx.getSource())));
    }
    private static int execute(CommandSourceStack source) {
        String JV = System.getProperty("java.version");
        String RuntimeV = Runtime.version().toString();
        long a = Runtime.getRuntime().freeMemory();
        long f = Runtime.getRuntime().maxMemory();
        long g = Runtime.getRuntime().totalMemory();
        int u = Runtime.getRuntime().availableProcessors();
        long re = Runtime.getRuntime().hashCode();
        Minecraft.getInstance().player.chat("Java Version: " + JV);
        Minecraft.getInstance().player.chat("RunTime ver: " + RuntimeV);
        Minecraft.getInstance().player.chat("FreeMem: " + a + " MaxMemory" + f);
        Minecraft.getInstance().player.chat("TotalMemory: " + g);
        Minecraft.getInstance().player.chat("availableProcessors: " + u);
        Minecraft.getInstance().player.chat("RunTime hashcode: " + re);
        return 0;
    }
}