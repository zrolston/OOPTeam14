package Gameplay.Model.Map;

import Gameplay.Model.Region.LandRegion;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.HexaVertex;
import Gameplay.Model.Utility.Owned;

import java.util.*;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public class WallHandler {
    private Map<Region, List<Wall>> regionWalls;

    public WallHandler(){
        regionWalls = new HashMap<Region, List<Wall>>();
    }

    public void addWall(Region r1, Region r2, Wall wall){

        GameTile t1 = r1.getParentTile();
        GameTile t2 = r2.getParentTile();

        List<HexaVertex> v1 = GameModelFacade.getInstance().debugGetMap().getVertices(t1, t2);
        List<HexaVertex> v2 = GameModelFacade.getInstance().debugGetMap().getVertices(t2, t1);

        Set<Region> regions1 = new HashSet<Region>();
        Set<Region> regions2 = new HashSet<Region>();

        for (HexaVertex hv : v1) {
            if (t1.getRegionAtHexaVertex(hv) != null) {
                regions1.add(t1.getRegionAtHexaVertex(hv));
            }
        }
        for (HexaVertex hv : v2) {
            if (t2.getRegionAtHexaVertex(hv) != null) {
                regions2.add(t2.getRegionAtHexaVertex(hv));
            }
        }

        for (Region region1 : regions1) {
            for (Region region2 : regions2) {
                List<Wall> region1Walls = regionWalls.get(region1);
                if (region1Walls == null) {
                    region1Walls = new ArrayList<Wall>();
                    regionWalls.put(region1, region1Walls);
                }
                List<Wall> region2Walls = regionWalls.get(region2);
                if (region2Walls == null) {
                    region2Walls = new ArrayList<Wall>();
                    regionWalls.put(region2, region2Walls);
                }

                region1Walls.add(wall);
                region2Walls.add(wall);
            }
        }
    }

    public Wall getWallAt(Region r1, Region r2){
        List<Wall> r1Walls = regionWalls.get(r1);
        List<Wall> r2Walls = regionWalls.get(r2);
        if ((r1Walls == null) || (r2Walls == null))
            return null;
        for (Wall wall1 : r1Walls) {
            for (Wall wall2 : r2Walls) {
                if (wall1 == wall2) {
                    return wall1;
                }
            }
        }
        return null;
    }

    public Map<Region, Map<Region, Wall>> getAllWalls() {
        Map<Region, Map<Region, Wall>> walls = new HashMap<Region, Map<Region, Wall>>();
        for (Region region1 : regionWalls.keySet()) {
            List<Wall> walls1 = regionWalls.get(region1);
            for (Wall wall1 : walls1) {
                for (Region region2 : regionWalls.keySet()) {
                    if (region1.getParentTile() != region2.getParentTile()) {
                        List<Wall> walls2 = regionWalls.get(region2);
                        for (Wall wall2 : walls2) {
                            if (wall1 == wall2) {
                                Map<Region, Wall> wallMap = new HashMap<Region, Wall>();
                                wallMap.put(region2, wall2);
                                walls.put(region1, wallMap);
                            }
                        }
                    }
                }
            }
        }
        return walls;
    }

    public boolean canPass(Region r1, Region r2, Owned owned) {
        Wall wall = getWallAt(r1, r2);
        if (wall == null)
            return true;
        else
            return wall.matches(owned);
    }

}
