package Gameplay.Views.MainView;

import Gameplay.Controller.PanelControllers.TransporterCarriableController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.TransporterAddToProducerController;
import Gameplay.Model.Goods.Goose;
import Gameplay.Model.Iterators.CarriableIterator;
import Gameplay.Model.TransporterFactory.DonkeyFactory;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.PlayerID;
import Gameplay.Model.Visitors.Carriable;
import Gameplay.Views.Drawers.CarriableDrawingVisitor;
import Gameplay.Views.Drawers.TransporterDrawingVisitor;
import Gameplay.Views.Utility.PolygonUtility;
import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelMap;
import MapBuilder.Views.Utility.PixelPoint;
import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;


public class TransporterCarriableView extends JPanel {

    private BufferedImage background;
    private ArrayList<Rectangle> buttons;
    private CarriableIterator iter;

    int numCols = 2;

    private int horizontalOffset, verticalOffset, buttonSide;

    public TransporterCarriableView() {
        setLayout(new BorderLayout());
        setBounds((int)(PixelMap.SCREEN_WIDTH * (1 - 34.0/40 - 1.0/7)), (int)(PixelMap.SCREEN_HEIGHT * .05), PixelMap.SCREEN_WIDTH /7, (int)(PixelMap.SCREEN_HEIGHT * (17.0/20 + 1.0/12 - .05)));
        setOpaque(false);
        setVisible( true );
        background = ImageLoader.getImage("SCROLL_BACKGROUND");

        TransporterCarriableController controller = new TransporterAddToProducerController();
        controller.attachView( this );
    }

    protected void paintComponent(Graphics g) {
    	((Graphics2D)(g)).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.drawImage(background, 0, 0, (int)(getWidth() * 1.145), (int)(getHeight()), null);
        super.paintComponent(g);
        drawButtons(g);
    }

    private void drawButtons(Graphics g){

        if(iter == null)
            return;

        int i = 0;
        while( i < iter.size() ) {

            Rectangle r = buttons.get(i);
            g.drawRoundRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight(), 5, 5);
            BufferedImage img = iter.getImage();

            if(++i % 2 != 0)
                g.drawImage(img, (int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight(), null);
            else
                g.drawImage(img, (int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight(), null);

        }
    }

    public ArrayList<Rectangle> getButtons() {
        return buttons;
    }

    public void setIter(CarriableIterator iter) {
        this.iter = iter;
        generateButtons();
        repaint();
    }

    public void generateButtons() {

        buttons = new ArrayList<>();
        int numElements = iter.size();

        int widthOffset = getWidth() / numCols;
        for (int i = 0; i < numCols; i++) {
            Polygon col = PolygonUtility.rectangleToPolygon(new Rectangle(i*widthOffset, 0, widthOffset, getHeight()));
        }

        //Calculate the offsets
        horizontalOffset = (int)(0.15*(getWidth()/numCols));
        buttonSide = (int)(0.75*(getWidth()/numCols));
        verticalOffset = horizontalOffset;

        //Initialize the left and right buttons
        buttons = new ArrayList<>();
        for(int i = 0; i <  numElements / numCols + 1; i++) {

            for (int j = 0; j < numCols; j++) {
                if( ( i * numCols + j)  >= numElements)
                    break;

                PixelPoint origin = new PixelPoint(horizontalOffset+getWidth()/numCols * j , horizontalOffset+((buttonSide+verticalOffset)*i));
                buttons.add(PolygonUtility.generateSquare(origin, buttonSide));
            }
        }

    }


}
