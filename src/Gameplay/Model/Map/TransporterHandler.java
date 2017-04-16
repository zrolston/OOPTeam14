package Gameplay.Model.Map;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.Owned;
import Gameplay.Model.Utility.TransporterOccupancy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TransporterHandler {
    Map<Region, TransporterOccupancy> occupancyMap;

    public TransporterHandler(){
        occupancyMap = new HashMap<>();
    }

    public void move(Transporter t, Region start, Region end){
        if (t.moveTo(end)){
            this.remove(t, start);
            this.place(t, end);
        }
    }

    public void place(Transporter t, Region region){
        TransporterOccupancy transporterOccupancy = occupancyMap.get(region);

        if(transporterOccupancy == null){
            transporterOccupancy = new TransporterOccupancy(region);
            occupancyMap.put(region, transporterOccupancy);
        }

        transporterOccupancy.add(t);

    }

    public void remove(Transporter t, Region region){
        TransporterOccupancy transporterOccupancy = occupancyMap.get(region);

        if(transporterOccupancy == null){
            return;
        }

        transporterOccupancy.remove(t);

        if(transporterOccupancy.isEmpty()){
            occupancyMap.remove(transporterOccupancy);
        }
    }

    public List<Transporter> getTransportersAt(Region r){
        List<Transporter> transporters = new ArrayList<>();

        TransporterOccupancy transporterOccupancy = occupancyMap.get(r);

        if(transporterOccupancy != null){
            transporters = transporterOccupancy.getTransporters();
        }

        return transporters;
    }

    public List<Transporter> getMyTransportersAt(Region r, Owned player){
        List<Transporter> transporters = new ArrayList<>();

        TransporterOccupancy transporterOccupancy = occupancyMap.get(r);

        if(transporterOccupancy != null){
            transporters = transporterOccupancy.getOwnedTransporters(player);
        }

        return transporters;
    }

    public TransporterOccupancy getOccupancyAt(Region r){
        return occupancyMap.get(r);
    }

    public List<Region> getAllRegions() {
        return new ArrayList<Region>(occupancyMap.keySet());
    }
}
