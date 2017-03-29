package Views.MapEditor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JSlider;

import Controllers.ScaleSliderController;
import Views.MapEditor.MapView.MapSubsectionView;
import Views.Utility.ImageLoader;
import Views.Utility.PixelMap;

/**
 * Created by Willie on 3/28/2017.
 */
public class ScaleSliderView extends JSlider {
	BufferedImage background;
	
    public ScaleSliderView(MapSubsectionView mapSubsectionView) {
        super(JSlider.VERTICAL, 3, 30, 10);
        setBounds((int)(PixelMap.SCREEN_WIDTH *37.5/40), (int)(PixelMap.SCREEN_HEIGHT * 11.4/20), PixelMap.SCREEN_WIDTH /20, PixelMap.SCREEN_HEIGHT *4/10);

        //Setup labels and display them
//        setPaintTicks(true);
        setPaintLabels(true);
        setMinorTickSpacing(1);
        setOpaque(false);
        Hashtable labelTable = new Hashtable();
        JLabel plus = new JLabel("+");
        plus.setForeground(Color.BLACK);
        plus.setFont(new Font("Serif", Font.BOLD, 30));
        JLabel minus = new JLabel("-");
        minus.setForeground(Color.BLACK);
        minus.setFont(new Font("Serif", Font.BOLD, 30));
        labelTable.put(new Integer(this.getMaximum()), plus);
        labelTable.put(new Integer(this.getMinimum()), minus);
        setLabelTable(labelTable);

        //Add controller
        addChangeListener(new ScaleSliderController(mapSubsectionView));

        this.fireStateChanged();

        setFocusable(false);
        setVisible(true);
        
        background = ImageLoader.getImage("SCROLL_BACKGROUND");
    }
    
    protected void paintComponent(Graphics g) {
    	g.drawImage(background, 0, 0, (int)(getWidth() * 1.145), (int)(getHeight()), null);
    	super.paintComponent(g);
    }
}
