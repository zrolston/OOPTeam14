package Gameplay.Model.Phases;

import Gameplay.Controller.MainController;
import Gameplay.Controller.PhaseStateController;
import Gameplay.Controller.PhaseStateControllers.ProductionPhaseStateController;
import Gameplay.Views.MainView.MainView;
import org.junit.Test;

import javax.swing.*;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by jordi on 4/15/2017.
 */
public class PhaseManagerTest {
    @Test
    public void advancePhase() throws Exception {
        MainController mc = new MainController(new MainView(null));
        PhaseManager pm = new PhaseManager(mc);
        String compare;

        Field f = mc.getClass().getDeclaredField("currentState");
        f.setAccessible(true);

        Object value = f.get(mc);
        assertEquals("TradePhase", value.toString());

        pm.advancePhase();
        value = f.get(mc);
        assertEquals("ProductionPhase", value.toString());
        pm.advancePhase();
        value = f.get(mc);
        assertEquals("BuildPhase", value.toString());
        pm.advancePhase();
        value = f.get(mc);
        assertEquals("MovementPhase", value.toString());
        pm.advancePhase();
        value = f.get(mc);
        assertEquals("WonderPhase", value.toString());
    }

}