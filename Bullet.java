import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends SmoothMover
{
    
    private int dmg;
    private boolean active;
    private int dir;
    private int speed=12;
    private int life=30;
    
    public Bullet(int dmg,int dir){
        
        this.dmg=dmg;
        active=true;
        this.dir=dir;
       
    }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(dir*speed);
        applyDamage();
        if(active)
            remove();
        life--;
    }    
    
    //remove bullet when walls/platforms are hit or reached it's max range(life)
    public void remove(){
        Wall wall=(Wall)getOneIntersectingObject(Wall.class);
        Platform platform=(Platform)getOneIntersectingObject(Platform.class);
        if(wall!=null || platform!=null || life<0){
            getWorld().removeObject(this);
        }
        
        
    }
    
    
    //damage the enemy
    public void applyDamage(){
        Enemy enemy=(Enemy)getOneIntersectingObject(Enemy.class);
        if(enemy!=null){
             Greenfoot.playSound("sounds/hit.wav");
            enemy.takeDamage(dmg);   
            active=false;
            getWorld().removeObject(this);
            
        }
        
    }
    
    
}
