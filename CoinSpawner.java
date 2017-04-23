import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 actor that controls the coin spawn points
 */
public class CoinSpawner extends Actor
{
    private World w;
    private ArrayList<Point> spawnPoints;
    
    public CoinSpawner(ArrayList<Point> points){
        getImage().setTransparency(0);
        spawnPoints=new ArrayList<Point>();
        spawnPoints=points;
        
    }
    /**
     spawn a coin if one doesn't exist on the map
     */
    public void act() 
    {
        // Add your action code here.
        w=getWorld();
        if(w.getObjects(Coin.class).size()==0){
            double r=Math.random();
            if(r<0.1){
               Point p=randomPoint();
               w.addObject(new Coin(),p.getX(),p.getY());
            }
        }
    }   
    
    //method to chose a random point to spawn a coin
    public Point randomPoint(){
        
        int n= Greenfoot.getRandomNumber(spawnPoints.size());
        return spawnPoints.get(n);
    }
}
