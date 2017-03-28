package Model;

import Model.Map.BuildMap;
import Model.Tile.BuildTile;
import Model.Utility.ILocation;
import Views.Utility.Camera;
import Views.Utility.PixelPoint;


/**
 * Created by jordi on 3/26/2017.
 */
public class ModelFacade {
    static ModelFacade modelFacade;
    BuildMap map;
    Camera camera=Camera.getInstance();
    //Todo:add tileFactory to this


    private ModelFacade(BuildMap map) {
        this.map = map;
    }

    public void moveCamera(PixelPoint current){
        camera.move(current);
    }

    public static void initialize(BuildMap map){
        if (!isInitialized()){
            modelFacade=new ModelFacade(map);
        }
    }

    public static ModelFacade getInstance(){
        if (isInitialized()) {
            return modelFacade;
        }
        return null;
    }

    private static boolean isInitialized(){
        return modelFacade!=null;
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

    public void placeTile(BuildTile tile, ILocation iLocation){
        map.addTile(tile,iLocation);
    }

    public int getMapWidth(){
        return map.getWIDTH();
    }
    public int getMapLength(){
        return map.getHEIGHT();
    }
}
