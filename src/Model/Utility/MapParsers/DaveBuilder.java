package Model.Utility.MapParsers;

import Model.Map.BuildMap;
import Model.ModelFacade;
import Model.Tile.BuildTile;
import Model.Tile.BuildTileFactory;
import Model.Utility.FileIO;
import Model.Utility.HexLocation;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordi on 3/27/2017.
 */
public class DaveBuilder implements MapParser {
    private FileIO fileIO = new FileIO();
    private BuildTileFactory tileFactory = new BuildTileFactory();
    private ModelFacade modelFacade = ModelFacade.getInstance();
    final JFileChooser fc = new JFileChooser();
    final static String pathname = "./res/SavedMaps/";

    public void buildMap() {
        String path = findLoadPath();

        if (!path.equals("")) {
            try {
                String fileInfo = fileIO.loadFileText(path);
                parseData(fileInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String findLoadPath() {
        String path = "";
        fc.setCurrentDirectory(new java.io.File(pathname));
        fc.setDialogTitle("Test1");

        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        }
        if (fc.getSelectedFile() != null) {
            path = fc.getSelectedFile().getAbsolutePath();
        }
        return path;
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
    private BuildTile createTile(DaveBuilderTile tile) {
        //TODO:ask if this should go through the facade
        String terrain = tile.getTerrain();
        int[] riverIndices = tile.getRivers();
        return tileFactory.createTile(terrain, riverIndices);
    }

    /**
     * converts the tiles received into BuildTiles calling the createTile function
     * converts the location received in cube coordinates into cartesian coordinates
     * and then places these tiles on the map calling the placeTile function
     *
     * @param tiles
     */
    private void createMap(List<DaveBuilderTile> tiles) {
        for (int i = 0; i < tiles.size(); i++) {
            DaveBuilderTile tempDaveTile = tiles.get(i);

            HexLocation location = convertToOddQOffset(tempDaveTile.getCubeLocation());
            BuildTile buildTile = createTile(tempDaveTile);

            placeTile(buildTile, location);
        }
    }

    private void placeTile(BuildTile buildTile, HexLocation location) {
        modelFacade.placeTile(buildTile, location);
    }


    private HexLocation convertToOddQOffset(CubeLocation cubeLocation) {
        int x = cubeLocation.getX();
        int y = cubeLocation.getY();
        int z = cubeLocation.getZ();


        int col = x;
        int row = z + (x - (x & 1)) / 2;

        row += modelFacade.getMapLength() / 2;
        col += modelFacade.getMapWidth() / 2;


        return new HexLocation(row, col);
    }

    private CubeLocation convertToCube(int row, int col) {
        int x, y, z;
        row -= modelFacade.getMapLength() / 2;
        col -= modelFacade.getMapWidth() / 2;

        x = col;
        z = row - (col - (col & 1)) / 2;
        y = -x - z;
        return new CubeLocation(x, y, z);
    }

    @Override
    public void saveMap(BuildMap map) {
        String path = findSavePath();

        if (!path.equals("")) {

//          TODO: getTiles, get list of DaveBuilderTiles and then call format
//            String output=formatTiles();
//            saveFile(path,output);
        }
    }

    private String findSavePath() {
        String path = "";
        String txt = ".txt";
        fc.setCurrentDirectory(new java.io.File(pathname));
        fc.setFileFilter(new FileNameExtensionFilter(".txt", "txt"));
        fc.setDialogTitle("Test1");

        int result = fc.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            path = fc.getSelectedFile().getAbsolutePath();

        }

        if (!path.contains(txt)) {
            path += txt;
        }

        return path;
    }

    private void getTiles(BuildMap map) {
        int lastRow = map.getHEIGHT() - 1;
        int lastCol = map.getWIDTH() - 1;

        HexLocation topLeft = new HexLocation(0, 0);
        HexLocation bottomRight = new HexLocation(lastRow, lastCol);

        BuildTile[][] tiles = map.getTiles(topLeft, bottomRight);
    }


    /**
     * this class might seem to break LoD but in reality all this information is located in this class
     * the reason for using classes such as CubeLocation and DaveBuilderTile is so that this is more organized
     * and so that there are less bugs
     *
     * @param tiles
     * @return
     */
    private String formatTiles(DaveBuilderTile[] tiles) {
        String output = tiles.length + "\n";

        for (DaveBuilderTile tile :tiles) {
            String location = formatLocation(tile);
            String terrain = formatTerrain(tile);
            String riverEdges = formatRiverEdges(tile);

            output += location + terrain + riverEdges + "\n";
        }
        return output;
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
        String riverEdges = " (";

        for (int i = 0; i < rivers.length; i++) {
            riverEdges += rivers[i] + " ";
        }
        riverEdges += ")";

        return riverEdges;
    }

    private void saveFile(String path, String output) {
        fileIO.saveFileText(path, output);
    }


}
