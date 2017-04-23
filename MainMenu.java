import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 main menu
 */
public class MainMenu extends World
{
    private static GreenfootSound sound;
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.        
        super(900, 585, 1);         
        sound = new GreenfootSound("sounds/menuTheme.mp3");
      
        sound.playLoop();
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
       
        PlayTxt playtxt = new PlayTxt();
        addObject(playtxt,452,296);
        HelpTxt helptxt = new HelpTxt();
        addObject(helptxt,452,441);
        
       
    }
    
    
    public static void stopMusic(){
        sound.stop();
        
    }
    
    public static void pauseMusic(){
        sound.pause();
        
    }
}
