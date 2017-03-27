import Controllers.TileSelectionController;
import Views.Display;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Display display = new Display();

        // TODO:  initialize somewhere else
        TileSelectionController tileSelectionController = new TileSelectionController(display.getTileSelectionView());


        display.setVisible(true);
        display.repaint();




//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                display.repaint();
//            }
//        });

        while (true){
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            display.updateMap();
        }
    }
}
