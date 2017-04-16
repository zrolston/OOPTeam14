package Gameplay.Model.Utility;

import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Producer.Producer;
import Gameplay.Model.Region.Region;

import Gameplay.Model.Goods.*;
import Gameplay.Model.Iterators.CarriableIterator;
import Gameplay.Model.Iterators.StuffIterator;
import Gameplay.Model.Iterators.TransporterIterator;
import Gameplay.Model.Map.*;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Tile.RegionMap;
import Gameplay.Model.TransporterFactory.DonkeyFactory;
import Gameplay.Model.TransporterFactory.TransporterFactory;
import Gameplay.Model.TransporterFactory.TruckFactory;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.Carriable;
import Gameplay.Model.Visitors.DropOffExchangeHandler;
import Gameplay.Model.Visitors.PickUpExchangeHandler;
import Gameplay.Model.Visitors.RegionPlacableVisitor;
import MapBuilder.Model.Utility.MapParsers.DaveBuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameModelFacade { //TODO make an abstract facade
    static GameModelFacade gameModelFacade;
    private GameMap gameMap;
    private static int maxMapLength, maxMapWidth;
    private TransporterHandler transporterHandler;
    private GoodsHandler goodsHandler;
    private PrimaryProducerHandler primaryProducerHandler;
    private SecondaryProducerHandler secondaryProducerHandler;

    private GameModelFacade(GameMap map) {
        this.gameMap = map;
        maxMapLength = map.getLength();
        maxMapWidth = map.getWidth();
    }

    public static GameModelFacade getInstance(){
        if (isInitialized()) {
            return gameModelFacade;
        }
        return null;
    }

    public static void initialize( GameMap map ){
        if (!isInitialized()){
            gameModelFacade = new GameModelFacade(map);
        }
    }

    private static boolean isInitialized(){
        return gameModelFacade != null;
    }

    public static int getMaxMapLength(){
        return maxMapLength;
    }
    public static int getMaxMapWidth(){
        return maxMapWidth;
    }

    public GameMap debugGetMap(){
        return gameMap;
    }

    public void startGame() {
        setUpGoodsHandler();
        transporterHandler = new TransporterHandler();
        primaryProducerHandler = new PrimaryProducerHandler();
        secondaryProducerHandler = new SecondaryProducerHandler();
    }

    private void setUpGoodsHandler() {
        goodsHandler = new GoodsHandler();
        GameTile[][] tiles = gameMap.getTiles();
        RegionPlacableVisitor pcv = new RegionPlacableVisitor();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[i][j] == null)
                    continue;
                RegionMap rm = tiles[i][j].getRegionMap();
                Iterator<Region> regionIterator = rm.getMyRegions();
                while (regionIterator.hasNext()) {
                    Region r = regionIterator.next();
                    r.accept(pcv);
                    if (pcv.getPlacable()) {
                        GoodsBag gb = new GoodsBag();
                        gb.addBoard(new Board());
                        goodsHandler.place(gb, r);
                    }
                }
            }
        }
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
    public void dropCarriable(Region region, Transporter target, Carriable carriable) {
        TransporterOccupancy transporterOccupancy = transporterHandler.getOccupancyAt(region);
        GoodsBag goodsBag = goodsHandler.getGoodsBagAt(region);
        carriable.accept(new DropOffExchangeHandler(transporterOccupancy, goodsBag, target));
    }

    /**
     * TODO: to be implemented,
     * given the set of parameters pickup the transporter
     * @param region
     * @param transporter
     * @param carriable
     */
    public void pickUpCarriable(Region region, Transporter transporter, Carriable carriable){
        TransporterOccupancy transporterOccupancy = transporterHandler.getOccupancyAt(region);
        GoodsBag goodsBag = goodsHandler.getGoodsBagAt(region);
        carriable.accept(new PickUpExchangeHandler(transporterOccupancy, goodsBag, transporter));
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
