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

/**
 * Created by Willie on 4/16/2017.
 */
public class TransporterDrawingVisitor implements TransporterVisitor {

    BufferedImage image;
    PixelPoint origin;

    public void setOrigin(PixelPoint origin) {
        this.origin = origin;
    }

    @Override
    public void visitDonkey(Donkey d) {
        int i = 0;

        if(i == 0) {
            image = ImageLoader.getImage("BLUE_DONKEY");
            return;
        }

        switch (d.getPlayerID().getID()) {
            case 1:
                image = ImageLoader.getImage("BLUE_DONKEY");
                break;
            case 2:
                image = ImageLoader.getImage("ORANGE_DONKEY");
                break;
        }
    }

    @Override
    public void visitWagon(Wagon w) {
        switch (w.getPlayerID().getID()) {
            case 1:
                image = ImageLoader.getImage("BLUE_WAGON");
                break;
            case 2:
                image = ImageLoader.getImage("ORANGE_WAGON");
                break;
        }
    }

    @Override
    public void visitTruck(Truck t) {
        switch (t.getPlayerID().getID()) {
            case 1:
                image = ImageLoader.getImage("BLUE_TRUNK");
                break;
            case 2:
                image = ImageLoader.getImage("ORANGE_TRUNK");
                break;
        }
    }

    @Override
    public void visitRaft(Raft r) {
        switch (r.getPlayerID().getID()) {
            case 1:
                image = ImageLoader.getImage("BLUE_RAFT");
                break;
            case 2:
                image = ImageLoader.getImage("ORANGE_RAFT");
                break;
        }
    }

    @Override
    public void visitRowboat(Rowboat r) {
        switch (r.getPlayerID().getID()) {
            case 1:
                image = ImageLoader.getImage("BLUE_ROWBOAT");
                break;
            case 2:
                image = ImageLoader.getImage("ORANGE_ROWBOAT");
                break;
        }
    }

    @Override
    public void visitSteamer(Steamer s) {
        switch (s.getPlayerID().getID()) {
            case 1:
                image = ImageLoader.getImage("BLUE_STEAMER");
                break;
            case 2:
                image = ImageLoader.getImage("ORANGE_STEAMER");
                break;
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public ImageWithLocation getImageWithLocation() {
        return new ImageWithLocation(image, origin);
    }

}
