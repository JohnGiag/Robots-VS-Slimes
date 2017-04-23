import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpTxt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpTxt extends TextButton
{
    /**
     * Act - do whatever the HelpTxt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
         if(Greenfoot.mouseClicked(this)){
            MainMenu w=(MainMenu)getWorld();
            Greenfoot.setWorld(new Help(w));
            
        }
    }    
}
