import java.util.ArrayList;
import java.awt.Rectangle;


public class Snake{
    private ArrayList<Rectangle> body;
    private int dimension = Game.dimension;
    private String move;
    

    public Snake (){

        body = new ArrayList <>();


        Rectangle temp= new Rectangle( Game.dimension , Game.dimension);
        temp.setLocation(Game.width * dimension /2, Game.height * dimension/ 2);
        body.add(temp);

        temp = new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation( (Game.width / 2 - 1) * dimension , Game.height * dimension /2);
        body.add(temp);


        temp = new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation( (Game.width  / 2 - 2) * dimension , Game.height * dimension / 2);
        body.add(temp);
        


        move = "NOTHING";

    }

    public void move(){
        if (move != "NOTHING"){
            Rectangle temp = new Rectangle(Game.dimension, Game.dimension);

            if (move == "UP"){
                temp.setLocation(body.get(0).x  ,  body.get(0).y - Game.dimension);
            }
            if (move == "DOWN"){
                temp.setLocation(body.get(0).x , body.get(0).y + Game.dimension);
            }
            if (move == "LEFT"){
                temp.setLocation(body.get(0).x  - Game.dimension, body.get(0).y );
            }
            if (move == "RIGHT"){
                temp.setLocation(body.get(0).x + Game.dimension , body.get(0).y);
            }

            body.add(0, temp );
            body.remove( body.size() - 1 );
        }

    }

    public void grow(){
        
        Rectangle temp = new Rectangle(Game.dimension, Game.dimension);

        if(move == "UP"){
            temp.setLocation(body.get(0).x , body.get(0).y - Game.dimension);
        }
        if (move == "DOWN"){
            temp.setLocation(body.get(0).x , body.get(0).y + Game.dimension);
        }
        if(move == "LEFT"){
            temp.setLocation( body.get(0).x - Game.dimension, body.get(0).y);
        }
        if(move == "RIGHT"){
            temp.setLocation(body.get(0).x + Game.dimension, body.get(0).y);
        }

        body.add(0, temp);



    }









    public void up(){
        move = "UP";
    }
    public void down(){
        move = "DOWN";
    }
    public void left(){
        move = "LEFT";
    }
    public void right(){
        move = "RIGHT";
    }



    //getter & setter
    public ArrayList <Rectangle> getBody(){
        return body;
    }

    public String getMove(){
        return move;
    }





}