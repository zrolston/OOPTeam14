package Controllers;

import Controllers.KeyboardListeners.EditorKeyboardListener;
import Controllers.MouseListeners.EditorMouseListener;
import Model.ModelFacade;
import Views.MapEditor.MapEditorView;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * Created by jordi on 3/26/2017.
 */
public class MapEditorController {
    EditorKeyboardListener keyboardListener;
    EditorMouseListener mouseListener;

    public MapEditorController(ModelFacade modelFacade, MapEditorView mapEditorView) {
        initializeListeners(modelFacade,mapEditorView);
        linkListenersToView(mapEditorView);
    }

    private void initializeListeners(ModelFacade modelFacade, MapEditorView mapEditorView) {
        keyboardListener = new EditorKeyboardListener(modelFacade, mapEditorView);
        mouseListener = new EditorMouseListener(modelFacade);
    }
    private void linkListenersToView(MapEditorView mapEditorView){
        //TODO: link the views to the listeners
    }

    public EditorKeyboardListener getKeyboardListener() {
        return keyboardListener;
    }

    public EditorMouseListener getMouseListener() {
        return mouseListener;
    }
}
