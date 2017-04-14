package MapBuilder.Model.Utility.MapParsers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import MapBuilder.Model.ModelFacade;
import MapBuilder.Model.Map.BuildMap;
import MapBuilder.Model.Tile.BuildTile;
import MapBuilder.Model.Utility.FileIO;
import MapBuilder.Model.Utility.HexLocation;



/**
 * Created by jordi on 3/27/2017.
 */
abstract public class DaveBuilder implements MapParser {
    private FileIO fileIO = new FileIO();

    final JFileChooser fc = new JFileChooser();
    final static String pathname = "./res/SavedMaps/";

    public void buildMap(String path) {

        if (!path.equals(null)) {
            try {
                String fileInfo = fileIO.loadFileText(path);
                parseData(fileInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void parseData(String fileInfo) {

        fileInfo = cleanString(fileInfo);

        String[] tilesStringRepresentation = separateTiles(fileInfo);

        List<DaveBuilderTile> tiles = extractTilesInfo(tilesStringRepresentation);

        createMap(tiles);

    }

    /**
     * removes parenthesis from the whole string
     *
     * @param fileInfo
     * @return
     */
    private String cleanString(String fileInfo) {
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
     *
     * @param tilesStringRepresentation
     * @return
     */
    private List<DaveBuilderTile> extractTilesInfo(String[] tilesStringRepresentation) {
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
     *
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
     *
     * @param tile
     * @return
     */
    abstract protected BuildTile createTile(DaveBuilderTile tile);

    /**
     * converts the tiles received into BuildTiles calling the createTile function
     * converts the location received in cube coordinates into cartesian coordinates
     * and then places these tiles on the map calling the placeTile function
     *
     * @param tiles
     */
    private void createMap(List<DaveBuilderTile> tiles){
        placeTiles();
        doCreateMap(tiles);
    }

    abstract protected void doCreateMap(List<DaveBuilderTile> tiles);

    abstract protected void placeTiles();

    protected HexLocation convertToEvenQOffset(CubeLocation cubeLocation) {
        ModelFacade modelFacade = ModelFacade.getInstance();
        int x = cubeLocation.getX();
        int y = cubeLocation.getY();
        int z = cubeLocation.getZ();


        int col = x;
        int row = z + (x + (x&1)) / 2;

        row += modelFacade.getMapLength() / 2;
        col += modelFacade.getMapWidth() / 2;


        return new HexLocation(row, col);
    }

    private CubeLocation convertToCube(int row, int col) {
        ModelFacade modelFacade = ModelFacade.getInstance();
        int x, y, z;
        row -= modelFacade.getMapLength() / 2;
        col -= modelFacade.getMapWidth() / 2;

        x = col;
        z = row - (col + (col&1)) / 2;
        y = -x-z;
        return new CubeLocation(x, y, z);
    }

    @Override
    public void saveMap(BuildMap map, String path) {

        if (!path.equals(null)) {
            if (!path.contains(".dave")){
                path+=".dave";
            }

            List<DaveBuilderTile> tiles = getFormattedTiles(map);
            tiles=this.convertToCenterOfMass(tiles);
            String output = formatTiles(tiles);
            saveFile(path, output);
        }
    }


    /**
     * gets a two dimensional array of tiles
     * visits every tile to extract the necessary information
     * uses that information to create formatted tiles
     * returns an array of formatted tiles in DaveBuilderTile format
     *
     * @param map
     * @return
     */
    private List<DaveBuilderTile> getFormattedTiles(BuildMap map) {
        List<DaveBuilderTile> formattedTiles = new ArrayList<>();
        int lastRow = map.getHEIGHT() - 1;
        int lastCol = map.getWIDTH() - 1;

        HexLocation topLeft = new HexLocation(0, 0);
        HexLocation bottomRight = new HexLocation(lastRow, lastCol);

        BuildTile[][] tiles = map.getTiles(topLeft, bottomRight);

        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[0].length; col++) {
                BuildTile tempTile = tiles[row][col];
                if (isValidTile(tempTile)) {
                    MapSavingVisitor visitor = new MapSavingVisitor();
                    tempTile.accept(visitor);
                    DaveBuilderTile tempFormattedTile = convertToTileFormat(row, col, visitor);
                    formattedTiles.add(tempFormattedTile);
                }
            }
        }
        return formattedTiles;
    }

    /**
     * checks that a tile is not null
     *
     * @param tile
     * @return
     */
    private boolean isValidTile(BuildTile tile) {
        return tile != null;
    }


    private DaveBuilderTile convertToTileFormat(int row, int col, MapSavingVisitor visitor) {
        CubeLocation cubeLocation = convertToCube(row, col);
        ArrayList<Integer> riverIndices = visitor.getRiverIndices();
        String terrain = visitor.getTerrain().toString();

        return new DaveBuilderTile(cubeLocation, terrain, riverIndices);
    }

    /**
     * creates the output string
     * <p>
     * this class might seem to break LoD but in reality all this information is located in this class
     * the reason for using classes such as CubeLocation and DaveBuilderTile is so that the code is more organized
     * and so that there are less bugs
     *
     * @param tiles
     * @return
     */
    private String formatTiles(List<DaveBuilderTile> tiles) {
        String output = tiles.size() + "\n";

        for (DaveBuilderTile tile : tiles) {
            String location = formatLocation(tile);
            String terrain = formatTerrain(tile);
            String riverEdges = formatRiverEdges(tile);

            output += location + terrain + riverEdges + "\n";
        }
        return output;
    }

    private List<DaveBuilderTile> convertToCenterOfMass(List<DaveBuilderTile> tiles) {
        List<DaveBuilderTile> tempList = new ArrayList<>();
        CubeLocation centerOfMass = findCenterOfMass(tiles);
        for (DaveBuilderTile tile : tiles) {
            tile.addCenterofMass(centerOfMass);
            tempList.add(tile);
        }
        return tempList;
    }

    private CubeLocation findCenterOfMass(List<DaveBuilderTile> tiles) {
        int avgX = 0, avgY = 0, avgZ = 0;
        for (DaveBuilderTile tile : tiles) {
            CubeLocation location = tile.getCubeLocation();
            avgX += location.getX();
            avgY += location.getZ();
            avgZ += location.getZ();

        }

        avgX /= tiles.size();
        avgY /= tiles.size();
        avgZ /= tiles.size();

        return new CubeLocation(avgX, avgY, avgZ);
    }

    private String formatLocation(DaveBuilderTile tile) {
        CubeLocation cubeLocation = tile.getCubeLocation();
        return "(" + cubeLocation.getX() + " " + cubeLocation.getY() + " " + cubeLocation.getZ() + ")";
    }

    private String formatTerrain(DaveBuilderTile tile) {
        return " " + tile.getTerrain();
    }

    private String formatRiverEdges(DaveBuilderTile tile) {
        int[] rivers = tile.getRivers();
        String riverEdges = "";

        if (areValidRivers(rivers)) {
            riverEdges = " (";
            for (int i = 0; i < rivers.length; i++) {
                riverEdges += rivers[i] + " ";
            }
            riverEdges += ")";
        }

        return riverEdges;
    }

    private boolean areValidRivers(int[] rivers) {
        return rivers != null;
    }

    private void saveFile(String path, String output) {
        fileIO.saveFileText(path, output);
    }


}
