import java.awt.Rectangle;
public class Food {
    private int x;
    private int y;
    private Snake player;

    public Food(Snake player){
        this.player = player;
    }


    public void random_spawn(){
            boolean onSnake = false;

            do{
                x = (int)(Math.random() * Game.width);
                y = (int)(Math.random() * Game.height);

                for ( Rectangle r  : player.getBody()){
                    if (r.x == x && r.y == y){
                        onSnake = true;
                        break;
                    }
                }
            }while(onSnake == true);


    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

}
