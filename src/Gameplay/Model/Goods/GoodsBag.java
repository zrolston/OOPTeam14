package Gameplay.Model.Goods;

import java.util.List;

public class GoodsBag {
    private List<Trunk> trunkList;
    private List<Board> boardList;
    private List<Paper> paperList;
    private List<Clay> clayList;
    private List<Stone> stoneList;
    private List<Fuel> fuelList;
    private List<Iron> ironList;
    private List<Gold> goldList;
    private List<Coins> coinsList;
    private List<Stock> stockList;
    private List<Goose> gooseList;

    public void addTrunk(Trunk trunk){
        trunkList.add(trunk);
    }
    public void addBoard(Board board){
        boardList.add(board);
    }
    public void addPaper(Paper paper){
        paperList.add(paper);
    }
    public void addClay(Clay clay){
        clayList.add(clay);
    }
    public void addStone(Stone stone){
        stoneList.add(stone);
    }
    public void addFuel(Fuel fuel){
        fuelList.add(fuel);
    }
    public void addIron(Iron iron){
        ironList.add(iron);
    }
    public void addGold(Gold gold){
        goldList.add(gold);
    }
    public void addTrunk(Coins coins){
        coinsList.add(coins);
    }
    public void addStock(Stock stock){
        stockList.add(stock);
    }
    public void addGoose(Goose goose){
        gooseList.add(goose);
    }

}
