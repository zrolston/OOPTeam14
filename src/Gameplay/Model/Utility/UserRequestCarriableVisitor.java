package Gameplay.Model.Utility;

import Gameplay.Model.Goods.*;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Transporters.LandTransporters.Truck;
import Gameplay.Model.Transporters.LandTransporters.Wagon;
import Gameplay.Model.Transporters.WaterTransporter.Raft;
import Gameplay.Model.Transporters.WaterTransporter.Rowboat;
import Gameplay.Model.Transporters.WaterTransporter.Steamer;
import Gameplay.Model.Visitors.CarriableVisitor;

/**
 * Created by Willie on 4/17/2017.
 */
public class UserRequestCarriableVisitor implements CarriableVisitor {

    private UserRequest ur;
    private GoodsBag gb;

    public UserRequestCarriableVisitor(UserRequest ur, GoodsBag gb) {
        this.ur = ur;
        this.gb = gb;
    }

    @Override
    public void visitBoard(Board b) {
        GoodsBag goodsBag = new GoodsBag();
        goodsBag.addBoard(b);
        gb.remove(goodsBag);
        ur.addGoods(gb, goodsBag);
    }

    @Override
    public void visitClay(Clay c) {
        GoodsBag goodsBag = new GoodsBag();
        goodsBag.addClay(c);
        gb.remove(goodsBag);
        ur.addGoods(gb, goodsBag);
    }

    @Override
    public void visitCoins(Coins c) {
        GoodsBag goodsBag = new GoodsBag();
        goodsBag.addCoins(c);
        gb.remove(goodsBag);
        ur.addGoods(gb, goodsBag);
    }

    @Override
    public void visitFuel(Fuel f) {
        GoodsBag goodsBag = new GoodsBag();
        goodsBag.addFuel(f);
        gb.remove(goodsBag);
        ur.addGoods(gb, goodsBag);
    }

    @Override
    public void visitGold(Gold g) {
        GoodsBag goodsBag = new GoodsBag();
        goodsBag.addGold(g);
        gb.remove(goodsBag);
        ur.addGoods(gb, goodsBag);
    }

    @Override
    public void visitGoose(Goose g) {
        GoodsBag goodsBag = new GoodsBag();
        goodsBag.addGoose(g);
        gb.remove(goodsBag);
        ur.addGoods(gb, goodsBag);
    }

    @Override
    public void visitIron(Iron i) {
        GoodsBag goodsBag = new GoodsBag();
        goodsBag.addIron(i);
        gb.remove(goodsBag);
        ur.addGoods(gb, goodsBag);
    }

    @Override
    public void visitPaper(Paper p) {
        GoodsBag goodsBag = new GoodsBag();
        goodsBag.addPaper(p);
        gb.remove(goodsBag);
        ur.addGoods(gb, goodsBag);
    }

    @Override
    public void visitStock(Stock s) {
        GoodsBag goodsBag = new GoodsBag();
        goodsBag.addStock(s);
        gb.remove(goodsBag);
        ur.addGoods(gb, goodsBag);
    }

    @Override
    public void visitStone(Stone s) {
        GoodsBag goodsBag = new GoodsBag();
        goodsBag.addStone(s);
        gb.remove(goodsBag);
        ur.addGoods(gb, goodsBag);
    }

    @Override
    public void visitTrunk(Trunk t) {
        GoodsBag goodsBag = new GoodsBag();
        goodsBag.addTrunk(t);
        gb.remove(goodsBag);
        ur.addGoods(gb, goodsBag);
    }

    @Override
    public void visitDonkey(Donkey d) {
        ur.addTransporter(d);
    }

    @Override
    public void visitWagon(Wagon w) {
        ur.addTransporter(w);
    }

    @Override
    public void visitTruck(Truck t) {
        ur.addTransporter(t);
    }

    @Override
    public void visitRaft(Raft r) {
        ur.addTransporter(r);
    }

    @Override
    public void visitRowboat(Rowboat r) {
        ur.addTransporter(r);
    }

    @Override
    public void visitSteamer(Steamer s) {
        ur.addTransporter(s);
    }
}
