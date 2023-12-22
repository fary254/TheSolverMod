package com.Solver.TheSolverMode.localCommandUtilits.Debug;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber
public class Debug {
    Minecraft mc = Minecraft.getInstance();
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("Debug_ENABLE_ALL_")
                .executes(ctx -> execute(ctx.getSource())));
    }
    private static int execute(CommandSourceStack source) {
        Minecraft mc = Minecraft.getInstance();
        mc.options.reducedDebugInfo = true;
        mc.options.renderDebug = true;
        mc.options.renderDebugCharts = true;
        mc.options.save();
        Minecraft.getInstance().player.chat("Done");
        return 0;
    }
}