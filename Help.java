import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 controls menu
 */
public class Help extends World
{
    private MainMenu parent;
    /**
     * Constructor for objects of class Help.
     * 
     */
    public Help(MainMenu menu)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 585, 1); 
        parent=menu;
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("escape")){
           
            
            Greenfoot.setWorld(parent);
            
        }
    }
}
