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

    public Transporter getTransporterAt(int number) {
        if (isInBounds(number)) {
            return transporters.get(number);
        }
        return null;
    }

    private boolean isInBounds(int number) {
        return number >= 0 && number < transporters.size();
    }
}
