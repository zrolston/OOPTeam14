package Gameplay.TileBuilding;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import MapBuilder.Model.Tile.BuildTile;
import MapBuilder.Model.Tile.BuildTileFactory;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Tile.TileBuildingVisitor;
import org.junit.Before;
import org.junit.Test;

public class BuildTileTest {
    private BuildTileFactory btf;
    private BuildTile buildTile;

    @Before
    public void TestSetup(){
        btf = new BuildTileFactory();
        buildTile = btf.createTile("ROCK", new int[]{1, 3, 5});
    }

    @Test
    public void testBasicTileCreation(){
        TileBuildingVisitor tbv = new TileBuildingVisitor();
        buildTile.accept(tbv);
        GameTile gameTile = tbv.getGameTile();
    }
}
