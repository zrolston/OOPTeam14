package MapBuilder.Model.Utility.MapParsers;

import MapBuilder.Model.ModelFacade;
import MapBuilder.Model.Tile.BuildTile;
import MapBuilder.Model.Tile.BuildTileFactory;
import MapBuilder.Model.Utility.HexLocation;

import java.util.ArrayList;
import java.util.List;

public class BuildMapDaveBuilder extends DaveBuilder {
    private BuildTileFactory tileFactory = new BuildTileFactory();
    private List<BuildTilePlacement> tilePlacements;


    @Override
    protected BuildTile createTile(DaveBuilderTile tile) {
        //TODO:ask if this should go through the facade
        String terrain = tile.getTerrain();
        int[] riverIndices = tile.getRivers();
        return tileFactory.createTile(terrain, riverIndices);
    }

    @Override
    protected void doCreateMap(List<DaveBuilderTile> tiles) {
        tilePlacements = new ArrayList<>();
        for (int i = 0; i < tiles.size(); i++) {
            DaveBuilderTile tempDaveTile = tiles.get(i);

            HexLocation location = convertToEvenQOffset(tempDaveTile.getCubeLocation());
            BuildTile buildTile = createTile(tempDaveTile);
            BuildTilePlacement tempPlacement = buildTilePlacement(buildTile, location);
            tilePlacements.add(tempPlacement);
        }
    }

    @Override
    protected void placeTiles() {
        ModelFacade facade = ModelFacade.getInstance();
        facade.placeFromFile(tilePlacements);
    }

    @Override
    protected int getMapLength() {
        ModelFacade facade = ModelFacade.getInstance();
        return facade.getMapLength();
    }

    @Override
    protected int getMapWidth() {
        ModelFacade facade = ModelFacade.getInstance();
        return facade.getMapWidth();
    }

    private BuildTilePlacement buildTilePlacement(BuildTile tile, HexLocation location) {
        return new BuildTilePlacement(tile, location);
    }
}
