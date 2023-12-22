package com.Solver.TheSolverMode.localCommandUtilits.Runtime;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class halt {

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("Java.RuntimeHalt")
                .executes(ctx -> execute(ctx.getSource())));
    }
    private static int execute(CommandSourceStack source) {
        Runtime.getRuntime().halt(-1);
        return 0;
    }
}