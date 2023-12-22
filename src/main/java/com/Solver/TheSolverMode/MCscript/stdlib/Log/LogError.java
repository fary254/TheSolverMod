package com.Solver.TheSolverMode.MCscript.stdlib.Log;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber
public class LogError {

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {

        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("MCscript.stdlib.Log_error")
                .then(Commands.argument("script", StringArgumentType.string())
                        .executes(ctx -> execute(ctx))));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        Logger L = LogManager.getLogger();
        String script = StringArgumentType.getString(context, "script");
        L.error(script);
        return 0;
    }
}