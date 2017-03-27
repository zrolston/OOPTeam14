package Model.Map;

import Model.Edge.Edge;
import Model.Tile.BuildTile;
import Model.Utility.HexaIndex;
import Model.Utility.ILocation;

import java.util.HashMap;

public class PlacementManager {
    private HashMap<ILocation, Slot> slots;
    private BuildMap buildMap;
    RiverCountVisitor riverCountVisitor;

    public PlacementManager(){
        slots = new HashMap<ILocation, Slot>();

        //TODO MAKE MAP SINGLETON
        //buildMap = BuildMap.getInstance();

        riverCountVisitor = new RiverCountVisitor();
    }

    private Slot getSlotAt(ILocation location){
        return slots.get(location);
    }

    public boolean validate(BuildTile target, ILocation loc){

        if(!buildMap.tileExistsAt(loc) || !this.slotExistsAt(loc)){
            return false;
        }

        Slot mySlot = slots.get(loc);
        return mySlot.checkMatch(target.getEdges());
    }


    //Precondition:  Tile/Location is a valid placement.
    public void placeTileAt(BuildTile tile, ILocation location){

        buildMap.addTile(tile, location);

        Slot targetSlot = this.getSlotAt(location);

        for(ILocation loc : location.getAdjacent()){
            if(slotExistsAt(loc)){
                //UPDATE CURRENT SLOT
                this.updateSlot(loc);
            }

            else if(!buildMap.tileExistsAt(loc) && buildMap.locationInBounds(loc)){
                //CREATE A NEW SLOT
                this.createSlotAt(loc);
            }
        }
    }

    public void removeTileAt(ILocation targetLocation){
        buildMap.removeTile(targetLocation);

        //UPDATE SURROUNDING SLOTS
        for(ILocation adjLocation : targetLocation.getAdjacent()){
            if(slotExistsAt(adjLocation)){

                this.updateSlot(adjLocation);

                if(slots.get(adjLocation).isEmpty()){
                    slots.remove(adjLocation);
                }
            }
        }

        createSlotAt(targetLocation);
    }

    private void updateSlot(ILocation loc) {

        ILocation location;
        Slot target = slots.get(loc);
        BuildTile targetTile;
        HexaIndex index = null;

        for(int i = 1; i < 7; i++){

            try {
                index = HexaIndex.createIndex(i);
            } catch (Exception e) {
                e.printStackTrace();
            }

            location = loc.getLocationAtIndex(index);

            if(buildMap.tileExistsAt(location) && !target.hasEdge(index)){
                targetTile = buildMap.getTileAt(location);
                target.addEdge(index, targetTile.getEdgeAt(index.getOppositeSide()));
            }

            else if(!buildMap.tileExistsAt(location) && target.hasEdge(index)){
                target.removeEdge(index);
            }
        }
    }

    private void createSlotAt(ILocation loc) {

        ILocation location;
        Slot newSlot = new Slot();
        BuildTile targetTile;
        HexaIndex index = null;

        for(int i = 1; i < 7; i++){

            try {
                index = HexaIndex.createIndex(i);
            } catch (Exception e) {
                e.printStackTrace();
            }

            location = loc.getLocationAtIndex(index);

            if(buildMap.tileExistsAt(location)){
                targetTile = buildMap.getTileAt(location);
                newSlot.addEdge(index, targetTile.getEdgeAt(index.getOppositeSide()));
            }
        }
    }

    public boolean validateRivers(){

        riverCountVisitor.clearRiverCount();

        for(Slot targetSlot: slots.values()) {

            for (Edge e : targetSlot.getEdges().values()) {
                e.accept(riverCountVisitor);
            }

            if(riverCountVisitor.getRiverCount() != 0){
                riverCountVisitor.clearRiverCount();
                return false;
            }
        }

        return true;
    }

    private boolean slotExistsAt(ILocation location){
        if(slots.get(location) == null){
            return false;
        }
        return true;
    }

}
