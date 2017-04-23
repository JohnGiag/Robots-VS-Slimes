import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 Object from which enemies spawn
 */
public class EnemySpawnPoint extends Actor
{
    
    private World w;
    private int MAX_ENEMIES,lastScore;
    private static int currentScore;
    
    public EnemySpawnPoint(){
       MAX_ENEMIES=3;
       lastScore=0;
       currentScore=0;
       getImage().setTransparency(0);
       
    }
    /**
     * Act - do whatever the EnemySpawnPoint wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        w=getWorld();
        controlDifficulty();        
        //spawn enemy if under thresshold with 2% probability
        if(w.getObjects(Enemy.class).size()<MAX_ENEMIES){
            double r=Math.random();
            if(r<0.02){
               
                w.addObject(new Enemy(),getX(),getY());
            }
        }
            
    } 
    
    //method to spawn enraged enemy
    public  void spawnEnragedEnemy()
    {
        EnemySpawnPoint sp=this;
        if(w.getObjects(EnemySpawnPoint.class).size() > 1){
            int i=Greenfoot.getRandomNumber(w.getObjects(EnemySpawnPoint.class).size());
            sp=w.getObjects(EnemySpawnPoint.class).get(i);
        }
        w.addObject(new EnragedEnemy(),sp.getX(),sp.getY());
    }
    
    
    //method to up the difficulty during runtime
    //based on the players score
    public void controlDifficulty(){
        if(currentScore>(lastScore+5)){
            MAX_ENEMIES+=2;
            lastScore=currentScore;
            
        }
        
    }
    
    public static void setCurrentScore(int x){
        currentScore=x;
    }
}
