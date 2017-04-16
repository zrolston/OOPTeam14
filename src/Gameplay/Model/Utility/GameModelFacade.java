package Gameplay.Model.Utility;

import Gameplay.Model.Goods.Good;
import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Producer.Producer;
import Gameplay.Model.Region.Region;

import Gameplay.Model.Goods.*;
import Gameplay.Model.Iterators.CarriableIterator;
import Gameplay.Model.Iterators.StuffIterator;
import Gameplay.Model.Iterators.TransporterIterator;
import Gameplay.Model.Map.*;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.TransporterFactory.DonkeyFactory;
import Gameplay.Model.TransporterFactory.TransporterFactory;
import Gameplay.Model.TransporterFactory.TruckFactory;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.Carriable;
import MapBuilder.Model.Utility.MapParsers.DaveBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameModelFacade { //TODO make an abstract facade
    static GameModelFacade gameModelFacade;
    private GameMap gameMap;
    private TransporterHandler transporterHandler;
    private GoodsHandler goodsHandler;
    private PrimaryProducerHandler primaryProducerHandler;
    private SecondaryProducerHandler secondaryProducerHandler;

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
    public CarriableIterator testGetCarriablesThisShouldBeDeleted(){
        ArrayList<Carriable> transporters = new ArrayList<>();
        TransporterFactory tf = new DonkeyFactory();
        transporters.add(tf.create());
        transporters.add(tf.create());
        transporters.add(tf.create());
        tf = new TruckFactory();
        transporters.add(tf.create());
        transporters.add(tf.create());
        transporters.add(new Paper());
        transporters.add(new Gold());
        transporters.add(new Coins());
        transporters.add(new Stock());

        return new CarriableIterator(transporters);

    }

    public StuffIterator testGetTransporterIteratorDELETETHIS(){
        ArrayList<Transporter> transporters = new ArrayList<>();
        TransporterFactory tf = new DonkeyFactory();
        transporters.add(tf.create());
        transporters.add(tf.create());
        transporters.add(tf.create());
        tf = new TruckFactory();
        transporters.add(tf.create());
        transporters.add(tf.create());
        return new TransporterIterator(transporters);
    }

    public void move(Region region){

    }


    /**
     * TODO: to be implemented, made for when a transporter needs to drop a carriable on a certain tile
     * @param region
     */
    public void dropCarriable(Region region, Transporter target, Carriable good){

    }

    /**
     * TODO: to be implemented, pass a list of transporters or ITERATOR owned by the player given a region
     * @param region
     * @return
     */
    public List<Transporter> getTransporters(Region region){
        return transporterHandler.getTransportersAt(region);
    }

    public Producer getProducer(Region region) {
        Producer producer = primaryProducerHandler.getPrimaryProducerAt(region);
        if (producer != null)
            return producer;
        producer = secondaryProducerHandler.getSecondaryProducerAt(region);
        if (producer != null)
            return producer;
        producer = secondaryProducerHandler.getTransporterProducerAt(region);
        if (producer != null)
            return producer;
        return null;
    }

    public GoodsBag getGoodsBag(Region region) {
        return goodsHandler.getGoodsBagAt(region);
    }

    /**
     * TODO: to be implemented, given a tile and a list of vertices return a region
     * @return
     */
    public Region getRegion(GameTile tile, HexaVertex vertex){
        return  tile.getRegionMap().getRegionAt(vertex);
    }

    /**
     * given a transporter return its carriable depending on the phase it is in
     * @param transporter
     * @return
     */
    public CarriableIterator getTransporterCarriable(Transporter transporter){
        ArrayList<Carriable> myShit = transporter.getCarriables();

        return new CarriableIterator(myShit);
    }

    /**
     * given a region return its carriable depending on the phase
     * @param region
     * @return
     */
    public CarriableIterator getRegionCarriable(Region region){
        ArrayList<Carriable> myShit = new ArrayList<>();

        myShit.addAll(transporterHandler.getTransportersAt(region));
        myShit.addAll(goodsHandler.getGoodsBagAt(region).getGoods());

        return new CarriableIterator(myShit);
    }

}
