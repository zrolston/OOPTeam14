package Model.Utility.MapParsers;

import Model.Map.BuildMap;
import Model.ModelFacade;
import Model.Tile.BuildTile;
import Model.Tile.BuildTileFactory;
import Model.Utility.FileIO;
import Model.Utility.HexLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordi on 3/27/2017.
 */
public class DaveBuilder implements MapParser {
    private FileIO fileIO = new FileIO();
    private BuildTileFactory tileFactory = new BuildTileFactory();
    private ModelFacade modelFacade=ModelFacade.getInstance();

    public void buildMap(String path) {
        String fileInfo = fileIO.loadFileText(path);
        parseData(fileInfo);
    }

    @Override
    public void parseData(String fileInfo) {

        fileInfo = cleanString(fileInfo);

        String[] tilesStringRepresentation = separateTiles(fileInfo);

         List<DaveBuilderTile> tiles=extractTilesInfo(tilesStringRepresentation);

         createMap(tiles);

    }

    /**
     * removes parenthesis from the whole string
     *
     * @param fileInfo
     * @return
     */
    public String cleanString(String fileInfo) {
        fileInfo = fileInfo.replace("(", "");
        fileInfo = fileInfo.replace(")", "");

        return fileInfo;
    }

    /**
     * separates each line of tiles
     *
     * @param fileInfo
     * @return
     */
    private String[] separateTiles(String fileInfo) {
        String[] lines = fileInfo.split("\\|");

        return lines;
    }

    /**
     * extracts the information from the arrays of strings and places it on a DaveBuilderTile list so that
     * the information for all the tiles is easily accessible
     * @param tilesStringRepresentation
     * @return
     */
    public List<DaveBuilderTile> extractTilesInfo(String[] tilesStringRepresentation) {
        List<DaveBuilderTile> tiles = new ArrayList<>();

        for (int i = 1; i < tilesStringRepresentation.length; i++) {
            String tempTile = tilesStringRepresentation[i];

            DaveBuilderTile daveBuilderTile = null;
            try {
                daveBuilderTile = separateTileParameters(tempTile);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }

            if (daveBuilderTile != null) {
                tiles.add(daveBuilderTile);
            }
        }

        return tiles;
    }

    /**
     * separates the parameters needed to create a tile
     * makes a DaveBuilderTile class that is used like a bag of information, just to be organized
     * @param tileStringRepresentation
     * @return
     */
    private DaveBuilderTile separateTileParameters(String tileStringRepresentation) throws RuntimeException {
        String[] tile = tileStringRepresentation.split(" ");
        DaveBuilderTile daveBuilderTile = new DaveBuilderTile(tile);
        return daveBuilderTile;

    }

    /**
     * gets a DaveBuilderTile and with this information creates a BuildTile
     * @param tile
     * @return
     */
    private BuildTile createTile(DaveBuilderTile tile) {
        //TODO:ask if this should go through the facade
        String terrain=tile.getTerrain();
        int [] riverIndices=tile.getRivers();
        return tileFactory.createTile(terrain, riverIndices);
    }

    /**
     * converts the tiles received into BuildTiles calling the createTile function
     * converts the location received in cube coordinates into cartesian coordinates
     * and then places these tiles on the map calling the placeTile function
     * @param tiles
     */
    private void createMap(List<DaveBuilderTile> tiles){
        for (int i = 0; i < tiles.size(); i++) {
            DaveBuilderTile tempDaveTile= tiles.get(i);

            HexLocation location= convertToOddQOffset(tempDaveTile.getCubeLocation());
            BuildTile buildTile= createTile(tempDaveTile);

            placeTile(buildTile,location);
        }
    }

    private void placeTile(BuildTile buildTile, HexLocation location) {
        modelFacade.placeTile(buildTile,location);
    }


    public HexLocation convertToOddQOffset(CubeLocation cubeLocation) {
        int x=cubeLocation.getX();
        int y=cubeLocation.getY();
        int z=cubeLocation.getZ();

        x+=modelFacade.getMapLength()/2;
        z+=modelFacade.getMapWidth()/4;

        int col = x;
        int row = z + (x - (x & 1)) / 2;

        return new HexLocation(row, col);
    }

    public CubeLocation convertToCube(int col, int row) {
        int x, y, z;
        x = col;
        z = row - (col - (col & 1)) / 2;
        y = -x - z;
        return new CubeLocation(x, y, z);
    }

    @Override
    public String saveMap(BuildMap map) {
        return null;
    }
}
