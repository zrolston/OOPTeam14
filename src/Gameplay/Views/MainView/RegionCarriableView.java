package Gameplay.Views.MainView;

import Gameplay.Model.Producer.Producer;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.LandTransporterProducers.WagonProducer;
import Gameplay.Model.Region.LandRegion;
import Gameplay.Model.Visitors.Carriable;
import Gameplay.Views.Drawers.ProducerDrawingVisitor;
import Gameplay.Views.Utility.PolygonUtility;
import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelMap;
import MapBuilder.Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;


public class RegionCarriableView extends JPanel {

    private ArrayList<Polygon> columns;
    private java.util.List<Rectangle> buttons;
    private java.util.List<Carriable> leftCarriables;
    private java.util.List<Carriable> rightCarriables;

    private int horizontalOffset, verticalOffset, buttonSide;
    private BufferedImage background;

    ArrayList<BufferedImage> images;

    public RegionCarriableView() {

        images = new ArrayList<>();

        // GET BELOW IMAGES FROM CONTROLLER OR ITERATOR
        Producer p = new WagonProducer(new LandRegion());
        ProducerDrawingVisitor gv = new ProducerDrawingVisitor();
        p.accept(gv);
        images.add( gv.getImage() );
        /////////////////////////////////////////////////////

        setLayout(new BorderLayout());
        setBounds((int)(PixelMap.SCREEN_WIDTH *34.0/40), (int)(PixelMap.SCREEN_HEIGHT * .17), PixelMap.SCREEN_WIDTH /7, (int)(PixelMap.SCREEN_HEIGHT * (0.45)));
        setOpaque(false);
        setVisible( true );
        background = ImageLoader.getImage("RESEARCH_BACKGROUND");

        int numElements = 37;
        int numCols = 5;

        columns = new ArrayList<>();
        int widthOffset = getWidth() / numCols;
        for (int i = 0; i < numCols; i++) {
            Polygon col = PolygonUtility.rectangleToPolygon(new Rectangle(i*widthOffset, 0, widthOffset, getHeight()));
            columns.add( col );
        }

        //Calculate the offsets
        horizontalOffset = (int)(0.15*(getWidth()/numCols));
        buttonSide = (int)(0.75*(getWidth()/numCols));
//        verticalOffset = ((getHeight()-horizontalOffset-5-numRows*buttonSide)/numRows);
        verticalOffset = horizontalOffset;

        //Initialize the left and right buttons
        buttons = new ArrayList<>();
        for(int i = 0; i <  numElements / numCols + 1; i++) {

            for (int j = 0; j < numCols; j++) {
                if( ( i * numCols + j)  >= numElements)
                    break;
                PixelPoint origin = new PixelPoint(horizontalOffset+getWidth()/numCols * j, horizontalOffset+((buttonSide+verticalOffset)*i));
                buttons.add(PolygonUtility.generateSquare(origin, buttonSide));
            }

        }


        //Test Action Listener
        addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                PixelPoint point = new PixelPoint(e.getX(), e.getY());
                int index = getCarriableIndex(point);
                System.out.println(index);
            }

            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        this.setBorder(BorderFactory.createLineBorder(new Color(0x11111111), 1));
    }

    //Set the different Carriables Dynamically
    public void setLeftCarriables(java.util.List<Carriable> leftCarriables) { this.leftCarriables = leftCarriables; }
    public void setRightCarriables(java.util.List<Carriable> rightCarriables) { this.rightCarriables = rightCarriables; }

    protected void paintComponent(Graphics g) {
    	((Graphics2D)(g)).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.drawImage(background, 0, 0, (int)(getWidth() * 1.145), (int)(getHeight()), null);
        super.paintComponent(g);
        drawButtons(g);
    }

    private void drawColumns(Graphics g){
        for (Polygon p :
                columns) {
            g.drawPolygon( p );
        }
    }

    private void drawButtons(Graphics g){
        for(Rectangle r: buttons){
            g.drawRoundRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight(), 5, 5);
            g.drawImage(images.get(0), (int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight(), null);
        }
    }

    public Integer getCarriableIndex(PixelPoint point){
        int index = 0;
        for(Rectangle button: buttons){
            //Checking right button list
            if(button.contains(point.getX(), point.getY()))
                return index;
            index++;
        }
        return -1;
    }
}
