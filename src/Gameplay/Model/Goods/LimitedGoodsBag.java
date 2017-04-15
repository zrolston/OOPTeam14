package Gameplay.Model.Goods;

/**
 * Created by Willie on 4/14/2017.
 */
public class LimitedGoodsBag extends GoodsBag {
    int maxSize;

    public LimitedGoodsBag(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void addBoard(Board board){
        if (numTotal() < maxSize)
            super.addBoard(board);
    }
    @Override
    public void addClay(Clay clay){
        if (numTotal() < maxSize)
            super.addClay(clay);
    }
    @Override
    public void addCoins(Coins coins){
        if (numTotal() < maxSize)
            super.addCoins(coins);
    }
    @Override
    public void addFuel(Fuel fuel){
        if (numTotal() < maxSize)
            super.addFuel(fuel);
    }
    @Override
    public void addGold(Gold gold){
        if (numTotal() < maxSize)
            super.addGold(gold);
    }
    @Override
    public void addGoose(Goose goose){
        if (numTotal() < maxSize)
            super.addGoose(goose);
    }
    @Override
    public void addIron(Iron iron){
        if (numTotal() < maxSize)
            super.addIron(iron);
    }
    @Override
    public void addPaper(Paper paper){
        if (numTotal() < maxSize)
            super.addPaper(paper);
    }
    @Override
    public void addStock(Stock stock){
        if (numTotal() < maxSize)
            super.addStock(stock);
    }
    @Override
    public void addStone(Stone stone){
        if (numTotal() < maxSize)
            super.addStone(stone);
    }
    @Override
    public void addTrunk(Trunk trunk){
        if (numTotal() < maxSize)
            super.addTrunk(trunk);
    }

    @Override
    public GoodsBag add(GoodsBag gb) {
        GoodsBag unused = new GoodsBag();
        unused.add(gb);
        //Finish this
        return unused;
    }
}
