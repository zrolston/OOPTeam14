/**-------------------------------------------------------------------------------------
|	CameraKeysController Class: Created by Alejandro Chavez on 4/17/2017.
|---------------------------------------------------------------------------------------
|   Description: Controls some special activities for drawing and user input.
---------------------------------------------------------------------------------------*/
package Gameplay.Controller;

import Gameplay.Views.Utility.CursorState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CameraKeysController implements KeyListener{

    CursorState cursorState = CursorState.getInstance();

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_CONTROL){
            cursorState.setControlActive(true);
        }
        else if(e.getKeyCode() == KeyEvent.VK_SHIFT){
            cursorState.setIsBridge(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_CONTROL){
            cursorState.setControlActive(false);
        }
        else if(e.getKeyCode() == KeyEvent.VK_SHIFT){
            cursorState.setIsBridge(false);
        }
    }
}
