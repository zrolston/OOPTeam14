package Gameplay.Model.Region;

import java.util.List;

public class RegionSet {
    private List<Region> landRegions;
    private List<Region> roadRegions;
    private List<Region> waterRegions;
    private List<Region> dockRegions;

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

    ///////MUTATORS////////

    public void addLandRegion(Region landRegion) {

        if(!this.landRegions.contains(landRegion)) {
            this.landRegions.add(landRegion);
        }

    }
    public void removeLandRegion(Region landRegion) {
        this.landRegions.remove(landRegion);
    }

    public void addRoadRegion(Region landRegion) {

        if (!this.roadRegions.contains(landRegion)){
            this.roadRegions.add(landRegion);
        }

    }
    public void removeRoadRegion(Region landRegion) {
        this.roadRegions.remove(landRegion);
    }

    public void addWaterRegion(Region landRegion) {

        if(this.waterRegions.contains(landRegion)) {
            this.waterRegions.add(landRegion);
        }

    }
    public void removeWaterRegion(Region landRegion) {
        this.waterRegions.remove(landRegion);
    }

    public void addDockRegion(Region landRegion) {

        if(this.dockRegions.contains(landRegion)) {
            this.dockRegions.add(landRegion);
        }

    }
    public void removeDockRegion(Region landRegion) {
        this.dockRegions.remove(landRegion);
    }


}
