package Gameplay.TileBuilding;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Gameplay.Model.Tile.GameTileBuilder;
import Gameplay.Model.Tile.GameTile;
import org.junit.Test;

import java.util.ArrayList;

public class BuildTileTest {
    private GameTile gameTile;
    private GameTileBuilder tileBuilder;

    @Test
    public void testBasicTileCreation(){
        ArrayList<Integer> riverList = new ArrayList<>();
        riverList.add(1);
        riverList.add(3);
        tileBuilder = new GameTileBuilder();
        gameTile = tileBuilder.createTile("ROCK", riverList);
    }
}
