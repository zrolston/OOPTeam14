package Gameplay.Model.Utility;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Transporters.Transporter;

import java.util.ArrayList;
import java.util.List;

public class TransporterOccupancy {
    Region region;
    List<Transporter> transporters;

    public TransporterOccupancy(Region region){
        this.region = region;
        transporters = new ArrayList<>();
    }

    public void remove(Transporter transporter){
        transporters.remove(transporter);
    }

    public void add(Transporter transporter){
        transporters.add(transporter);
    }

    public boolean isEmpty(){
        return transporters.isEmpty();
    }

    public List<Transporter> getTransporters(){
        return transporters;
    }

    public List<Transporter> getOwnedTransporters(Owned player){
        List<Transporter> myTransporters = new ArrayList<>();

        for(Transporter t : transporters){
            if(t.matches(player)){
                myTransporters.add(t);
            }
        }

        return myTransporters;
    }

    public int getSize(){
        return transporters.size();
    }

    public Region getRegion() {
        return region;
    }
}
