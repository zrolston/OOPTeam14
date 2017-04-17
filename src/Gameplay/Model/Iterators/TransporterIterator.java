package Gameplay.Model.Iterators;

import Gameplay.Model.Transporters.Transporter;
import Gameplay.Views.Drawers.CarriableDrawingVisitor;
import Gameplay.Views.Drawers.TransporterDrawingVisitor;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class TransporterIterator implements StuffIterator {
    private List<Transporter> transporters;
    int cur, size;

    public TransporterIterator(List<Transporter> transporters){
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

    @Override
    public BufferedImage getImage() {
        TransporterDrawingVisitor t = new TransporterDrawingVisitor();
        getCurrent().accept(t);
        BufferedImage transporterImage = t.getImage();
        return transporterImage;
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
