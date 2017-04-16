package Gameplay.Model.Map;

import Gameplay.Model.Region.Region;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public class WallHandler {
    private Map<Region, Map<Region, Wall>> walls;

    public WallHandler(){
        walls = new HashMap<>();
    }

    public void addWall(Region r1, Region r2, Wall wall){
        Map<Region, Wall> regionWalls = walls.get(r1);

        if(regionWalls == null){
            regionWalls = new HashMap<Region, Wall>();
            walls.put(r1, regionWalls);
        }

        regionWalls.put(r2, wall);

    }

    public Wall getWallAt(Region r1, Region r2){
        Map<Region, Wall> regionWalls = walls.get(r1);

        if(regionWalls == null){
            return null;
        }

        return regionWalls.get(r2);
    }
}
