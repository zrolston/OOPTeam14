package Model.Map;

import Model.Tile.BuildTile;
import Model.Tile.Tile;
import Model.Utility.ILocation;
import Model.Visitor.MapVisitor;

public class BuildMap implements IViewMap {

    private static BuildMap buildMap;

    private BuildTile[][] map;
    private int HEIGHT, WIDTH;
    private ValidationManager validationManager;

    private BuildMap(int length, int width){
        this.HEIGHT = length;
        this.WIDTH = width;
        map = new BuildTile[HEIGHT][WIDTH];
    }

    public static BuildMap getInstance(){
        if(buildMap == null){
            buildMap = new BuildMap(21, 21);
        }

        return buildMap;
    }

    @Override
    public void accept(MapVisitor v) {
        v.visitMap(this);
    }

    @Override
    public BuildTile[][] getTiles() {
        return this.map;
    }

    @Override
    public BuildTile[][] getTiles(ILocation topLeft, ILocation bottomRight) {
        int col1 = topLeft.getCol();
        int col2 = bottomRight.getCol();
        int row1 = topLeft.getRow();
        int row2 = bottomRight.getRow();

        BuildTile[][] window = new BuildTile[Math.abs(col2 - col1) + 1][Math.abs(row2 - row1) + 1];

        //TODO what if map at indices has no tile
        for (int i = col1, _i = 0; i <= col2; i++, _i++){
            for (int j = row1, _j = 0; j <= row2; j++, _j++){
                window[_i][_j] = map[i][j];
            }
        }
        return window;
    }

    @Override
    public Tile getTileAt(ILocation location) {
        return null;
    }

    public boolean validateMap(){
        return true;
    }
    public void addTile(BuildTile tile, ILocation location){
        map[location.getRow()][location.getCol()] = tile;
    }
    public void removeTile(ILocation location){
        map[location.getRow()][location.getCol()] = null;
    }
    public void clear(){
        for(int i = 0; i < HEIGHT; i++){
            for(int j = 0; j < WIDTH; j++){
                map[i][j] = null;
            }
        }
    }
}
