package com.Solver.TheSolverMode;

import com.Solver.TheSolverMode.Module.Module;
import com.Solver.TheSolverMode.Module.imlp.*;

import java.util.concurrent.CopyOnWriteArrayList;

public class Client {
    public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<>();

    public static void startup() {
        modules.add(new Sprint());
        modules.add(new HUD());
        modules.add(new FullBright());
    }

    public static void keyPress(int key, int action) {
        if (action == 1) {
            for (Module m : modules) {
                if (m.getKeyCode() == key) {
                    m.toggle();
                }
            }
        }
    }
}
