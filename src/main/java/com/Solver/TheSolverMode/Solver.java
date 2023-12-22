package com.Solver.TheSolverMode;
import com.Solver.TheSolverMode.Key.Keys;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Mod("solver")
public class Solver {
    private static final Logger LOGGER = LogManager.getLogger();

    public Solver() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new Keys());
        Minecraft mc = Minecraft.getInstance();
        mc.options.darkMojangStudiosBackground = true;
        mc.getWindow().setTitle("TheSolverMode/MC configuration done!");
        mc.options.save();

    }

    private void setup(final FMLCommonSetupEvent event) {
        Client.startup();
    }
}
