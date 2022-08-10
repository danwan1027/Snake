import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Rectangle;

import javax.swing.JFrame;


public class Game implements KeyListener{
    private Snake player;
    private Food food;
    private Graphic graphic;
    private JFrame window;
    

    public static final int width = 30;
    public static final int height = 30;
    public static final int dimension = 20;

    public Game(){
        player = new Snake();
        food = new Food(player); 
        graphic = new Graphic(this);
        window = new JFrame();

        window.add(graphic);
        window.setTitle("Snake Game");
        window.setSize(width * dimension + 2, height * dimension + dimension + 4);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }

    public void start(){
        graphic.state = "RUNNING";
    }

    public void update(){

        if (graphic.state == "RUNNING"){
            if (check_food_collision() == true){
                player.grow();
                food.random_spawn();
            }
            else if (check_wall_collision() == true 
                || check_self_collision() == true){
                    graphic.state = "END";
            }
            else {
                player.move();
            }
        }
    }

    private boolean check_wall_collision(){

        if (player.getBody().get(0).x < 0 
                || player.getBody().get(0).x > width * dimension
                || player.getBody().get(0).y < 0 
                || player.getBody().get(0).y > height * dimension){
            return true;
        }
        else{
            return false;
        }
        
    }

    private boolean check_food_collision(){
        if (player.getBody().get(0).x == food.getX() * Game.dimension
                && player.getBody().get(0).y == food.getY() * Game.dimension){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean check_self_collision(){
        for (int i = 1 ; i < player.getBody().size() ; i++){

            if ( player.getBody().get(0).x == player.getBody().get(i).x 
                    && player.getBody().get(0).y == player.getBody().get(i).y){
                return true;
            }
        }
        return false;
    }



    @Override
    public void keyPressed(KeyEvent e) {

        int input  = e.getKeyCode();
        if (graphic.state == "RUNNING"){
            if (input == KeyEvent.VK_W && player.getMove() != "DOWN"){
                player.up();
            }
            else if (input == KeyEvent.VK_S && player.getMove() != "UP"){
                player.down();
            }
            else if (input == KeyEvent.VK_A && player.getMove() != "RIGHT"){
                player.left();
            }
            else if (input == KeyEvent.VK_D && player.getMove() != "LEFT"){
                player.right();
            }
            
        }
        // else if (graphic.state == "END"){
        //     if (input == KeyEvent.VK_SPACE){
        //         graphic.state == "";
        //     }
        // }
        else {
            graphic.state = "RUNNING";
        }
        

        
    }

    public Food getFood(){
        return food;
    }


    //getter & setter
    public Snake getPlayer(){
        return player;
    }



    //no used
    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    

}