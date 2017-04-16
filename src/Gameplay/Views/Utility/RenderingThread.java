/**-------------------------------------------------------------------------------------
|	RenderingThread Class: Created by Alejandro Chavez on 4/15/2017.
|---------------------------------------------------------------------------------------
|   Description: Takes care of individual Rendering of a certain Component (JFrame, Panel, etc)
---------------------------------------------------------------------------------------*/
package Gameplay.Views.Utility;

import java.awt.*;

public class RenderingThread extends Thread{
    private Component view;
    private int frameRate;

    public RenderingThread(Component view, int frameRate){
        this.view = view;
        this.frameRate = frameRate;
    }

    public void setFrameRate(int frameRate) { this.frameRate = frameRate; }
    public int getFrameRate() { return frameRate; }

    public void run(){
        while(true){
            try {
                Thread.sleep(1000/frameRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            view.repaint();
        }
    }
}
