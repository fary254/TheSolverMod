package com.Solver.TheSolverMode.Module.imlp;
import com.Solver.TheSolverMode.Client;
import com.Solver.TheSolverMode.Client;
import com.Solver.TheSolverMode.Module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
public class HUD extends Module {
    public HUD() {
        super("HUD", 80);
    }

    @SubscribeEvent
    public void onUpdate(RenderGameOverlayEvent e) {
        if (e.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            //mc.font.drawShadow(e.getMatrixStack(), "§2aaaaaaaa", 500, 500, -6);
            float speed = mc.player.getSpeed();
            double JumpBoost= mc.player.getJumpBoostPower();
            float flySpeed = mc.player.flyingSpeed;
            for (Module m : Client.modules) {
                if (m.isToggled()) {
                    mc.font.draw(e.getMatrixStack(), "§3Murder drone§1 mode is enabled, press M to enable CHEAT", 3, 1, -6);
                    //mc.font.draw(e.getMatrixStack(), "§3GpuWarnList: ", 3, 10, -1);
                    mc.font.draw(e.getMatrixStack(), "§1Speed: " + speed + " FlyingSpeed" + flySpeed, 3, 17, -1);
                    mc.font.draw(e.getMatrixStack(), "§2JumpBoost:" + JumpBoost, 3, 25, -1);
                    float rainlevel = mc.level.rainLevel;
                    long EntityCount = mc.level.getEntityCount();
                    float ThunderLevel = mc.level.thunderLevel;
                    mc.font.draw(e.getMatrixStack(), "§3WorldRainLVL: " + rainlevel + " §2WorldThunderLVL:" + ThunderLevel, 3, 35, -1);
                    mc.font.draw(e.getMatrixStack(), "§3Entity count: " + EntityCount, 3, 45, -1);
                    mc.font.draw(e.getMatrixStack(), "§2TeamInfo:", 3,55, -1);
                    //Check
                    if (mc.player.getTeam() != null) {
                        // Игрок находится в команде
                         boolean friendlyFire = mc.player.getTeam().isAllowFriendlyFire();
                         boolean canSeeFriendlyInvisibles = mc.player.getTeam().canSeeFriendlyInvisibles();
                         String name = mc.player.getTeam().getName();
                         long id = mc.player.getTeam().getNameTagVisibility().id;
                         String a = mc.player.getTeam().getPlayers().toString();
                        mc.font.draw(e.getMatrixStack(), "§2isAllowFriendlyFire: " + friendlyFire + " canSeeFriendlyInvisibles:" + canSeeFriendlyInvisibles, 3, 65, -1);
                        mc.font.draw(e.getMatrixStack(), "§4Team name: " + name + " TeamID: " + id, 3, 75, -1);
                        mc.font.draw(e.getMatrixStack(), "§4Team player: " + a, 3, 85, -1);
                    }
                    //long LoadedChunksCount = mc.level.getChunkSource().getLoadedChunksCount();
                    //mc.font.draw(e.getMatrixStack(), "§3:LoadedChunksCount: " + LoadedChunksCount, 3, 145, -1);
                    if(mc.isLocalServer() == false){
                        long ping = mc.getCurrentServer().ping;
                        long protocol = mc.getCurrentServer().protocol;
                        String serverIp = mc.getCurrentServer().ip;
                        Boolean pinged = mc.getCurrentServer().pinged;
                        String a = mc.getCurrentServer().name;
                        int mods = mc.getCurrentServer().forgeData.numberOfMods;
                        String v = mc.getCurrentServer().version.getString();
                        long p = mc.getGame().getCurrentSession().getPlayerCount();
                        mc.font.draw(e.getMatrixStack(), "§3Server Protocol: " + protocol + " §3Server ip: " + serverIp, 3, 95, -6);
                        mc.font.draw(e.getMatrixStack(), "§3Server is pinged: " + pinged + " ServerV:" + v, 3, 105, -6);
                        mc.font.draw(e.getMatrixStack(), "§3ServerModsCounts: " + mods + "ServerPlayerCount: " + p, 3, 115, -6);
                    }
                    long LightSectionCount = Minecraft.getInstance().level.getChunkSource().getLightEngine().getLightSectionCount();
                    mc.font.draw(e.getMatrixStack(), "§4LightSectionCount: "  + LightSectionCount, 3, 125, -6);
                    long Atime = mc.getGame().getPerformanceMetrics().getAverageTime();
                    long sample = mc.getGame().getPerformanceMetrics().getSampleCount();
                    mc.font.draw(e.getMatrixStack(), "§4AverageTime: " + Atime + " SampleCount: " + sample, 3, 135, -6);
                }

            }
        }
    }
}
