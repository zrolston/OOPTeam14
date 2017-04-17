package Gameplay.Model.Utility;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Visitors.Carriable;

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

}
