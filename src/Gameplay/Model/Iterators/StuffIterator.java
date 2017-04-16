package Gameplay.Model.Iterators;

import Gameplay.Model.Visitors.Carriable;

public interface StuffIterator {
    void first();
    void next();
    Carriable getCurrent();
    int size();
}
