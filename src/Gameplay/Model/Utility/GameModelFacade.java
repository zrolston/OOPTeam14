package Gameplay.Model.Utility;

import Gameplay.Model.Map.GameMap;
import MapBuilder.Model.Utility.MapGenerator;
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

    public static int getMaxMapLength(){
        return 21;
    }
    public static int getMaxMapWidth(){
        return 21;
    }

    public void loadMap(String path){
        DaveBuilder builder = new GameMapDaveBuilder();
        builder.buildMap(path);
    }

    public void generateMap(List<GameTilePlacement> placements){
        MapGenerator gen = new MapGenerator();
        gameMap.initialize(
                gen.generateRegionSets(placements)
        );
    }

    public GameMap debugGetMap(){
        return gameMap;
    }
}
