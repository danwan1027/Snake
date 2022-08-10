// import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// import javax.swing.JPanel;
// import javax.swing.Timer;


public class Graphic 
extends JPanel 
implements ActionListener{
    private Timer timer = new Timer(100, this);
    public String state;

    private Food food ;
    private Snake player;
    private Game game;
    

    public Graphic (Game game){
        timer.start();
        state = "START";
        food = game.getFood();
        player = game.getPlayer();
        this.game = game;

        //addKeylistener
        this.addKeyListener(game);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        
    }

    public void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0 , Game.width * Game.dimension, Game.height * Game.dimension);
        
        if (state == "START"){
            
            g2d.setColor(Color.white);
            g2d.drawString("Press Any Key to Start", 
                (Game.width / 2 )* Game.dimension - 20, Game.height / 2 * Game.dimension);
        }
        else if (state == "RUNNING"){
            
            g2d.setColor(Color.red);
            g2d.fillRect( food.getX() * Game.dimension, food.getY() * Game.dimension , Game.dimension, Game.dimension);

            g2d.setColor(Color.green);
            for (Rectangle r : player.getBody() ){
             g2d.fillRect(r.x , r.y , Game.dimension , Game.dimension);//  g2d.fill(r);
            }
        }
        else{
            
            g2d.setColor(Color.white);
            g2d.drawString("Your Score: " + (player.getBody().size() - 3 ) , 
                             Game.width /2 * Game.dimension , Game.height / 2 * Game.dimension );
        }
    }
    
 

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();//basically calling paintComponent
        game.update();
    }
    




}
