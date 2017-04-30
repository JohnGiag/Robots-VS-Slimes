import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 Enemy actor
 moves from one side to the other,switches direction when it hits a wall
 gets replaced with an EnragedEnemy actor if it fall in the fire
 damages the player on contact
 */
public class Enemy extends Character
{
    
   
    protected  boolean active;
    protected GreenfootImage img1l=new GreenfootImage("enemyAnim/1.png");
    protected GreenfootImage img2l=new GreenfootImage("enemyAnim/2.png");
    protected GreenfootImage img1r=new GreenfootImage("enemyAnim/1right.png");
    protected GreenfootImage img2r=new GreenfootImage("enemyAnim/2right.png");
    protected boolean wasInAir=true;
    
    
    private int fc=1;
    public  Enemy(){
        int x=40;
        int z=30;
        img1l.scale(x,z);
        img1r.scale(x,z);
        img2l.scale(x,z);
        img2r.scale(x,z);
        active=true;     
        speed=3;
        health=1;
        
        
        randomDirection();
        
        
    }
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        enemyMovement();
        checkFall();
        checkRightWalls();
        checkLeftWalls();
        inFire();
        if(active)
            die();
    }    
    
    //method to control enemy actor movement
    public void enemyMovement(){
        if(!jumping){
            if(wasInAir){
                randomDirection();
                wasInAir=false;
            }
            if(direction==1){
              
               animateRight();
               move(speed);
            }
            else{
              animateLeft();
              move(-speed);
            }
       }
       else{//move slower when falling
           wasInAir=true;
            if(direction==1){
              
               animateRight();
               move(4);
            }
            else{
              animateLeft();
              move(-4);
            }
        }
    }
    
    
    public boolean checkRightWalls(){
        int pWidth=getImage().getWidth();
        int xDistance=(int)(pWidth/2);
        Wall wall=(Wall) getOneObjectAtOffset(xDistance,0,Wall.class);
       if(wall != null){
           
           stopRightWall(wall);
           direction= -direction;
           return true;
        }
       else{
           
          
           return false;
            
        }
        
    }
    public boolean checkLeftWalls(){
        int pWidth=getImage().getWidth();
        int xDistance=(int)(pWidth/-2);
        Wall wall=(Wall) getOneObjectAtOffset(xDistance,0,Wall.class);
       if(wall != null){
           
           stopLeftWall(wall);
           direction= -direction;
           return true;
        }
       else{
           
          
           return false;
            
        }
        
    }
    //animation methods
    private void animateLeft(){
        if(fc<6){
            setImage(img1l);
        }
        else
            setImage(img2l);
        fc++;
        if(fc>12)
            fc=0;
        
    }
    private void animateRight(){
        if(fc<6){
            setImage(img1r);
        }
        else
            setImage(img2r);
        fc++;
        if(fc>12)
            fc=0;
        
    }
    
    //check collision with fire
    public void inFire(){
        Actor fire= getOneIntersectingObject(FireColisionBox.class);
        if(fire!=null){
            Greenfoot.playSound("sounds/hitFire.wav");
            World world=getWorld();
            world.getObjects(EnemySpawnPoint.class).get(0).spawnEnragedEnemy();
            active=false;
            world.removeObject(this);
            
           
            
        }
        
    }
    
    
    //chose randomly a direction to move 
    public void randomDirection(){
        if(Greenfoot.getRandomNumber(2)==0)
            direction=1;
         else
            direction=-1;
            
        
    }
    //method to call when hit
     public void takeDamage(int dmg){
        
        health-=dmg;
        
    }
    //method to check if the enemy is dead
    public void die(){
        if(health<=0){
           getWorld().removeObject(this); 
        }
        
    }
    
    public void setActive(boolean b){
        active=b;
    
    }
}
