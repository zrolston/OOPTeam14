package Gameplay.Model.Producer;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Transporters.Transporter;

import java.util.HashMap;
import java.util.Map;

public class UserRequest extends Request {

    private Map<GoodsBag, GoodsBag> goods;
    private Transporter inputtedTransporter;

    public UserRequest(GoodsBag regionGoodsBag) {
        goods = new HashMap<GoodsBag, GoodsBag>();
        goods.put(regionGoodsBag, new GoodsBag());
    }

    public void addGoods(GoodsBag source, GoodsBag addedGoods) {
        if (goods.containsKey(source))
            goods.get(source).add(addedGoods);
        else
            goods.put(source, addedGoods);
    }

    public void addProducedGoods(GoodsBag addedGoods) {
        for (GoodsBag goodsBag : goods.keySet()) {
            GoodsBag used = goodsBag.add(addedGoods);
            addedGoods.remove(used);
        }
    }

    public void addTransporter(Transporter transporter) {
        inputtedTransporter = transporter;
    }

    public void reset() {
        for (GoodsBag source : goods.keySet()) {
            source.add(goods.get(source));
        }
        inputtedTransporter = null;
    }

    public void removeUsed(Request r) {
        for (GoodsBag source : goods.keySet()) {
            //Removes all necessary goods possible from request
            GoodsBag temp = r.getGoodsBag().remove(goods.get(source));
            //Remove the goods used from the mapped GoodsBag's
            goods.get(source).remove(temp);
        }
    }

    public GoodsBag getGoodsBag() {
        GoodsBag allGoods = new GoodsBag();
        for (GoodsBag source : goods.keySet()) {
            allGoods.add(goods.get(source));
        }
        return allGoods;
    }

    public Transporter getTransporter() {
        return inputtedTransporter;
    }
}
