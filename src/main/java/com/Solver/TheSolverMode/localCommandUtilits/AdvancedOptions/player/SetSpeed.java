package com.Solver.TheSolverMode.localCommandUtilits.AdvancedOptions.player;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SetSpeed {
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        dispatcher.register(Commands.literal("AdvancedOption.player.SetSpeed")
                .then(Commands.argument("script", IntegerArgumentType.integer())
                        .executes(SetSpeed::execute)));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        Minecraft mc = Minecraft.getInstance();
        int a = IntegerArgumentType.getInteger(context, "script");
        Minecraft.getInstance().player.setSpeed(a);
        return 0;
    }
}