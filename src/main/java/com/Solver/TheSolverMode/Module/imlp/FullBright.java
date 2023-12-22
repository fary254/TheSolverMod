package com.Solver.TheSolverMode.Module.imlp;
import com.Solver.TheSolverMode.Module.Module;
public class FullBright extends Module {
    public FullBright() {
        super("FullBright", 77);
    }
    @Override
    public void onEnable() {
        mc.options.gamma = 100;
        mc.options.guiScale = 1;
        mc.options.renderFpsChart = true;
    }

    @Override
    public void onDisable() {
        mc.options.gamma = 15;
        mc.options.guiScale = 2;
        mc.options.renderFpsChart = false;

    }
}
