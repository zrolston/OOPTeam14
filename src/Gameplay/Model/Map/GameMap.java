package Gameplay.Model.Map;

import Gameplay.Model.Tile.GameTile;
import MapBuilder.Model.Map.IViewMap;
import MapBuilder.Model.Tile.Tile;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.ILocation;
import MapBuilder.Model.Visitor.MapVisitor;

import Gameplay.Model.Utility.HexaVertex;

import java.util.ArrayList;

public class GameMap implements IViewMap{
    private int tileCount, length, width;
    private GameTile[][] map;

    public GameMap(int maxLength, int maxWidth){
        this.length = maxLength;
        this.width = maxWidth;
        this.tileCount = 0;
        map = new GameTile[length][width];
    }

    public void initialize(GameTile[][] tiles){
        map = tiles;
    }

    @Override
    public Tile getTileAt(ILocation location) {
        return map[location.getRow()][location.getCol()];
    }

    @Override
    public void accept(MapVisitor v) {

    }

    @Override
    public GameTile[][] getTiles() {
        return map;
    }

    @Override
    public GameTile[][] getTiles(ILocation topLeft, ILocation bottomRight) {
        int col1 = topLeft.getCol();
        int col2 = bottomRight.getCol();
        int row1 = topLeft.getRow();
        int row2 = bottomRight.getRow();

        GameTile[][] window = new GameTile[Math.abs(col2 - col1) + 1][Math.abs(row2 - row1) + 1];

        //TODO what if map at indices has no tile
        for (int i = col1, _i = 0; i <= col2; i++, _i++){
            for (int j = row1, _j = 0; j <= row2; j++, _j++){
                window[_i][_j] = map[i][j];
            }
        }
        return window;
    }

    private void addTile(GameTile tile, ILocation location){

        if(map[location.getRow()][location.getCol()] == null){
            tileCount++;
        }

        map[location.getRow()][location.getCol()] = tile;

    }

    public int getLength(){
        return length;
    }

    public int getWidth(){
        return width;
    }

    private void generateConnections() {
        ILocation start = this.getFirstValidLocation();

        ArrayList<HexaVertex> vertices = HexaVertex.getAllPossible();
    }

    private ILocation getFirstValidLocation(){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] != null){
                    return new HexLocation(i, j);
                }
            }
        }

        return null;
    }
}
