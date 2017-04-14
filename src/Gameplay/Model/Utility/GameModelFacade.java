package Gameplay.Model.Utility;

import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Tile.GameTile;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.MapParsers.DaveBuilder;

import java.util.List;

public class GameModelFacade { //TODO make an abstract facade
    static GameModelFacade gameModelFacade;
    private GameMap gameMap;

    private GameModelFacade(GameMap map) {
        this.gameMap = map;
    }

    public static GameModelFacade getInstance(){
        if (isInitialized()) {
            return gameModelFacade;
        }
        return null;
    }

    public static void initialize(GameMap map){
        if (!isInitialized()){
            gameModelFacade = new GameModelFacade(map);
        }
    }

    private static boolean isInitialized(){
        return gameModelFacade != null;
    }

    public void loadMap(String path){
        DaveBuilder builder = new GameMapDaveBuilder();
        builder.buildMap(path);
    }

    public void placeFromFile(List<GameTilePlacement> placements){
        for (GameTilePlacement placement:placements) {
            GameTile tile= placement.getTile();
            HexLocation location=placement.getLocation();
            gameMap.addTile(tile, location);
        }
    }

    public int getMapLength(){
        return gameMap.getLength();
    }

    public int getMapWidth(){
        return gameMap.getWidth();
    }

    public GameMap debugGetMap(){
        return gameMap;
    }
}
