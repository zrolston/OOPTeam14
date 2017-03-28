package Model.Utility.MapParsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jordi on 3/27/2017.
 * <p>
 * This class is used as a data bag for placing tiles
 */
public class DaveBuilderTile {
    private CubeLocation cubeLocation;
    private String terrain;
    private int[] rivers;
    //TODO: ask if checking for empty array of rivers, more like make this an arraylist instead of an array

    public DaveBuilderTile(String[] tile) throws RuntimeException {


        if (tile.length < 4) {
            throw new RuntimeException("Not enough parameters for tiles");
        }
        buildLocation(tile);
        setTerrain(tile[3]);
        setRivers(tile);
    }

    public DaveBuilderTile(int x, int y, int z, String terrain, List<Integer> rivers) {
        this.cubeLocation = new CubeLocation(x, y, z);
        this.terrain = terrain;

        initializeRivers(rivers);
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
        int arrayLength = tile.length - 4;
        List<Integer> tempRivers = new ArrayList<>();
        if (arrayLength > 0) {
            for (int i = 0; i < arrayLength && i < 3; i++) {
                int temp = Integer.parseInt(tile[i+4]);
                tempRivers.add(temp);
            }
        }
        initializeRivers(tempRivers);
    }

    private void initializeRivers(List<Integer> tempRivers) {
        if (!tempRivers.isEmpty()) {
            rivers = new int[tempRivers.size()];
            for (int i = 0; i < tempRivers.size(); i++) {
                rivers[i]=tempRivers.get(i);
            }
        }
    }

    private boolean isEmpty(int length) {
        return length <= 0;
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

    @Override
    public String toString() {
        return "DaveBuilderTile{" +
                "cubeLocation=" + cubeLocation.toString() +
                ", terrain='" + terrain + '\'' +
                ", rivers=" + Arrays.toString(rivers) +
                '}';
    }
}
