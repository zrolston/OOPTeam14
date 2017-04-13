package MapBuilder.Model.Utility;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import MapBuilder.Model.Tile.BuildTile;
import MapBuilder.Model.Tile.BuildTileFactory;
import MapBuilder.Model.Tile.Tile;
import MapBuilder.Model.Visitor.TileDrawingVisitor;

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
        return new RiverIterator(terrainList[currentIndex]);
    }

    @Override
    public int getSize() {
        return terrainList.length;
    }

    @Override
    public void setSelectedTile(int index) {

    }

    @Override
    public Tile getSelectedTile() {
        return null;
    }

    @Override
    public BufferedImage getSelectedTileImage() {
        return null;
    }
}
