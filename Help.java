import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 controls menu
 */
public class Help extends World
{
    private MainMenu parent;
    private String level;
    /**
     * Constructor for objects of class Help.
     * 
     */
    public Help(MainMenu menu)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 585, 1); 
        parent=menu;
        level="menu";
    }
    
    
    public Help(String s){
        super(900, 585, 1); 
        level=s;
        
    }
    
    
    public void act(){
        if(Greenfoot.isKeyDown("enter")){
           if(level.equals("menu"))
            Greenfoot.setWorld(parent);
           else if(level.equals("1"))
            Greenfoot.setWorld(new Level1());
           else if(level.equals("2"))
            Greenfoot.setWorld(new Level2());
            
        }
    }
}
