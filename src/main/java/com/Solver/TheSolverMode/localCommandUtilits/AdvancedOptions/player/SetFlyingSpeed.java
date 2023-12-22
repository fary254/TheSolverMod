package com.Solver.TheSolverMode.localCommandUtilits.AdvancedOptions.player;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SetFlyingSpeed {
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        dispatcher.register(Commands.literal("AdvancedOption.player.SetFlyingSpeed")
                .then(Commands.argument("script", FloatArgumentType.floatArg())
                        .executes(SetFlyingSpeed::execute)));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        Minecraft mc = Minecraft.getInstance();
        float a = FloatArgumentType.getFloat(context, "script");
        Minecraft.getInstance().player.flyingSpeed = a;
        return 0;
    }
}