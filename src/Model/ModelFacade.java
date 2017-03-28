package Model;

import Model.Map.BuildMap;
import Model.Map.PlacementManager;
import Model.Tile.BuildTile;
import Model.Utility.ILocation;
import Views.Utility.Camera;
import Views.Utility.PixelPoint;


/**
 * Created by jordi on 3/26/2017.
 */
public class ModelFacade {
    static ModelFacade modelFacade;
    //TODO Use PlacementManager
    PlacementManager manager;
    Camera camera=Camera.getInstance();
    //Todo:add tileFactory to this


    private ModelFacade(PlacementManager manager) {
        this.manager = manager;
    }

    public void moveCamera(PixelPoint current){
        camera.move(current);
    }

    public static void initialize(PlacementManager manager){
        if (!isInitialized()){
            modelFacade=new ModelFacade(manager);
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

    public boolean validateLocation(BuildTile tile, ILocation location){
        return manager.validate(tile, location);
    }

    public boolean validateMap(){
        return manager.validateMap();
    }

    public void placeTile(BuildTile tile, ILocation iLocation){
        if(manager.validate(tile, iLocation)){
            manager.placeTileAt(tile, iLocation);
        }
    }

    public void removeTileAt(ILocation location){
        manager.removeTileAt(location);
    }

    public int getMapWidth(){
        return BuildMap.getInstance().getWIDTH();
    }
    public int getMapLength(){
        return BuildMap.getInstance().getHEIGHT();
    }
}
