package com.Solver.TheSolverMode.MCscript;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.io.*;

@Mod.EventBusSubscriber
public class Exec {

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("localUtils.MCscript_EXEC")
                .then(Commands.argument("script", StringArgumentType.string())
                        .executes(ctx -> execute(ctx))));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        String script = StringArgumentType.getString(context, "script");
        Minecraft.getInstance().player.chat("Start executing: " + script);
        try (BufferedReader br = new BufferedReader(new FileReader(script))) {
            String line;
            while ((line = br.readLine()) != null) {
                Minecraft.getInstance().player.chat(line);
            }
        } catch (Exception error) {
            Minecraft.getInstance().player.chat("Executing error: " + script);
        }

        return 0;
    }
}