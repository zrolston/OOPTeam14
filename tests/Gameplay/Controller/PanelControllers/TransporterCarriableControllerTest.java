package Gameplay.Controller.PanelControllers;

import Gameplay.Views.Display;
import Gameplay.Views.MainView.MainView;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jordi on 4/15/2017.
 */
public class TransporterCarriableControllerTest {
    @Test
    public void activateController() throws Exception {

    }

    public static void main(String[] args) {
        TransporterCarriableController tcc= new TransporterCarriableController();
        Display dp= new Display();
        tcc.activateController(dp.getMainView());
    }

}