import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 level select menu
 */
public class LevelSelect extends World
{

    /**
     * Constructor for objects of class LevelSelect.
     * 
     */
    public LevelSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 585, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Lvl1Txt lvl1txt = new Lvl1Txt();
        addObject(lvl1txt,439,284);
        Lvl2Txt lvl2txt = new Lvl2Txt();
        addObject(lvl2txt,439,451);

    
    }
}
