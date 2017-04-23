import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends SmoothMover

    
{
    
    protected int vSpeed=0;
    protected int vAcc=2;
    protected boolean jumping;
    protected int jmpStrength=22;
    protected int speed=6;
    protected int direction=1;
    protected int health;
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    
    
    //method to apply gravity to characters
    public void  fall(){
        
        
        setLocation(getX(),getY()+vSpeed);
        if(vSpeed<9)
            vSpeed+=vAcc;
        
        jumping=true;
        
        
    }
    
    
    //method to check if character is on ground by checking collision with actor Platform
    public boolean onGround(){
        
       int sprHeight=getImage().getHeight();
       int lookForGround = (int)(sprHeight/2 + 5);
       
       Platform platform=(Platform) getOneObjectAtOffset(0,lookForGround,Platform.class);
       if(platform != null){
           moveToGround(platform);
            return true;
        }
       else{
           
           jumping=true;
           return false;
            
        }
            
    }
    
    
    //method to correct characters possition after fall.
    public void moveToGround(Platform p){
        int pHeight=p.getImage().getHeight();
        int newY=p.getY()-(pHeight +getImage().getHeight() - 5)/2;
        setLocation(getX(),newY);
        jumping=false;
        
    }
    
    public void checkFall(){
     if(!onGround())
        fall();
    else
        vSpeed=0;
                
    }
    
    //method to check collision with walls
     public boolean checkRightWalls(){
        int pWidth=getImage().getWidth();
        int xDistance=(int)(pWidth/2);
        Wall wall=(Wall) getOneObjectAtOffset(xDistance,0,Wall.class);
       if(wall != null){
           
           stopRightWall(wall);
           return true;
        }
       else{
           
          
           return false;
            
        }
        
    }
    //method to check collision with walls
    public boolean checkLeftWalls(){
        int pWidth=getImage().getWidth();
        int xDistance=(int)(pWidth/-2);
        Wall wall=(Wall) getOneObjectAtOffset(xDistance,0,Wall.class);
       if(wall != null){
           
           stopLeftWall(wall);
           return true;
        }
       else{
           
          
           return false;
            
        }
        
    }
    //method to correct characters possition after collision with wall
    public void stopRightWall(Wall w){
        int wWidth=w.getImage().getWidth();
        int newX=w.getX()-(wWidth +getImage().getWidth())/2;
        setLocation(newX,getY());
        
        
    }
    //method to correct characters possition after collision with wall
     public void stopLeftWall(Wall w){
        int wWidth=w.getImage().getWidth();
        int newX=w.getX()+(wWidth +getImage().getWidth())/2;
        setLocation(newX,getY());
        
        
    }
    
    
   
}
