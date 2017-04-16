package Gameplay.Model.Utility;

import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Visitors.Carriable;
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

    public static void initialize(  ){
        if (!isInitialized()){
            GameMap map = new GameMap( getMaxMapLength(), getMaxMapWidth() );
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
        MapGenerator gen = new MapGenerator(gameMap.getWidth(), gameMap.getLength());
        gameMap.initialize(
                gen.generateRegionSets(placements)
        );
    }

    public GameMap debugGetMap(){
        return gameMap;
    }


    /**
     * TODO: this is to be implemented differently on different phases so that the view
     * can display different carriables
     * @return
     */
    public List<Carriable> getCarriables(){
        return null;
    }
}
