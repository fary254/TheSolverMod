package com.Solver.TheSolverMode.localCommandUtilits;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;

@Mod.EventBusSubscriber
public class CreateDumb {
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("CreateDumb")
                .then(Commands.argument("script", StringArgumentType.string())
                        .executes(CreateDumb::execute)));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        Minecraft mc = Minecraft.getInstance();
        String a = StringArgumentType.getString(context, "script");
        File file = new File(a);
        try {
            String versionType = mc.getVersionType();
            String LaunchedVersion = mc.getLaunchedVersion();
            String fps = mc.fpsString;
            String JV = System.getProperty("java.version");
            String RuntimeV = Runtime.version().toString();
            long freeMemory = Runtime.getRuntime().freeMemory();
            long maxMemory = Runtime.getRuntime().maxMemory();
            long totalMemory = Runtime.getRuntime().totalMemory();
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            String playerName = mc.player.getName().getString();
            String ScoreboardName = mc.player.getScoreboardName();
            boolean hasCustomName = mc.player.hasCustomName();
            boolean shouldShowName = mc.player.shouldShowName();
            boolean isCustomNameVisible = mc.player.isCustomNameVisible();
            long playerScore = mc.player.getScore();
            int deathTime = mc.player.deathTime;
            int experienceLevel = mc.player.experienceLevel;
            int hurtDuration = mc.player.hurtDuration;
            int hurtTime = mc.player.hurtTime;
            int invulnerableDuration = mc.player.invulnerableDuration;
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Minecraft/TheSolverMod dumb\n");
            bufferedWriter.write("MC version type: " + versionType + "       MC LaunchedVersion: " + LaunchedVersion + "\n");
            bufferedWriter.write("FPS: " + fps + "\n");
            bufferedWriter.write("-------------------Java and advanced information------------------------\n");
            long Atime = mc.getGame().getPerformanceMetrics().getAverageTime();
            long sample = mc.getGame().getPerformanceMetrics().getSampleCount();
            String warning = Minecraft.getInstance().getGpuWarnlistManager().getAllWarnings();
            String vecWarn = Minecraft.getInstance().getGpuWarnlistManager().getVendorWarnings();
            String renderWarn = Minecraft.getInstance().getGpuWarnlistManager().getRendererWarnings();
            String vwarn = Minecraft.getInstance().getGpuWarnlistManager().getVersionWarnings();
            //java,mem,debug,logs,idk just debug info
            int thread = Thread.activeCount();
            bufferedWriter.write("Java ver:" + JV + "       Runtime ver: " + RuntimeV + "\n");
            bufferedWriter.write("FreeMEM: " + freeMemory + "    TotalMEM: " + totalMemory + "     MaxMemory: " + maxMemory + "\n");
            bufferedWriter.write("availableProcessors:" + availableProcessors + "\n");
            bufferedWriter.write("AverageTime :" + Atime + "    Sample count: " + sample + "\n");
            long classesCount = ManagementFactory.getClassLoadingMXBean().getLoadedClassCount();
            bufferedWriter.write("Thread active count :" + thread + "    Classes count: " + classesCount + "\n");
            bufferedWriter.write("-------------------Gpu warning list-------------------------------------------\n");
            bufferedWriter.write("AllWarnings :" + warning + "    VendorWarnings: " + vecWarn + "RendererWarnings: " + renderWarn);
            bufferedWriter.write("VersionWarnings :" + vwarn + "\n");
            bufferedWriter.write("-------------------Player Info-------------------------------------------\n");
            bufferedWriter.write("Player name: " + playerName + " ScoreboardName: " + ScoreboardName + "\n");
            bufferedWriter.write("has Custom Name: " + hasCustomName + " shouldShowName: " + shouldShowName + "\n");
            bufferedWriter.write("is Custom Name Visible: " + isCustomNameVisible + " shouldShowName: " + shouldShowName + "\n");
            bufferedWriter.write("player Score: " + playerScore + " deathTime: " + deathTime + "\n");
            bufferedWriter.write("Experience Level: " + experienceLevel + " hurtDuration: " + hurtDuration + "\n");
            bufferedWriter.write("Hurt Time: " + hurtTime + " invulnerable Duration: " + invulnerableDuration + "\n");
            bufferedWriter.write("invulnerable Duration: " + invulnerableDuration + "\n");
            bufferedWriter.write("removeStingerTime: " + invulnerableDuration + "\n");
            bufferedWriter.write("swingTime: " + invulnerableDuration + "\n");
            int PlayerID = mc.player.getId();
            int getAirSupply = mc.player.getAirSupply();
            int PlayerArmor = mc.player.getArmorValue();
            int ArrowCount = mc.player.getArrowCount();
            int getDimensionChangingDelay = mc.player.getDimensionChangingDelay();
            int x = mc.player.getBlockX();
            int y = mc.player.getBlockY();
            int z = mc.player.getBlockZ();
            int NoActionTime = mc.player.getNoActionTime();
            int StingerCount = mc.player.getStingerCount();
            float Health = mc.player.getHealth();
            float MaxHealth = mc.player.getMaxHealth();
            float Speed = mc.player.getSpeed();
            float flyingSpeed = mc.player.flyingSpeed;
            //String TeamName = mc.player.getTeam().getName();
            if (mc.player.getTeam() != null) {
                // Игрок находится в команде
                boolean friendlyFire = mc.player.getTeam().isAllowFriendlyFire();
                boolean canSeeFriendlyInvisibles = mc.player.getTeam().canSeeFriendlyInvisibles();
                String name = mc.player.getTeam().getName();
                long TeamID = mc.player.getTeam().getNameTagVisibility().id;
                String TeamPlayers = mc.player.getTeam().getPlayers().toString();
                bufferedWriter.write("Team name: " + name + "    TeamID: " + TeamPlayers + "\n");
                bufferedWriter.write("Team players: " + TeamPlayers + "   TeamID: " + TeamPlayers + "\n");
                bufferedWriter.write("Friendly fire in team: " + friendlyFire + "   can See Friendly Invisibles: " + canSeeFriendlyInvisibles + "\n");
            }
            double JumpBoost = mc.player.getJumpBoostPower();
            bufferedWriter.write("PlayerID: " + PlayerID + "   JumpBoost" + JumpBoost + "\n");
            bufferedWriter.write("get Air Supply: " + getAirSupply + " Player Armor: " + PlayerArmor + "\n");
            bufferedWriter.write("Arrow Count: " + ArrowCount + " get Dimension Changing Delay: " + getDimensionChangingDelay + "\n");
            bufferedWriter.write("Player coordinates X-" + x + "Y-" + y + "Z-" + z + "\n");
            bufferedWriter.write("No Action Time: " + NoActionTime + " StingerCount: " + StingerCount + "\n");
            bufferedWriter.write("Health: " + Health + " Max Health: " + MaxHealth + "\n");
            bufferedWriter.write("Speed: " + Speed + " flying Speed: " + flyingSpeed + "\n");
            bufferedWriter.write("-------------------Level info(aka your world)-------------------------------------------\n");
            float rainlevel = mc.level.rainLevel;//Rain level
            long EntityCount = mc.level.getEntityCount();//entity count
            float ThunderLevel = mc.level.thunderLevel;//thunder LVL
            bufferedWriter.write("RainLVL: " + rainlevel + "   ThunderLevel: " + ThunderLevel + "\n");
            bufferedWriter.write("Entity count: " + EntityCount + "   ThunderLevel: " + ThunderLevel + "\n");
            String levelString = mc.level.toString();
            String gatherChunkSourceStats = mc.level.gatherChunkSourceStats();
            int FreeMapID = mc.level.getFreeMapId();
            int SectionsCount = mc.level.getSectionsCount();
            int MoonPhase = mc.level.getMoonPhase();
            int SkyDarken = mc.level.getSkyDarken();
            long GameTime = mc.level.getGameTime();
            boolean captureBlockSnapshots = mc.level.captureBlockSnapshots;
            boolean isLdebug = mc.level.isDebug();
            bufferedWriter.write("level String: " + levelString + "   gather Chunk Source Stats: " + gatherChunkSourceStats + "\n");
            bufferedWriter.write("Free Map ID: " + FreeMapID + "   Sections Count: " + SectionsCount + "\n");
            bufferedWriter.write("Moon Phase: " + MoonPhase + "   Sky Darken: " + SkyDarken + "\n");
            bufferedWriter.write("Moon Phase: " + MoonPhase + "   Sky Darken: " + SkyDarken + "\n");
            bufferedWriter.write("Game Time: " + GameTime + "   captureBlockSnapshots: " + captureBlockSnapshots + "\n");
            boolean noSave = mc.level.noSave();
            int spawnX = mc.level.getLevelData().getXSpawn();
            int spawnY = mc.level.getLevelData().getYSpawn();
            int spawnZ = mc.level.getLevelData().getZSpawn();
            bufferedWriter.write("Spawn coordinates:" + spawnX + " " + spawnY + " " + spawnZ);
            bufferedWriter.write("noSave: " + noSave + "   captureBlockSnapshots: " + captureBlockSnapshots + "\n");
            bufferedWriter.flush();  // добавляем вызов метода flush() для записи данных в файл
            bufferedWriter.close();  // и закрываем поток
            return 0;
        } catch (IOException e) {

            mc.player.chat("IOException:");
            return -1;
        }
    }
}