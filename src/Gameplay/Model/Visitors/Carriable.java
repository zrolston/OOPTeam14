package Gameplay.Model.Visitors;

/**
 * Created by Willie on 4/15/2017.
 */
public interface Carriable {
    void accept(CarriableVisitor cv);
}
