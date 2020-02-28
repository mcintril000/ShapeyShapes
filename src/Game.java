import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

public class Game extends JFrame {

    Board board;
  Game game;
  int positionX,positionY;
  boolean mouseClicked = false;
    public Game(){
        setTitle("shapes");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        board= new Board();
        board.setup();
        add(board);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursor(getToolkit().createCustomCursor(new BufferedImage(3,3,2), new Point(0,0),null));
            }
        });

addMouseListener(new MouseAdapter() {
    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        positionX = e.getX();
        positionY= e.getY();
    }
});

addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        mouseClicked = true;
        moment = System.currentTimeMillis();
    }
});

        pack();

        setLocationRelativeTo(null);
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public boolean getIsClicked(){return mouseClicked;}
    public boolean setIsClicked(){ mouseClicked = false;}

    public static void main(String[] args){
        Game game = new Game();

    }

}

