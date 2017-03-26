/**-------------------------------------------------------------------------------------
|	SetupOne Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: Sets a basic JPanel and add a listener to test camera movement, OutlineDrawer,
|   and some of the Controller functionality.
 ---------------------------------------------------------------------------------------*/

package TestSetup;

import Controllers.KeyboardListeners.EditorKeyboardListener;
import Controllers.MouseListeners.EditorMouseListener;
import Model.ModelFacade;
import Model.Utility.Location;
import Model.Utility.PixelMap;
import Model.Utility.PixelPoint;
import Views.Drawers.TileOutlineDrawer;
import org.junit.Test;
import javax.swing.*;
import java.awt.*;


public class SetupOne {

    static Location[][] simulatedMap;

    static class TestPanel extends JPanel{

        TestPanel(){
            setBackground(new Color(255,255,255));
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            for(int i=0; i<simulatedMap.length; i++){
                for(int j=0; j<simulatedMap[0].length; j++){
                    PixelPoint tileCenter = PixelMap.getTileCenter(simulatedMap[i][j]);
                    TileOutlineDrawer.drawInMap(g, tileCenter);
                }
            }
        }
    }

    @Test
    public static void main(String[] args) throws InterruptedException {
        ModelFacade modelFacade= new ModelFacade(null);
        //Initialize the map simulation
        simulatedMap = new Location[21][21];
        for(int i=0; i<simulatedMap.length; i++){
            for(int j=0; j<simulatedMap[0].length; j++){
                simulatedMap[i][j] = new Location(i,j);
            }
        }

        EditorMouseListener mouseListener = new EditorMouseListener(modelFacade);
        EditorKeyboardListener keyboardListener= new EditorKeyboardListener(modelFacade);

        JFrame frame = new JFrame("Drawer/Controller Test");

        frame.setSize(new Dimension(PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT));
        frame.addMouseMotionListener(mouseListener);
        frame.addMouseListener(mouseListener);
        frame.addKeyListener(keyboardListener);

        JPanel test = new TestPanel();

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(test);

        while(true){
            test.repaint();
            Thread.sleep(10);
        }
    }
}