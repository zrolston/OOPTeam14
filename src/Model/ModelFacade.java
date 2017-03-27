package Model;

import Model.Map.BuildMap;
import Views.Utility.Camera;
import Views.Utility.PixelPoint;

/**
 * Created by jordi on 3/26/2017.
 */
public class ModelFacade {
    BuildMap map;
    Camera camera=Camera.getInstance();
    //Todo:add tileFactory to this


    public ModelFacade(BuildMap map) {
        this.map = map;
    }

    public void moveCamera(PixelPoint current){
        camera.move(current);
    }

    public void recordCameraPress(PixelPoint current){
        camera.recordPress(current);
    }

    public void releaseCameraPress(){
        camera.releasePress();
    }
    public void lockCamera(){
        camera.disableMovement();
    }
    public void unlockCamera(){
        camera.enableMovement();
    }



    //TODO: implement when BuildMap is implemented
    public void placeTile(){

    }
}
