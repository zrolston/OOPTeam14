package MapBuilder.Model.Visitor;

import MapBuilder.Model.Map.IViewMap;

public interface MapVisitor {
    void visitMap(IViewMap map);
}
