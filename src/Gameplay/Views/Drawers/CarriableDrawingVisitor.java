package Gameplay.Views.Drawers;

import Gameplay.Model.Goods.*;
import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Transporters.LandTransporters.Truck;
import Gameplay.Model.Transporters.LandTransporters.Wagon;
import Gameplay.Model.Transporters.WaterTransporter.Raft;
import Gameplay.Model.Transporters.WaterTransporter.Rowboat;
import Gameplay.Model.Transporters.WaterTransporter.Steamer;
import Gameplay.Model.Visitors.CarriableVisitor;
import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.image.BufferedImage;

/**
 * Created by Willie on 4/16/2017.
 */
public class CarriableDrawingVisitor implements CarriableVisitor {

    private BufferedImage image;
    private PixelPoint origin;

    public CarriableDrawingVisitor(PixelPoint origin) {
        this.origin = origin;
    }

    @Override
    public void visitBoard(Board b) {
        image = ImageLoader.getImage("BOARD");
    }

    @Override
    public void visitClay(Clay c) {
        image = ImageLoader.getImage("CLAY");
    }

    @Override
    public void visitCoins(Coins c) {
        image = ImageLoader.getImage("COINS");
    }

    @Override
    public void visitFuel(Fuel f) {
        image = ImageLoader.getImage("FUEL");
    }

    @Override
    public void visitGold(Gold g) {
        image = ImageLoader.getImage("GOLD");
    }

    @Override
    public void visitGoose(Goose g) {
        image = ImageLoader.getImage("GOOSE");
    }

    @Override
    public void visitIron(Iron i) {
        image = ImageLoader.getImage("IRON");
    }

    @Override
    public void visitPaper(Paper p) {
        image = ImageLoader.getImage("PAPER");
    }

    @Override
    public void visitStock(Stock s) {
        image = ImageLoader.getImage("STOCK");
    }

    @Override
    public void visitStone(Stone s) {
        image = ImageLoader.getImage("STONE");
    }

    @Override
    public void visitTrunk(Trunk t) {
        image = ImageLoader.getImage("TRUNK");
    }

    @Override
    public void visitDonkey(Donkey d) {
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

    public ImageWithLocation getImage() {
        return new ImageWithLocation(image, origin);
    }
}
