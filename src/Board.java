import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener {



Timer timer;
ArrayList<sprite> actors;
int numFood = 5,numEnemies = 2;
Game game;
long moment;
long nextMoment;
    public Board(Game game){

        setPreferredSize(new Dimension(600,800));
        setBackground(Color.black);


    }
    public void setup(){
         actors = new ArrayList<>();
        actors.add(new Player(Color.green, getWidth()/2, getHeight()/2, 20,20,this,game));
        for(int i = 0; i< numFood; i++){
            actors.add(new Food(Color.orange,(int)(Math.random()*550 + 25),(int)(Math.random()*getHeight()*750+25),20,20,this));
        }
        for(int i = 0; i< numEnemies; i++){
            actors.add(new Enemy(Color.orange,(int)(Math.random()*550 + 25),(int)(Math.random()*getHeight()*750+25),20,20,this));
        }
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
      for(sprite thisGuy: actors){
          thisGuy.paint(g);
      }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nextMoment = System.currentTimeMillis();
        
        if(!timer.isRunning() && game.getIsClicked()) {
            new Timer(100/60,this);
            timer.start();

        }

        for(sprite thisGuy: actors){
            thisGuy.move();
        }

        for(int i=1;i<actors.size();i++){
            if(actors.get(0).collidesWith(actors.get(i))){
               if(actors.get(i) instanceof Enemy) {
                   System.out.println("died it");
               }
               else
                   System.out.println("ate it");
               }
            }
        repaint();
        }
        
    }

