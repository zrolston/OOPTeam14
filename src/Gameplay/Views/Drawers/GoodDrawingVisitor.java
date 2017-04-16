package Gameplay.Views.Drawers;

import Gameplay.Model.Goods.*;
import Gameplay.Model.Visitors.GoodsVisitor;
import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.image.BufferedImage;

/**
 * Created by Willie on 4/16/2017.
 */
public class GoodDrawingVisitor implements GoodsVisitor {

    private BufferedImage image;
    private PixelPoint origin;

    public void setOrigin(PixelPoint origin) {
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

    public BufferedImage getImage() {
        return image;
    }

    public ImageWithLocation getImageWithLocation() {
        return new ImageWithLocation(image, origin);
    }

}
