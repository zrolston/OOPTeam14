package Gameplay.Model.Iterators;

import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.Carriable;

import java.util.ArrayList;

public class CarriableIterator implements StuffIterator {
    private ArrayList<Carriable> carriables;
    int cur, size;

    public CarriableIterator(ArrayList<Carriable> carriables) {
        this.carriables = carriables;
        size = carriables.size();
        cur = 0;
    }

    @Override
    public void first() {
        cur = 0;
    }

    @Override
    public void next() {
        if (cur == size) {
            return;
        }
        cur++;
    }

    @Override
    public Carriable getCurrent() {
        return carriables.get(cur);
    }

    @Override
    public int size() {
        return size;
    }

    public Carriable getCarriableAt(int number) {
        if (isInBounds(number)) {
            return carriables.get(number);
        }
        return null;
    }

    private boolean isInBounds(int number) {
        return number >= 0 && number < carriables.size();
    }

    public void deleteAt(int index){
        if (isInBounds(index)) {
            carriables.remove(index);
        }
    }
}
