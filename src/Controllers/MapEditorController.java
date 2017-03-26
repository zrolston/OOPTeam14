package Controllers;

import Controllers.KeyboardListeners.EditorKeyboardListener;
import Controllers.MouseListeners.EditorMouseListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * Created by jordi on 3/26/2017.
 */
public class MapEditorController {
    EditorKeyboardListener keyboardListener;
    EditorMouseListener mouseListener;
    List<EventListener> listeners = new ArrayList<>();              //TODO: consult if this would be helpful

    public MapEditorController() {
        //TODO: pass a facade to this
//        keyboardListener = new EditorKeyboardListener();
//        mouseListener = new EditorMouseListener();
    }

    public EditorKeyboardListener getKeyboardListener() {
        return keyboardListener;
    }

    public EditorMouseListener getMouseListener() {
        return mouseListener;
    }
}
