package Gameplay.Model.Visitors;

import Gameplay.Model.Goods.*;

public interface GoodsVisitor {
    void visitBoard(Board b);
    void visitClay(Clay c);
    void visitCoins(Coins c);
    void visitFuel(Fuel f);
    void visitGold(Gold g);
    void visitGoose(Goose g);
    void visitIron(Iron i);
    void visitPaper(Paper p);
    void visitStock(Stock s);
    void visitStone(Stone s);
    void visitTrunk(Trunk t);
}
