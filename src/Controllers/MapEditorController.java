package Controllers;

import Controllers.KeyboardListeners.EditorKeyboardListener;
import Controllers.MouseListeners.MapSubsectionMouseListener;
import Model.ModelFacade;
import Views.MapEditor.MapEditorView;

/**
 * Created by jordi on 3/26/2017.
 */
public class MapEditorController {
    EditorKeyboardListener keyboardListener;
    MapSubsectionMouseListener mouseListener;

    public MapEditorController(ModelFacade modelFacade, MapEditorView mapEditorView) {
        initializeListeners(modelFacade,mapEditorView);
        linkListenersToView(mapEditorView);
    }

    private void initializeListeners(ModelFacade modelFacade, MapEditorView mapEditorView) {
        keyboardListener = new EditorKeyboardListener(modelFacade, mapEditorView);
        mouseListener = new MapSubsectionMouseListener(modelFacade);
    }
    private void linkListenersToView(MapEditorView mapEditorView){
        //TODO: link the views to the listeners
    }

    public EditorKeyboardListener getKeyboardListener() {
        return keyboardListener;
    }

    public MapSubsectionMouseListener getMouseListener() {
        return mouseListener;
    }
}
