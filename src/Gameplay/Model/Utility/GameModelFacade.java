package Gameplay.Model.Utility;

import Gameplay.Model.Goods.Good;
import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Transporters.Transporter;
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
    public List<Carriable> getCarriables(Region region){
        return null;
    }

    public void move(Region region){

    }


    /**
     * TODO: to be implemented, made for when a transporter needs to drop a carriable on a certain tile
     * @param region
     */
    public void dropCarriable(Region region, Good good){

    }

    /**
     * TODO: to be implemented, pass a list of transporters or ITERATOR owned by the player given a region
     * @param region
     * @return
     */
    public List<Transporter> getTransporters(Region region){
        return null;
    }

    /**
     * TODO: to be implemented, given a tile and a list of vertices return a region
     * @return
     */
    public Region getRegion(/*put the tile and the set of vertices*/){
        return  null;
    }


}
