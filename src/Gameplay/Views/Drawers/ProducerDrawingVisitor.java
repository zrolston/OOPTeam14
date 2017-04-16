package Gameplay.Views.Drawers;

import Gameplay.Model.Producer.PrimaryProducer.*;
import Gameplay.Model.Producer.SecondaryProducer.GoodProducer.*;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.*;
import Gameplay.Model.Visitors.ProducerVisitor;
import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.image.BufferedImage;

/**
 * Created by Willie on 4/16/2017.
 */
public class ProducerDrawingVisitor implements ProducerVisitor {

    private BufferedImage image;
    private PixelPoint origin;

    public void setOrigin(PixelPoint origin) {
        this.origin = origin;
    }

    @Override
    public void visitWoodCutter(WoodCutter wc) {
        image = ImageLoader.getImage("WOODCUTTER");
    }

    @Override
    public void visitClayPit(ClayPit cp) {
        image = ImageLoader.getImage("CLAY_PIT");
    }

    @Override
    public void visitMine(Mine m) {
        image = ImageLoader.getImage("MINE");
    }

    @Override
    public void visitStoneQuarry(StoneQuarry sq) {
        image = ImageLoader.getImage("STONE_QUARRY");
    }

    @Override
    public void visitOilRig(OilRig or) {
        image = ImageLoader.getImage("OIL_RIG");
    }

    @Override
    public void visitCoalBurner(CoalBurner cb) {
        image = ImageLoader.getImage("COAL_BURNER");
    }

    @Override
    public void visitSawmill(Sawmill s) {
        image = ImageLoader.getImage("SAWMILL");
    }

    @Override
    public void visitPapermill(Papermill p) {
        image = ImageLoader.getImage("PAPERMILL");
    }

    @Override
    public void visitStoneFactory(StoneFactory sf) {
        image = ImageLoader.getImage("STONE_FACTORY");
    }

    @Override
    public void visitMint(Mint m) {
        image = ImageLoader.getImage("MINT");
    }

    @Override
    public void visitStockMarket(StockMarket sm) {
        image = ImageLoader.getImage("STOCK_MARKET");
    }

    @Override
    public void visitWagonFactory(WagonProducer wf) {
        image = ImageLoader.getImage("WAGON_FACTORY");
    }

    @Override
    public void visitTruckFactory(TruckProducer tf) {
        image = ImageLoader.getImage("TRUCK_FACTORY");
    }

    @Override
    public void visitRaftFactory(RaftProducer rf) {
        image = ImageLoader.getImage("RAFT_FACTORY");
    }

    @Override
    public void visitRowboatFactory(RowboatProducer rf) {
        image = ImageLoader.getImage("ROWBOAT_FACTORY");
    }

    @Override
    public void visitSteamerFactory(SteamerProducer sf) {
        image = ImageLoader.getImage("STEAMER_FACTORY");
    }

    public BufferedImage getImage() {
        return image;
    }

    public ImageWithLocation getImageWithLocation() {
        return new ImageWithLocation(image, origin);
    }

}
