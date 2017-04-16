package Gameplay.Model.Utility;

import Gameplay.Model.Map.GameMap;

import java.util.List;

public class GameMapBuilder {
    private GameMap gameMap;
    private final int maxMapLength, maxMapWidth;

    public GameMapBuilder(int maxMapLength, int maxMapWidth){
        this.maxMapLength = maxMapLength;
        this.maxMapWidth = maxMapWidth;
        gameMap = new GameMap( maxMapLength, maxMapWidth );
    }

    public void generateMap(List<GameTilePlacement> placements){
        MapGenerator gen = new MapGenerator(gameMap.getWidth(), gameMap.getLength());
        gameMap.initialize(
                gen.generateRegionSets(placements)
        );
        GameModelFacade.initialize(gameMap);
    }
}
