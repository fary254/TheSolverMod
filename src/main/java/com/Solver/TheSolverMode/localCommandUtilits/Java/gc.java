package com.Solver.TheSolverMode.localCommandUtilits.Java;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class gc {

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("Java.GC")
                .executes(ctx -> execute(ctx.getSource())));
    }
    private static int execute(CommandSourceStack source) {
        Minecraft.getInstance().level.clearTintCaches();
        Minecraft.getInstance().gui.clearCache();
        System.gc(); // Run Java garbage collector
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        System.runFinalization();
        Minecraft.getInstance().player.chat("Done");
        return 0;
    }
}