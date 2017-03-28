package Model.Utility;

import Model.Tile.BuildTile;
import Model.Tile.BuildTileFactory;
import Model.Tile.Tile;
import Model.Visitor.TileDrawingVisitor;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TerrainIterator implements TileIterator {
    final String[] terrainList = {"WOODS", "DESERT", "MOUNTAIN", "PASTURE", "ROCK", "SEA"};
    BuildTileFactory factory;
    ArrayList<BuildTile> tileList;
    int currentIndex;
    TileDrawingVisitor tdv;

    public TerrainIterator(){
        factory = new BuildTileFactory();
        tileList = new ArrayList<>();
        tdv = new TileDrawingVisitor();
        for (String s : terrainList) {
            tileList.add(
                    factory.createTile(s, new int[]{})
            );
        }
    }

    @Override
    public void first() {
        currentIndex = 0;
    }

    @Override
    public void next() {
        currentIndex++;
        currentIndex %= terrainList.length;
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
        //Do nothing
    }

    @Override
    public TileIterator getRiverIterator() {
        return null;
    }

    @Override
    public int getSize() {
        return terrainList.length;
    }
}
