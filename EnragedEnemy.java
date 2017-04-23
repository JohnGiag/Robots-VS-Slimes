import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
same as enemy actor but faster and different color
 */
public class EnragedEnemy extends Enemy
{   
  
        
    public EnragedEnemy(){
        active=true; 
        img1l=new GreenfootImage("enragedEnemyAnim/1.png");
        img2l=new GreenfootImage("enragedEnemyAnim/2.png");
        img1r=new GreenfootImage("enragedEnemyAnim/1right.png");
        img2r=new GreenfootImage("enragedEnemyAnim/2right.png");
        int x=40;
        int z=30;
        img1l.scale(x,z);
        img1r.scale(x,z);
        img2l.scale(x,z);
        img2r.scale(x,z);
        speed=7;
        health=2;
   }   
    /**
     * Act - do whatever the EnragedEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
      
}
