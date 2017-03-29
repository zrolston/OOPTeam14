package Model.Map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import Model.Tile.BuildTile;
import Model.Utility.HexaIndex;
import Model.Utility.ILocation;

public class PlacementManager {
    private HashMap<ILocation, Slot> slots;
    private BuildMap buildMap;
    private RiverCountVisitor riverCountVisitor;

    public PlacementManager(){
        slots = new HashMap<>();

        buildMap = BuildMap.getInstance();

        riverCountVisitor = new RiverCountVisitor();
    }

    public boolean validateMap(){
        if(this.slots.isEmpty()){
            return false;
        }

        if(!validateRivers()){
            return false;
        }

       ILocation startingLoc = this.getStartingLoc();

        return this.contiguousValidation(startingLoc);
    }

    public boolean validate(BuildTile target, ILocation loc){

        if(slots.isEmpty() && buildMap.locationInBounds(loc)){
            return true;
        }

        if(buildMap.tileExistsAt(loc) || !this.slotExistsAt(loc) || !buildMap.locationInBounds(loc)){
            return false;
        }

        Slot mySlot = slots.get(loc);
        return mySlot.checkMatch(target.getEdges());
    }

    //Precondition:  Tile/Location is a valid placement.
    public void placeTileAt(BuildTile tile, ILocation location){

        buildMap.addTile(tile, location);

        for(ILocation loc : location.getAdjacent()){
            if(slotExistsAt(loc)){
                //UPDATE CURRENT SLOT
                this.updateSlot(loc);
            }

            else if(!buildMap.tileExistsAt(loc)){
                //CREATE A NEW SLOT
                this.createSlotAt(loc);
            }
        }

        slots.remove(location);
    }

    public void removeTileAt(ILocation targetLocation){
        if (!buildMap.tileExistsAt(targetLocation)) {
            return;
        }
        buildMap.removeTile(targetLocation);

        //UPDATE SURROUNDING SLOTS
        for(ILocation adjLocation : targetLocation.getAdjacent()){
            if(slotExistsAt(adjLocation)){

                this.updateSlot(adjLocation);
            }
        }

        createSlotAt(targetLocation);
    }

    private void updateSlot(ILocation loc) {

        ILocation location;
        Slot target = slots.get(loc);
        BuildTile targetTile;

        for(HexaIndex index : HexaIndex.getAllPossible()){

            location = loc.getLocationAtIndex(index);

            if(buildMap.tileExistsAt(location) && !target.hasEdge(index)){
                targetTile = buildMap.getTileAt(location);
                target.addEdge(index, targetTile.getEdgeAt(index.getOppositeSide()));
            }

            else if(!buildMap.tileExistsAt(location) && target.hasEdge(index)){
                target.removeEdge(index);
            }
        }

        if(!target.hasEdges()){
            slots.remove(loc);
        }
    }

    private void createSlotAt(ILocation loc) {

        ILocation location;
        Slot newSlot = new Slot();
        BuildTile targetTile;

        for(HexaIndex index : HexaIndex.getAllPossible()){

            location = loc.getLocationAtIndex(index);

            if(buildMap.tileExistsAt(location)){
                targetTile = buildMap.getTileAt(location);
                newSlot.addEdge(index, targetTile.getEdgeAt(index.getOppositeSide()));
            }
        }

        if(newSlot.hasEdges()) {
            slots.put(loc, newSlot);
        }
    }

    public boolean validateRivers(){

        riverCountVisitor.clearRiverCount();

        for(Slot targetSlot: slots.values()) {

            targetSlot.accept(riverCountVisitor);

            if(riverCountVisitor.getRiverCount() != 0){
                riverCountVisitor.clearRiverCount();
                return false;
            }
        }

        return true;
    }

    private boolean contiguousValidation(ILocation startingLoc) {
        int count = 0;

        Queue<ILocation> locationQueue = new LinkedList<>();

        ILocation currentLoc;

        locationQueue.add(startingLoc);

        boolean[][] visited = new boolean[buildMap.getHEIGHT()][buildMap.getWIDTH()];

        visited[startingLoc.getRow()][startingLoc.getCol()] = true;

        while(!locationQueue.isEmpty()){
            count++;

            currentLoc = locationQueue.poll();

            for(ILocation newLoc : currentLoc.getAdjacent()){
                if(buildMap.tileExistsAt(newLoc) && !visited[newLoc.getRow()][newLoc.getCol()]){
                    locationQueue.add(newLoc);
                    visited[newLoc.getRow()][newLoc.getCol()] = true;
                }
            }
        }

        return count == buildMap.getTileCount();
    }

    private boolean slotExistsAt(ILocation location){
        if(slots.get(location) == null){
            return false;
        }
        return true;
    }

    public void clear(){
        this.slots.clear();
        this.buildMap.clear();
    }

    public int getNumSlots(){
        return slots.size();
    }

    private ILocation getStartingLoc() {

        ILocation slotLoc = null;

        for(ILocation loc : slots.keySet()){
            slotLoc = loc;
            break;
        }

        for(ILocation loc : slotLoc.getAdjacent()){
            if(buildMap.tileExistsAt(loc)){
                return loc;
            }
        }

        return null;
    }
}
