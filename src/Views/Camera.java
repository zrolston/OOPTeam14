/**-------------------------------------------------------------------------------------
|	Camera Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: Controls the position of the Viewport, and where the mini-map is
|   compared to the whole map. Also controls the zoom via a scale ratio. The mapping will
|   take into consideration Camera to to adjust the things being drawn.
---------------------------------------------------------------------------------------*/
package Views;

import Model.Utility.PixelMap;
import Model.Utility.PixelPoint;

public class Camera {

    private PixelPoint origin;
    private Double scale;
    private Integer width;
    private Integer height;
    private static Camera instance = null;
    private int moveOffset = PixelMap.TILE_WIDTH/16;
    private PixelPoint press = null;
    private boolean cameraMovement =  false;

    private Camera(int x, int y){
        origin = new PixelPoint(x, y);
        scale = 1.0;
        width = PixelMap.SCREEN_WIDTH;
        height = PixelMap.SCREEN_HEIGHT;
    }

    public static Camera getInstance(){
        if(instance == null){
            instance = new Camera(0,0);
        }
        return instance;
    }

    public static void initialize(int x, int y){
        if(instance == null){
            instance = new Camera(x, y);
        }
    }

    //Getters
    public PixelPoint getOrigin() { return origin.clone(); }
    public Double getScale() { return scale; }
    public Integer getWidth() { return width; }
    public Integer getHeight() { return height; }

    //Mutators
    public void zoomIn(){
        scale += 0.1;
    }
    public void zoomOut(){
        if(scale > 0.1)
            scale -= 0.1;
    }

    //NumKey Camera movement (uses a set offset)
    public void moveNorth(){
        origin.moveY(-moveOffset);
    }
    public void moveWest(){
        origin.moveX(-moveOffset);
    }
    public void moveSouth(){
        origin.moveY(moveOffset);
    }
    public void moveEast(){
        origin.moveX(moveOffset);
    }

    //Mouse Camera movement (uses smooth precision)
    public void recordPress(PixelPoint press){
        if(cameraMovement) {
            this.press = press;
        }
    }
    public void move(PixelPoint current){

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
