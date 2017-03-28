package Views.MapEditor;

import Controllers.ScaleSliderController;
import Views.MapEditor.MapView.MapSubsectionView;
import Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

/**
 * Created by Willie on 3/28/2017.
 */
public class ScaleSliderView extends JSlider {

    public ScaleSliderView(MapSubsectionView mapSubsectionView) {
        super(JSlider.VERTICAL, 3, 50, 15);
        setBounds(PixelMap.SCREEN_WIDTH *37/40, PixelMap.SCREEN_HEIGHT *5/20, PixelMap.SCREEN_WIDTH /20, PixelMap.SCREEN_HEIGHT *4/10);

        //Setup labels and display them
//        setPaintTicks(true);
        setPaintLabels(true);
        setMinorTickSpacing(1);
        Hashtable labelTable = new Hashtable();
        JLabel plus = new JLabel("+");
        plus.setForeground(new Color(0xffCABD80));
        plus.setFont(new Font("Serif", Font.BOLD, 30));
        JLabel minus = new JLabel("-");
        minus.setForeground(new Color(0xffCABD80));
        minus.setFont(new Font("Serif", Font.BOLD, 30));
        labelTable.put(new Integer(this.getMaximum()), plus);
        labelTable.put(new Integer(this.getMinimum()), minus);
        setLabelTable(labelTable);

        //Add controller
        addChangeListener(new ScaleSliderController(mapSubsectionView));

        setFocusable(false);
        setVisible(true);
    }
}
