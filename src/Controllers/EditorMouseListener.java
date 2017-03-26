/**-------------------------------------------------------------------------------------
|	EditorMouseListener Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: Preliminary Mouse Listener. It does smooth Camera movement but it lacks
|   the other main functionalities to control the Menu.
---------------------------------------------------------------------------------------*/

package Controllers;

import Views.Utility.PixelPoint;
import Views.Utility.Camera;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class EditorMouseListener implements MouseMotionListener, MouseListener{

    Camera camera = Camera.getInstance();

    //Continuous Methods
    //-------------------------------------------------------------------
    @Override
    public void mouseDragged(MouseEvent e) {
        camera.move(new PixelPoint(e.getX(), e.getY()));
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    //One Event Methods
    //-------------------------------------------------------------------
    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {
        camera.recordPress(new PixelPoint(e.getX(), e.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        camera.releasePress();
    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
