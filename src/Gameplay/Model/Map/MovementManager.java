package Gameplay.Model.Map;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Transporters.Transporter;

public class MovementManager {
    private TransporterHandler transporterHandler;
    private WallHandler wallHandler;
    private GoodsHandler goodsHandler;

    public MovementManager(TransporterHandler th, WallHandler wh, GoodsHandler gh){
        this.transporterHandler = TransporterHandler.getInstance();
        this.wallHandler = WallHandler.getInstance();
        this.goodsHandler = GoodsHandler.getInstance();
    }

    public void move(Transporter transporter, Region region, boolean geese){
        Region start = transporter.getCurrentRegion();

        if (walledOff(transporter, region)){
            return;
        }

        if(transporter.moveTo(region)){
            transporterHandler.move(transporter, start, region);

            if(geese){
                moveGeese(goodsHandler.getGoodsBagAt(start), goodsHandler.getGoodsBagAt(region));
            }
        }
    }

    private boolean walledOff(Transporter transporter, Region region){
        return !wallHandler.canPass(transporter.getCurrentRegion(), region, transporter);
    }

    private void moveGeese(GoodsBag source, GoodsBag target){
        while (source.numGoose() > 0){
            target.addGoose(source.removeGoose());
        }
    }
}
