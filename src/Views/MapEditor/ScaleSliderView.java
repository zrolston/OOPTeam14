package Views.MapEditor;

import Controllers.ScaleSliderController;
import Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

/**
 * Created by Willie on 3/28/2017.
 */
public class ScaleSliderView extends JSlider {

    public ScaleSliderView() {
        super(JSlider.VERTICAL, 5, 20, 10);
        setBounds(PixelMap.SCREEN_WIDTH *37/40, PixelMap.SCREEN_HEIGHT *5/20, PixelMap.SCREEN_WIDTH /20, PixelMap.SCREEN_HEIGHT *4/10);

        //Setup labels and display them
        setPaintTicks(true);
        setPaintLabels(true);
        setMinorTickSpacing(1);
        Hashtable labelTable = new Hashtable();
        labelTable.put(new Integer(5), new JLabel("0.5"));
        labelTable.put(new Integer(10), new JLabel("1.0"));
        labelTable.put(new Integer(15), new JLabel("1.5"));
        labelTable.put(new Integer(20), new JLabel("2.0"));
        setLabelTable(labelTable);

        //Add controller
        addChangeListener(new ScaleSliderController());

        setFocusable(false);
        setVisible(true);
    }
}
