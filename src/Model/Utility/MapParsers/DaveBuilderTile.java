package Model.Utility.MapParsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jordi on 3/27/2017.
 *
 * This class is used as a data bag for placing tiles
 *
 */
public class DaveBuilderTile {
    private CubeLocation cubeLocation;
    private String terrain;
    private int[] rivers = new int[3];
    //TODO: ask if checking for empty array of rivers

    public DaveBuilderTile(String[] tile) throws RuntimeException {


        if (tile.length < 4) {
            throw new RuntimeException("Not enough parameters for tiles");
        }
        buildLocation(tile);
        setTerrain(tile[3]);
        setRivers(tile);
    }

    private void buildLocation(String[] location) {
        int x, y, z;

        x = Integer.parseInt(location[0]);
        y = Integer.parseInt(location[1]);
        z = Integer.parseInt(location[2]);

        cubeLocation = new CubeLocation(x, y, z);
    }

    private void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    private void setRivers(String[] tile) {
        if (tile.length > 4) {
            for (int i = 4; i < tile.length && i < 7; i++) {
                int temp = Integer.parseInt(tile[i]);
                this.rivers[i-4]=temp;
            }
        }
    }

    public CubeLocation getCubeLocation() {
        return cubeLocation;
    }

    public String getTerrain() {
        return terrain;
    }

    public int[] getRivers() {
        return rivers;
    }
}
