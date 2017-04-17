package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Views.Display;

/**
 * Created by jordi on 4/16/2017.
 */
public class DropControllerTest {
    public static void main(String[] args) {
        Display display = new Display();
        MoveController dp = new MoveController();
        dp.activateController(display.getMainView());
    }
}