package Views.MapEditor;

import Controllers.ScaleSliderController;
import Views.MapEditor.MapView.MapSubsectionView;
import Views.Utility.ImageLoader;
import Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

/**
 * Created by Willie on 3/28/2017.
 */
public class ScaleSliderView extends JSlider {
	BufferedImage background;
	
    public ScaleSliderView(MapSubsectionView mapSubsectionView) {
        super(JSlider.VERTICAL, 3, 50, 15);
        setBounds(PixelMap.SCREEN_WIDTH *37/40, PixelMap.SCREEN_HEIGHT *5/20, PixelMap.SCREEN_WIDTH /20, PixelMap.SCREEN_HEIGHT *4/10);

        //Setup labels and display them
//        setPaintTicks(true);
        setPaintLabels(true);
        setMinorTickSpacing(1);
        setOpaque(false);
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
        
        background = ImageLoader.getImage("SCROLL_BACKGROUND");
    }
    
    protected void paintComponent(Graphics g) {
    	g.drawImage(background, 0, 0, (int)(getWidth() * 1.145), (int)(getHeight()), null);
    	super.paintComponent(g);
    	//int recWidth = (int)(getWidth() * 0.97);
    	//int recHeight = (int)(getHeight() * 0.71);
    	//g.drawRect(0, 0, recWidth, (int)(getHeight() * 0.99));
    	//g.drawLine(recWidth/2, 0, recWidth/2, recHeight);
    	//g.drawLine(0, recHeight, recWidth, recHeight);
    }
}
