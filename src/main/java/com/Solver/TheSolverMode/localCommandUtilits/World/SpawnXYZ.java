package com.Solver.TheSolverMode.localCommandUtilits.World;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber
public class SpawnXYZ {
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        dispatcher.register(Commands.literal("World.SpawnXYZ")
                .executes(ctx -> execute(ctx.getSource())));
    }
    private static int execute(CommandSourceStack source) {
        Minecraft mc = Minecraft.getInstance();
        int spawnX = mc.level.getLevelData().getXSpawn();
        int spawnY = mc.level.getLevelData().getYSpawn();
        int spawnZ = mc.level.getLevelData().getZSpawn();
        Minecraft.getInstance().player.chat("Spawn coordinates:" + spawnX + " " + spawnY + " " + spawnZ);
        return 0;
    }
}