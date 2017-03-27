import Views.Display;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        display.setVisible(true);
        display.repaint();
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                display.repaint();
//            }
//        });

        while (true){
            try {
                Thread.sleep(75);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            display.updateMap();
        }
    }
}
