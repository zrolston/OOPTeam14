package Gameplay.Views.Drawers;


import Gameplay.Model.Goods.*;
import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Transporters.LandTransporters.Truck;
import Gameplay.Model.Transporters.LandTransporters.Wagon;
import Gameplay.Model.Transporters.WaterTransporter.Raft;
import Gameplay.Model.Transporters.WaterTransporter.Rowboat;
import Gameplay.Model.Transporters.WaterTransporter.Steamer;
import Gameplay.Model.Visitors.GoodsVisitor;
import Gameplay.Model.Visitors.TransporterVisitor;
import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.image.BufferedImage;

import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Transporters.LandTransporters.Truck;
import Gameplay.Model.Transporters.LandTransporters.Wagon;
import Gameplay.Model.Transporters.WaterTransporter.Raft;
import Gameplay.Model.Transporters.WaterTransporter.Rowboat;
import Gameplay.Model.Transporters.WaterTransporter.Steamer;
import Gameplay.Model.Visitors.TransporterVisitor;
import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.image.BufferedImage;

    /**
     * Created by Willie on 4/16/2017.
     */
    public class GoodDrawingVisitor implements GoodsVisitor {

        BufferedImage image;
        PixelPoint origin;


        public GoodDrawingVisitor() {
            origin = new PixelPoint(50, 50);
        }

        public GoodDrawingVisitor(PixelPoint origin) {
            this.origin = origin;
        }

        @Override
        public void visitBoard(Board b) {

        }

        @Override
        public void visitClay(Clay c) {

        }

        @Override
        public void visitCoins(Coins c) {

        }

        @Override
        public void visitFuel(Fuel f) {

        }

        @Override
        public void visitGold(Gold g) {

        }

        @Override
        public void visitGoose(Goose g) {
            image = ImageLoader.getImage("GOOSE");

        }

        @Override
        public void visitIron(Iron i) {

        }

        @Override
        public void visitPaper(Paper p) {

        }

        @Override
        public void visitStock(Stock s) {

        }

        @Override
        public void visitStone(Stone s) {

        }

        @Override
        public void visitTrunk(Trunk t) {

        }


        public ImageWithLocation getImage() {
            return new ImageWithLocation(image, origin);
        }

        public BufferedImage getBufferedImage() {
            return image;
        }

    }


