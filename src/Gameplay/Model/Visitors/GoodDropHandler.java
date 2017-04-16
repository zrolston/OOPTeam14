package Gameplay.Model.Visitors;

import Gameplay.Model.Goods.*;

/**
 * Created by zrgam_000 on 4/16/2017.
 */
public class GoodDropHandler extends GoodsBagHandler {

    public GoodDropHandler(GoodsBag goodsBag) {
        super(goodsBag);
    }

    @Override
    public void visitBoard(Board b) {
        goodsBag.removeBoard();
    }

    @Override
    public void visitClay(Clay c) {
        goodsBag.removeClay();
    }

    @Override
    public void visitCoins(Coins c) {
        goodsBag.removeCoins();
    }

    @Override
    public void visitFuel(Fuel f) {
        goodsBag.removeFuel();
    }

    @Override
    public void visitGold(Gold g) {
        goodsBag.removeGold();
    }

    @Override
    public void visitGoose(Goose g) {
        goodsBag.removeGoose();
    }

    @Override
    public void visitIron(Iron i) {
        goodsBag.removeIron();
    }

    @Override
    public void visitPaper(Paper p) {
        goodsBag.removePaper();
    }

    @Override
    public void visitStock(Stock s) {
        goodsBag.removeStock();
    }

    @Override
    public void visitStone(Stone s) {
        goodsBag.removeStone();
    }

    @Override
    public void visitTrunk(Trunk t) {
        goodsBag.removeTrunk();
    }
}
