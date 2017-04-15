/**-------------------------------------------------------------------------------------
|	CameraController Class: Created by Alejandro Chavez on 4/15/2017.
|---------------------------------------------------------------------------------------
|   Description: Takes care of Camera related movements and shifts on the viewport.
|   Also makes hovering on Tiles and Regions work dynamically.
---------------------------------------------------------------------------------------*/

package Gameplay.Controller;
import Gameplay.Views.Utility.Camera;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CameraController implements MouseMotionListener, MouseListener{

    private Camera camera = Camera.getInstance();

    @Override
    public void mouseDragged(MouseEvent e) {
        PixelPoint point = new PixelPoint(e.getX(), e.getY());
        camera.move(point);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //Hovering goes here
    }


    @Override
    public void mousePressed(MouseEvent e) {
        camera.recordPress(new PixelPoint(e.getX(), e.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        camera.releasePress();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}
}
