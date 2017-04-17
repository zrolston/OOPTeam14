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
import Gameplay.Model.TransporterFactory.*;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.Carriable;
import Gameplay.Model.Visitors.DropOffExchangeHandler;
import Gameplay.Model.Visitors.PickUpExchangeHandler;
import Gameplay.Model.Visitors.RegionPlacableVisitor;

import java.util.*;

public class GameModelFacade { //TODO make an abstract facade
    static GameModelFacade gameModelFacade;
    private GameMap gameMap;
    private static int maxMapLength, maxMapWidth;
    public TransporterHandler transporterHandler;
    private GoodsHandler goodsHandler;
    private PrimaryProducerHandler primaryProducerHandler;
    private SecondaryProducerHandler secondaryProducerHandler;
    private MovementManager movementManager;
    private WallHandler wallHandler;

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
//        transporterHandler = new TransporterHandler();
        primaryProducerHandler = new PrimaryProducerHandler();
        secondaryProducerHandler = new SecondaryProducerHandler();
        wallHandler = new WallHandler();

        try {
            gameMap.getTiles()[10][10].getRegionMap().getRegionAt(HexaVertex.createVertex(4)).getRegionSet().addRoadRegion(
                    gameMap.getTiles()[10][11].getRegionMap().getRegionAt(HexaVertex.createVertex(5))
            );
            gameMap.getTiles()[10][10].getRegionMap().getRegionAt(HexaVertex.createVertex(1)).getRegionSet().addBridgeRegion(
                    gameMap.getTiles()[10][10].getRegionMap().getRegionAt(HexaVertex.createVertex(3))
            );
        } catch(Exception e) {}

        GameTile tile1 = gameMap.getTiles()[10][10];
        GameTile tile2 = gameMap.getTiles()[11][10];

        try {
            wallHandler.addWall(tile1.getRegionAtHexaVertex(HexaVertex.createVertex(4)), tile2.getRegionAtHexaVertex(HexaVertex.createVertex(6)), new Wall());
            Wall wall = wallHandler.getWallAt(tile1.getRegionAtHexaVertex(HexaVertex.createVertex(1)), tile2.getRegionAtHexaVertex(HexaVertex.createVertex(1)));
        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    private void setUpGoodsHandler() {

        TransporterFactory t = new DonkeyFactory();
        TransporterFactory t2 = new WagonFactory();

        PlayerID p2 = new PlayerID(0);

        goodsHandler = new GoodsHandler();
        transporterHandler = new TransporterHandler();
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
                        // TODO: DELETE THIS
                        GoodsBag gb = new GoodsBag();
                        gb.addBoard(new Board());
                        goodsHandler.place(gb, r);

                        // TODO: DELETE THIS
                        Transporter tt = t.create();

                        tt.pickUpGood( new Board() );


                        tt.setPlayerID( p2 );

                        Transporter ttt = t2.create();
                        ttt.setPlayerID( p2 );
                        transporterHandler.place(tt, r);
                        transporterHandler.place(ttt, r);
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

    public void move(Region region, Transporter transporter){
        movementManager.move(transporter, region, false);
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
    public TransporterIterator getTransporters(Region region){
        return new TransporterIterator(transporterHandler.getTransportersAt(region));
    }

    public List<Region> getAllRegionsWithTransporter() {
        return transporterHandler.getAllRegions();
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

    public List<Region> getAllRegionsWithProducer() {
        List<Region> regions = new ArrayList<Region>();
        regions.addAll(primaryProducerHandler.getBuiltRegions());
        regions.addAll(secondaryProducerHandler.getBuiltRegions());
        return regions;
    }

    public GoodsBag getGoodsBag(Region region) {
        return goodsHandler.getGoodsBagAt(region);
    }

    public List<Region> getAllRegionsWithGoodsBag() {
        return goodsHandler.getAllRegions();
    }

    public Map<Region, Region> getAllRoads() {
        Map<Region, Region> roads = new HashMap<Region, Region>();
        GameTile[][] tiles = gameMap.getTiles();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                Iterator<Region> regions = tiles[i][j].getMyRegions();
                while (regions.hasNext()) {
                    Region region1 = regions.next();
                    for (Region region2 : region1.getRegionSet().getRoadRegions())
                        roads.put(region1, region2);
                }
            }
        }
        return roads;
    }

    public Map<Region, Region> getAllBridges() {
        Map<Region, Region> bridges = new HashMap<Region, Region>();
        GameTile[][] tiles = gameMap.getTiles();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                Iterator<Region> regions = tiles[i][j].getMyRegions();
                while (regions.hasNext()) {
                    Region region1 = regions.next();
                    for (Region region2 : region1.getRegionSet().getBridgeRegions())
                        bridges.put(region1, region2);
                }
            }
        }
        return bridges;
    }

    public Map<GameTile, Map<GameTile, Wall>> getAllWalls() {
        Map<GameTile, Map<GameTile, Wall>> walls = new HashMap<GameTile, Map<GameTile, Wall>>();
        Map<Region, Map<Region, Wall>> regionWalls = wallHandler.getAllWalls();
        for (Region region1 : regionWalls.keySet()) {
            for (Region region2 : regionWalls.get(region1).keySet()) {
                Map<GameTile, Wall> wallMap = new HashMap<GameTile, Wall>();
                wallMap.put(region2.getParentTile(), regionWalls.get(region1).get(region2));
                walls.put(region1.getParentTile(), wallMap);
            }
        }
        return walls;
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
