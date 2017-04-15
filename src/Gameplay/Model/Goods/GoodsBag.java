package Gameplay.Model.Goods;

import java.util.ArrayList;
import java.util.List;

public class GoodsBag {
    private List<Board> boardList;
    private List<Clay> clayList;
    private List<Coins> coinsList;
    private List<Fuel> fuelList;
    private List<Gold> goldList;
    private List<Goose> gooseList;
    private List<Iron> ironList;
    private List<Paper> paperList;
    private List<Stock> stockList;
    private List<Stone> stoneList;
    private List<Trunk> trunkList;

    public GoodsBag() {
        boardList = new ArrayList<Board>();
        clayList = new ArrayList<Clay>();
        coinsList = new ArrayList<Coins>();
        fuelList = new ArrayList<Fuel>();
        goldList = new ArrayList<Gold>();
        gooseList = new ArrayList<Goose>();
        ironList = new ArrayList<Iron>();
        paperList = new ArrayList<Paper>();
        stockList = new ArrayList<Stock>();
        stoneList = new ArrayList<Stone>();
        trunkList = new ArrayList<Trunk>();
    }

    protected List<Board> getBoardList() {
        return boardList;
    }
    protected List<Clay> getClayList() {
        return clayList;
    }
    protected List<Coins> getCoinsList() {
        return coinsList;
    }
    protected List<Fuel> getFuelList() {
        return fuelList;
    }
    protected List<Gold> getGoldList() {
        return goldList;
    }
    protected List<Goose> getGooseList() {
        return gooseList;
    }
    protected List<Iron> getIronList() {
        return ironList;
    }
    protected List<Paper> getPaperList() {
        return paperList;
    }
    protected List<Stock> getStockList() {
        return stockList;
    }
    protected List<Stone> getStoneList() {
        return stoneList;
    }
    protected List<Trunk> getTrunkList() {
        return trunkList;
    }

    public void addBoard(Board board){
        boardList.add(board);
    }
    public void addClay(Clay clay){
        clayList.add(clay);
    }
    public void addCoins(Coins coins){
        coinsList.add(coins);
    }
    public void addFuel(Fuel fuel){
        fuelList.add(fuel);
    }
    public void addGold(Gold gold){
        goldList.add(gold);
    }
    public void addGoose(Goose goose){
        gooseList.add(goose);
    }
    public void addIron(Iron iron){
        ironList.add(iron);
    }
    public void addPaper(Paper paper){
        paperList.add(paper);
    }
    public void addStock(Stock stock){
        stockList.add(stock);
    }
    public void addStone(Stone stone){
        stoneList.add(stone);
    }
    public void addTrunk(Trunk trunk){
        trunkList.add(trunk);
    }

    public int numBoard() {
        return boardList.size();
    }
    public int numClay() {
        return clayList.size();
    }
    public int numCoins() {
        return coinsList.size();
    }
    public int numFuel() {
        return fuelList.size();
    }
    public int numGold() {
        return goldList.size();
    }
    public int numGoose() {
        return gooseList.size();
    }
    public int numIron() {
        return ironList.size();
    }
    public int numPaper() {
        return paperList.size();
    }
    public int numStock() {
        return stockList.size();
    }
    public int numStone() {
        return stoneList.size();
    }
    public int numTrunk() {
        return trunkList.size();
    }
    public int numTotal() {
        return numBoard() + numClay() + numCoins() + numFuel() + numGold() + numGoose() + numIron() + numPaper() + numStock() + numStone() + numTrunk();
    }

    protected Board removeBoard() {
        return boardList.remove(0);
    }
    protected Clay removeClay() {
        return clayList.remove(0);
    }
    protected Coins removeCoins() {
        return coinsList.remove(0);
    }
    protected Fuel removeFuel() {
        return fuelList.remove(0);
    }
    protected Gold removeGold() {
        return goldList.remove(0);
    }
    protected Goose removeGoose() {
        return gooseList.remove(0);
    }
    protected Iron removeIron() {
        return ironList.remove(0);
    }
    protected Paper removePaper() {
        return paperList.remove(0);
    }
    protected Stock removeStock() {
        return stockList.remove(0);
    }
    protected Stone removeStone() {
        return stoneList.remove(0);
    }
    protected Trunk removeTrunk() {
        return trunkList.remove(0);
    }

    public GoodsBag add(GoodsBag gb) {
        boardList.addAll(gb.getBoardList());
        clayList.addAll(gb.getClayList());
        coinsList.addAll(gb.getCoinsList());
        fuelList.addAll(gb.getFuelList());
        goldList.addAll(gb.getGoldList());
        gooseList.addAll(gb.getGooseList());
        ironList.addAll(gb.getIronList());
        paperList.addAll(gb.getPaperList());
        stockList.addAll(gb.getStockList());
        stoneList.addAll(gb.getStoneList());
        trunkList.addAll(gb.getTrunkList());
        return new GoodsBag();
    }
    public GoodsBag remove(GoodsBag gb) {
        GoodsBag ret = new GoodsBag();
        for (int i = 0; i < gb.numBoard(); i++)
            ret.addBoard(gb.removeBoard());
        for (int i = 0; i < gb.numClay(); i++)
            ret.addClay(gb.removeClay());
        for (int i = 0; i < gb.numCoins(); i++)
            ret.addCoins(gb.removeCoins());
        for (int i = 0; i < gb.numFuel(); i++)
            ret.addFuel(gb.removeFuel());
        for (int i = 0; i < gb.numGold(); i++)
            ret.addGold(gb.removeGold());
        for (int i = 0; i < gb.numGoose(); i++)
            ret.addGoose(gb.removeGoose());
        for (int i = 0; i < gb.numIron(); i++)
            ret.addIron(gb.removeIron());
        for (int i = 0; i < gb.numPaper(); i++)
            ret.addPaper(gb.removePaper());
        for (int i = 0; i < gb.numStock(); i++)
            ret.addStock(gb.removeStock());
        for (int i = 0; i < gb.numStone(); i++)
            ret.addStone(gb.removeStone());
        for (int i = 0; i < gb.numTrunk(); i++)
            ret.addTrunk(gb.removeTrunk());
        return ret;
    }
    public boolean contains(GoodsBag gb) {
        if (this.numBoard() < gb.numBoard())
            return false;
        else if (this.numClay() < gb.numClay())
            return false;
        else if (this.numCoins() < gb.numCoins())
            return false;
        else if (this.numFuel() < gb.numFuel())
            return false;
        else if (this.numGold() < gb.numGold())
            return false;
        else if (this.numGoose() < gb.numGoose())
            return false;
        else if (this.numIron() < gb.numIron())
            return false;
        else if (this.numPaper() < gb.numPaper())
            return false;
        else if (this.numStock() < gb.numStock())
            return false;
        else if (this.numStone() < gb.numStone())
            return false;
        else if (this.numTrunk() < gb.numTrunk())
            return false;
        else
            return true;
    }
}
