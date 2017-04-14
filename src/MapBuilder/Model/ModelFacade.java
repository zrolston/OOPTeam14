package MapBuilder.Model;

import java.util.List;

import MapBuilder.Model.Map.BuildMap;
import MapBuilder.Model.Map.PlacementManager;
import MapBuilder.Model.Tile.BuildTile;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.ILocation;
import MapBuilder.Model.Utility.MapParsers.BuildMapDaveBuilder;
import MapBuilder.Model.Utility.MapParsers.DaveBuilder;
import MapBuilder.Model.Utility.MapParsers.BuildTilePlacement;
import MapBuilder.Views.Utility.Camera;
import MapBuilder.Views.Utility.PixelPoint;


/**
 * Created by jordi on 3/26/2017.
 */
public class ModelFacade {
    static ModelFacade modelFacade;
    //TODO Use PlacementManager
    PlacementManager manager;
    Camera camera=Camera.getInstance();
    DaveBuilder daveBuilder= new BuildMapDaveBuilder();
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

    public void placeFromFile(List<BuildTilePlacement> placements){
        for (BuildTilePlacement placement:placements) {
            BuildTile tile= placement.getTile();
            HexLocation location=placement.getLocation();
            manager.placeTileAt(tile,location);
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

    public void clearMap() {
        manager.clear();
    }

    public void loadMap(String path){
        manager.clear();
        daveBuilder.buildMap(path);
    }
    public void saveMap(BuildMap map,String path){
        daveBuilder.saveMap(map,path);
    }
}
