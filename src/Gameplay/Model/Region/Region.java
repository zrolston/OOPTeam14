package Gameplay.Model.Region;

import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.ConnectionGenerator;
import Gameplay.Model.Visitors.RegionVisitor;

abstract public class Region {
    private RegionSet regionSet;
    private GameTile parentTile = null;

    public Region() {
        regionSet = new RegionSet();
    }

    public abstract void accept(RegionVisitor rv);

    public abstract ConnectionGenerator getConnectionGenerator();

    public void configureParent(GameTile tile){
        if (!hasParentTile()){
            this.parentTile = tile;
        }
    }

    public RegionSet getRegionSet(){
        return regionSet;
    }

    public void enterRegion(Transporter transporter){
        transporter.setCurrentRegion(this);
        transporter.updateMovementSet(getRegionSet());
    }

    public boolean connectsToByLand(Region r2) {
        return regionSet.connectsByLand(r2);
    }

    private boolean hasParentTile(){
        return (parentTile != null);
    }

    public GameTile getParentTile(){
        return parentTile;
    }
}
