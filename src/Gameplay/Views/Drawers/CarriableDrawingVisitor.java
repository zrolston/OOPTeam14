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

import java.awt.image.BufferedImage;


public class CarriableDrawingVisitor implements CarriableVisitor {

    private BufferedImage image;

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

}
