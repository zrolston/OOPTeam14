package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Views.Display;

import static org.junit.Assert.*;

/**
 * Created by jordi on 4/16/2017.
 */
public class DropControllerTest {
    public static void main(String[] args) {
        Display display = new Display();
        DropController dp = new DropController();
        dp.activateController(display.getMainView());
    }
}