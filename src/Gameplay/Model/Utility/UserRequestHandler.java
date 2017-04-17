package Gameplay.Model.Utility;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Visitors.Carriable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Willie on 4/17/2017.
 */
public class UserRequestHandler {

    private UserRequest userRequest;

    public UserRequestHandler() {
        userRequest = new UserRequest();
    }

    public void reset() {
        userRequest.reset();
    }

    public void addCarriable(GoodsBag goodsBag, Carriable carriable) {
        UserRequestCarriableVisitor urcv = new UserRequestCarriableVisitor(userRequest, goodsBag);
        carriable.accept(urcv);
    }

    public List<Carriable> getCarriables() {
        List<Carriable> carriables = new ArrayList<Carriable>();
        if (userRequest.getTransporter() != null)
            carriables.add(userRequest.getTransporter());
        carriables.addAll(userRequest.getGoodsBag().getGoods());
        return carriables;
    }

}
