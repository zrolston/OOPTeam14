package Gameplay.Views.Drawers;

import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Transporters.LandTransporters.Truck;
import Gameplay.Model.Transporters.LandTransporters.Wagon;
import Gameplay.Model.Transporters.WaterTransporter.Raft;
import Gameplay.Model.Transporters.WaterTransporter.Rowboat;
import Gameplay.Model.Transporters.WaterTransporter.Steamer;
import Gameplay.Model.Visitors.TransporterVisitor;
import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.image.BufferedImage;

public class TransporterDrawingVisitor implements TransporterVisitor {

    BufferedImage image;
    PixelPoint center;

    public void setCenter(PixelPoint center) {
        this.center = center;
    }

    @Override
    public void visitDonkey(Donkey d) {
        image = ImageLoader.getImage(d.getPlayerID().getPlayerColor() + "_DONKEY");
    }

    @Override
    public void visitWagon(Wagon w) {
        image = ImageLoader.getImage(w.getPlayerID().getPlayerColor() + "_WAGON");
    }

    @Override
    public void visitTruck(Truck t) {
        image = ImageLoader.getImage(t.getPlayerID().getPlayerColor() + "_TRUCK");
    }

    @Override
    public void visitRaft(Raft r) {
        image = ImageLoader.getImage(r.getPlayerID().getPlayerColor() + "_RAFT");
    }

    @Override
    public void visitRowboat(Rowboat r) {
        image = ImageLoader.getImage(r.getPlayerID().getPlayerColor() + "_ROWBOAT");
    }

    @Override
    public void visitSteamer(Steamer s) {
        image = ImageLoader.getImage(s.getPlayerID().getPlayerColor() + "_STEAMER");
    }

    public BufferedImage getImage() {
        return image;
    }

    public ImageWithLocation getImageWithLocation() {
        PixelPoint origin = new PixelPoint(center.getX() - image.getWidth()/2, center.getY() - image.getHeight()/2);
        return new ImageWithLocation(image, origin);
    }

}
