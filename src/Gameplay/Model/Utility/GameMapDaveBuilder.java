package Gameplay.Model.Utility;

import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Tile.GameTileBuilder;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.MapParsers.DaveBuilder;
import MapBuilder.Model.Utility.MapParsers.DaveBuilderTile;

import java.util.ArrayList;
import java.util.List;

public class GameMapDaveBuilder extends DaveBuilder {
    private GameTileBuilder gameTileBuilder = new GameTileBuilder();
    private List<GameTilePlacement> tilePlacements;

    @Override
    protected GameTile createTile(DaveBuilderTile tile) {
        String terrain = tile.getTerrain();
        int[] riverIndices = tile.getRivers();
        ArrayList<Integer> riverIndicesList = new ArrayList<>();
        for (int i : riverIndices) {
            riverIndicesList.add(i);
        }
        return gameTileBuilder.createTile(
                terrain,
                riverIndicesList
        );
    }

    @Override
    protected void doCreateMap(List<DaveBuilderTile> tiles) {
        tilePlacements = new ArrayList<>();
        for (int i = 0; i < tiles.size(); i++) {
            DaveBuilderTile tempDaveTile = tiles.get(i);

            HexLocation location = convertToEvenQOffset(tempDaveTile.getCubeLocation());
            GameTile buildTile = createTile(tempDaveTile);
            GameTilePlacement tempPlacement = gameTilePlacement(buildTile, location);
            tilePlacements.add(tempPlacement);
        }
    }

    @Override
    protected void placeTiles() {
        GameModelFacade facade = GameModelFacade.getInstance();
        facade.placeFromFile(tilePlacements);
    }

    private GameTilePlacement gameTilePlacement(GameTile tile, HexLocation location) {
        return new GameTilePlacement(tile, location);
    }

    @Override
    protected int getMapLength(){
        GameModelFacade facade = GameModelFacade.getInstance();
        return facade.getMapLength();
    }

    @Override
    protected int getMapWidth(){
        GameModelFacade facade = GameModelFacade.getInstance();
        return facade.getMapWidth();
    }
}
