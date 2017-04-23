import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lvl1Txt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lvl1Txt extends TextButton
{
    /**
     * Act - do whatever the Lvl1Txt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
         if(Greenfoot.mouseClicked(this)){
            
             
            MainMenu.stopMusic();
            Greenfoot.setWorld(new Level1());
        }
    }    
}
