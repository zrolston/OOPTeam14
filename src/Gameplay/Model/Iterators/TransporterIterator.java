package Gameplay.Model.Iterators;

import Gameplay.Model.Transporters.Transporter;

import java.util.ArrayList;

public class TransporterIterator implements StuffIterator {
    private ArrayList<Transporter> transporters;
    int cur, size;

    public TransporterIterator(ArrayList<Transporter> transporters){
        this.transporters = transporters;
        size = transporters.size();
        cur = 0;
    }

    @Override
    public void first() {
        cur = 0;
    }

    @Override
    public void next() {
        if(cur == size){
            return;
        }
        cur++;
    }

    @Override
    public Transporter getCurrent() {
        return transporters.get(cur);
    }

    @Override
    public int size() {
        return size;
    }
}
