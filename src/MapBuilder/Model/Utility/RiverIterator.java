package MapBuilder.Model.Utility;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import MapBuilder.Model.Tile.BuildTile;
import MapBuilder.Model.Tile.BuildTileFactory;
import MapBuilder.Model.Tile.Tile;
import MapBuilder.Model.Visitor.TileDrawingVisitor;

public class RiverIterator implements TileIterator {
    final int[][] riverIndexList = { { }, { 1 }, { 1, 2 }, { 1, 3 }, {1, 4}, {1, 3, 5} };
    ArrayList<BuildTile> tileList;
    private BuildTile selectedTile;
    private String terrain;
    BuildTileFactory factory;
    int currentIndex;
    TileDrawingVisitor tdv;

    public RiverIterator(String terrain){
        this.terrain = terrain;
        factory = new BuildTileFactory();
        tileList = new ArrayList<>();
        tdv = new TileDrawingVisitor();
        for (int[] ints : riverIndexList) {
            BuildTile newTile = factory.createTile(terrain, ints);
            if (newTile != null){
                tileList.add(newTile);
            }
        }
        selectedTile = tileList.get(0).clone();
    }

    @Override
    public void first() {
        currentIndex = 0;
    }

    @Override
    public void next() {
        currentIndex++;
        currentIndex %= riverIndexList.length;
    }

    @Override
    public Tile current() {
        return tileList.get(currentIndex);
    }

    @Override
    public BufferedImage getImage() {
        tileList.get(currentIndex).accept(tdv);
        return tdv.getImage();
    }

    @Override
    public void rotate() {
        selectedTile.rotate();
    }

    @Override
    public TileIterator getRiverIterator() {
        return null;
    }

    @Override
    public int getSize() {
        return tileList.size();
    }

    @Override
    public void setSelectedTile(int index){
        selectedTile = tileList.get(index).clone();
    }

    @Override
    public BufferedImage getSelectedTileImage(){
        selectedTile.accept(tdv);
        return tdv.getImage();
    }

    @Override
    public Tile getSelectedTile(){
        return selectedTile;
    }
}
