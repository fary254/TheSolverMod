package com.Solver.TheSolverMode.localCommandUtilits.Advanced;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.Appender;

@Mod.EventBusSubscriber
public class ClearLog {

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("Advanced.ClearLog")
                .executes(ctx -> execute(ctx.getSource())));
    }
    private static int execute(CommandSourceStack source) {
        LoggerContext context = LoggerContext.getContext(false);
        for (Appender appender : context.getConfiguration().getAppenders().values()) {
            // Очищаем каждый аппендер

        }
        return 0;
    }
}