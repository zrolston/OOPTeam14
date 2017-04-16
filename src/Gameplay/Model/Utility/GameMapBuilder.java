package Gameplay.Model.Utility;

import Gameplay.Model.Map.GameMap;
import MapBuilder.Model.Utility.MapParsers.DaveBuilder;

import java.util.List;

public class GameMapBuilder {
    private GameMap gameMap;

    public void loadMap(String path){
        DaveBuilder builder = new GameMapDaveBuilder();
        builder.buildMap(path);
    }

    public void generateMap(List<GameTilePlacement> placements){
        MapGenerator gen = new MapGenerator(gameMap.getWidth(), gameMap.getLength());
        gameMap.initialize(
                gen.generateRegionSets(placements)
        );
    }
}
