package Gameplay.Model.Visitors;

import Gameplay.Model.Goods.*;

/**
 * Created by zrgam_000 on 4/16/2017.
 */
public class GoodPickupHandler extends GoodsBagHandler {

    public GoodPickupHandler(GoodsBag goodsBag) {
        super(goodsBag);
    }

    @Override
    public void visitBoard(Board b) {
        goodsBag.addBoard(b);
    }

    @Override
    public void visitClay(Clay c) {
        goodsBag.addClay(c);
    }

    @Override
    public void visitCoins(Coins c) {
        goodsBag.addCoins(c);
    }

    @Override
    public void visitFuel(Fuel f) {
        goodsBag.addFuel(f);
    }

    @Override
    public void visitGold(Gold g) {
        goodsBag.addGold(g);
    }

    @Override
    public void visitGoose(Goose g) {
        goodsBag.addGoose(g);
    }

    @Override
    public void visitIron(Iron i) {
        goodsBag.addIron(i);
    }

    @Override
    public void visitPaper(Paper p) {
        goodsBag.addPaper(p);
    }

    @Override
    public void visitStock(Stock s) {
        goodsBag.addStock(s);
    }

    @Override
    public void visitStone(Stone s) {
        goodsBag.addStone(s);
    }

    @Override
    public void visitTrunk(Trunk t) {
        goodsBag.addTrunk(t);
    }
}
