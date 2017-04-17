package Gameplay.Views.MainView;

import Gameplay.Controller.PanelControllers.TransporterCarriableController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.MoveController;
import Gameplay.Model.Iterators.CarriableIterator;
import Gameplay.Model.Iterators.TransporterIterator;
import Gameplay.Views.Utility.PolygonUtility;
import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelMap;
import MapBuilder.Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;


public class TransporterCarriableView extends JPanel {

    private BufferedImage background;
    private ArrayList<Rectangle> buttons = new ArrayList<>();
    private CarriableIterator carrIter;
    private TransporterIterator tranIter;

    int numCols = 2;

    private int horizontalOffset, verticalOffset, buttonSide;

    public TransporterCarriableView() {

        setLayout(new BorderLayout());
        setBounds((int) (PixelMap.SCREEN_WIDTH * (1 - 34.0 / 40 - 1.0 / 7)), (int) (PixelMap.SCREEN_HEIGHT * .05), PixelMap.SCREEN_WIDTH / 7, (int) (PixelMap.SCREEN_HEIGHT * (17.0 / 20 + 1.0 / 12 - .05)));
        setOpaque(false);
        setVisible(true);
        background = ImageLoader.getImage("SCROLL_BACKGROUND");

//        TransporterCarriableController controller = new MoveController();
//        controller.attachView(this);
    }



    protected void paintComponent(Graphics g) {
        ((Graphics2D) (g)).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.drawImage(background, 0, 0, (int) (getWidth() * 1.145), (int) (getHeight()), null);
        super.paintComponent(g);
        drawButtons(g);
    }

    private void drawButtons(Graphics g) {

        if(tranIter == null)
            return;

        tranIter.first();
        int i = 0;
        while (i < tranIter.size()) {

            Rectangle r = buttons.get(i);
            g.drawRoundRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight(), 5, 5);

            g.drawImage(tranIter.getImage(), (int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight(), null);

            tranIter.next();
            i++;
        }

        if(carrIter == null)
            return;

        System.out.println("carr iter size: " + tranIter.size());


        carrIter.first();
        i = 0;
        while (++i < carrIter.size()) {

            Rectangle r = buttons.get(i);
            g.drawRoundRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight(), 5, 5);

                g.drawImage(carrIter.getImage(), (int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight(), null);

            carrIter.next();
        }
    }

    public ArrayList<Rectangle> getButtons() {
        generateButtons();
        return buttons;
    }

    public void setCarrIter(CarriableIterator carrIter) {
        this.carrIter = carrIter;
        generateButtons();
        repaint();
    }

    public void setTranIter(TransporterIterator tranIter){
        this.tranIter = tranIter;
        generateButtons();
        repaint();
    }

    public Integer getCarriableIndex(PixelPoint point) {



        int index = 0;
        for (Rectangle button : buttons) {
            //Checking right button list
            if (button.contains(point.getX(), point.getY()))
                return index;
            index++;
        }
        return -1;
    }

    //Set the different Carriables Dynamically
    public void setLeftCarriables(TransporterIterator transporters) {
        this.tranIter = transporters;
    }

    public void setRightCarriables(CarriableIterator carriables) {
        this.carrIter = carriables;
    }

    public void generateButtons() {

        if (tranIter == null)
            return;

        buttons.clear();
        int numElements = tranIter.size();

        System.out.println("buttons made: " + numElements);

        int widthOffset = getWidth() / numCols;
        for (int i = 0; i < numCols; i++) {
            Polygon col = PolygonUtility.rectangleToPolygon(new Rectangle(i * widthOffset, 0, widthOffset, getHeight()));
        }

        //Calculate the offsets
        horizontalOffset = (int) (0.15 * (getWidth() / numCols));
        buttonSide = (int) (0.75 * (getWidth() / numCols));
        verticalOffset = horizontalOffset;

        //Initialize the left and right buttons
        buttons = new ArrayList<>();
        for (int i = 0; i < numElements / numCols + 1; i++) {

            for (int j = 0; j < numCols; j++) {
                if ((i * numCols + j) >= numElements)
                    break;

                PixelPoint origin = new PixelPoint(horizontalOffset + getWidth() / numCols * j, horizontalOffset + ((buttonSide + verticalOffset) * i));
                buttons.add(PolygonUtility.generateSquare(origin, buttonSide));
            }
        }

    }


}
