package Gameplay.Model.Region;

import java.util.ArrayList;
import java.util.List;

public class RegionSet {
    private List<Region> landRegions;
    private List<Region> roadRegions;
    private List<Region> waterRegions;
    private List<Region> dockRegions;
    private List<Region> portRegions;

    public List<Region> getLandRegions() {
        return landRegions;
    }
    public List<Region> getRoadRegions() {
        return roadRegions;
    }
    public List<Region> getWaterRegions() {
        return waterRegions;
    }
    public List<Region> getDockRegions() {
        return dockRegions;
    }
    public List<Region> getPortRegions() {
        return portRegions;
    }

    public RegionSet(){
        landRegions = new ArrayList<>();
        roadRegions = new ArrayList<>();
        waterRegions = new ArrayList<>();
        dockRegions = new ArrayList<>();
    }

    ///////MUTATORS////////

    public void addLandRegion(Region landRegion) {

        if(!this.landRegions.contains(landRegion)) {
            this.landRegions.add(landRegion);
        }

    }
    public void removeLandRegion(Region landRegion) {
        this.landRegions.remove(landRegion);
    }

    public void addRoadRegion(Region roadRegion) {

        if (!this.roadRegions.contains(roadRegion)){
            this.roadRegions.add(roadRegion);
        }

    }
    public void removeRoadRegion(Region roadRegion) {
        this.roadRegions.remove(roadRegion);
    }

    public void addWaterRegion(Region waterRegion) {

        if(!this.waterRegions.contains(waterRegion)) {
            this.waterRegions.add(waterRegion);
        }

    }
    public void removeWaterRegion(Region waterRegion) {
        this.waterRegions.remove(waterRegion);
    }

    public void addDockRegion(Region dockRegion) {

        if(!this.dockRegions.contains(dockRegion)) {
            this.dockRegions.add(dockRegion);
        }

    }
    public void removeDockRegion(Region dockRegion) {
        this.dockRegions.remove(dockRegion);
    }

    public void addPortRegion(Region portRegion) {

        if(!this.portRegions.contains(portRegion)) {
            this.portRegions.add(portRegion);
        }

    }
    public void removePortRegion(Region portRegion) {
        this.portRegions.remove(portRegion);
    }


}
