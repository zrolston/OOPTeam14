package Gameplay.Model.Tile;

import MapBuilder.Model.Terrain.Terrain;

public class GameTile {
    private RegionMap regionMap;
    private Terrain terrain;

    public GameTile(Terrain terrain, RegionMap regionMap){
        this.terrain = terrain;
        this.regionMap = regionMap;
    }
}
