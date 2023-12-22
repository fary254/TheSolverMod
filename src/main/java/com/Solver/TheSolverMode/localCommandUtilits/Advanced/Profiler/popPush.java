package com.Solver.TheSolverMode.localCommandUtilits.Advanced.Profiler;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class popPush {

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("Advanced.Profiler.popPush")
                .then(Commands.argument("script", StringArgumentType.string())
                        .executes(ctx -> execute(ctx))));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        String a = StringArgumentType.getString(context, "script");
        Minecraft.getInstance().getProfiler().popPush(a);
        return 0;
    }
}