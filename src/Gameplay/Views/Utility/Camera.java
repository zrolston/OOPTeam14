/**-------------------------------------------------------------------------------------
|	Camera Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: Controls the position of the Viewport. The mapping will
|   take into consideration Camera to to adjust the things being drawn. (Adjusted for the GamePlay Map)s
---------------------------------------------------------------------------------------*/

package Gameplay.Views.Utility;
import MapBuilder.Views.Utility.PixelPoint;

public class Camera {

    private PixelPoint origin;
    private Integer width;
    private Integer height;
    private static Camera instance = null;
    private PixelPoint press = null;
    private boolean cameraMovement =  true;

    private Camera(int x, int y){
        origin = new PixelPoint(x, y);
        width = PixelMap.SCREEN_WIDTH;
        height = PixelMap.SCREEN_HEIGHT;
    }

    public static Camera getInstance(){
        if(instance == null){
            instance = new Camera(15* PixelMap.TILE_WIDTH - PixelMap.SCREEN_WIDTH / 2,
                                  10* PixelMap.TILE_HEIGHT - PixelMap.SCREEN_HEIGHT / 2);
        }
        return instance;
    }

    //Getters
    public PixelPoint getOrigin() { return origin.clone(); }
    public Integer getWidth() { return width; }
    public Integer getHeight() { return height; }

    //Mouse Camera movement (uses smooth precision)
    public void recordPress(PixelPoint press){
        if(cameraMovement) {
            this.press = press;
        }
    }
    public void move(PixelPoint current){
        cameraMovement = true;

        if(cameraMovement) {
            try {
                int xOffset = current.getX() - press.getX();
                int yOffset = current.getY() - press.getY();
                origin.moveX(-xOffset);
                origin.moveY(-yOffset);
                press = current;
            }
            //Catching any synchronization Error
            catch(NullPointerException e){ }
        }
    }
    public void releasePress(){
        if(cameraMovement) {
            this.press = null;
        }
    }

    //Enable or disable camera movement from the Mouse Point of View
    public void enableMovement(){ cameraMovement = true; }
    public void disableMovement(){ cameraMovement = false; }
}