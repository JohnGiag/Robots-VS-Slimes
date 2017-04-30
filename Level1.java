import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    private Counter counter,health;
    private Player player;
    private static GreenfootSound sound;
    private static GreenfootSound fireSound;

    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 585, 1); 
        MainMenu.stopMusic();
        sound = new GreenfootSound("sounds/fightTheme.mp3");
        sound.playLoop();
        fireSound = new GreenfootSound("sounds/fire.wav");
        fireSound.playLoop();
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        ArrayList<Point> points=new ArrayList<Point>();
        points.add(new Point(180,520));
        points.add(new Point(740,520));
        points.add(new Point(430,386));
        points.add(new Point(120,255));
        points.add(new Point(298,255));
        points.add(new Point(617,255));
        points.add(new Point(800,255));
        points.add(new Point(455,115));

        CoinSpawner cs=new CoinSpawner(points);
        addObject(cs,50,50);
        EnemySpawnPoint enemyspawnpoint = new EnemySpawnPoint();
        addObject(enemyspawnpoint,431,13);

        player = new Player();        
        addObject(player,182,400);
        addObject(player.getBubble(),0,0);
        FireColisionBox firecolisionbox = new FireColisionBox();
        addObject(firecolisionbox,698,888);

        counter = new Counter("Score :  ");
        addObject(counter,162,568);

        health = new Counter("Health :  ");
        addObject(health,1187,881);
        health.setLocation(729,568);
        firecolisionbox.setLocation(622,483);
        removeObject(firecolisionbox);
        Wall wall = new Wall();
        addObject(wall,27,290);
        wall.setLocation(23,291);
        Wall wall2 = new Wall();
        addObject(wall2,883,296);
        wall2.setLocation(877,295);
        Platform platform = new Platform();
        addObject(platform,209,296);
        platform.setLocation(204,291);
        platform.setLocation(203,291);
        Platform platform2 = new Platform();
        addObject(platform2,703,297);
        platform2.setLocation(695,291);
        Platform platform3 = new Platform();
        addObject(platform3,443,426);
        platform3.setLocation(429,427);
        platform3.setLocation(428,427);
        Platform platform4 = new Platform();
        addObject(platform4,474,157);
        platform4.setLocation(471,157);
        platform4.getImage().scale(270,45);
        platform4.setLocation(450,156);
        Platform platform5 = new Platform();
        addObject(platform5,206,568);
        platform5.setLocation(202,562);
        Platform platform6 = new Platform();
        addObject(platform6,703,569);
        platform6.setLocation(698,562);
        Platform platform7 = new Platform();
        addObject(platform7,206,7);
        platform7.setLocation(203,2);
        Platform platform8 = new Platform();
        addObject(platform8,662,2);
        platform8.setLocation(662,2);
        platform8.setLocation(662,2);
        platform8.setLocation(662,2);
        platform8.setLocation(662,2);
        platform8.setLocation(662,2);
        platform8.setLocation(662,2);
        platform8.setLocation(662,2);
        platform8.setLocation(662,2);
        platform8.setLocation(653,0);
        Platform platform9 = new Platform();
        addObject(platform9,825,2);
        platform9.setLocation(820,0);
        FireColisionBox firecolisionbox2 = new FireColisionBox();
        addObject(firecolisionbox2,442,537);
        firecolisionbox2.getImage().scale(170,60);
        firecolisionbox2.setLocation(451,555);
        Fire fire = new Fire();
        addObject(fire,419,531);
        fire.setLocation(391,545);
        Fire fire2 = new Fire();
        addObject(fire2,449,565);
        fire2.setLocation(442,548);
        fire2.setLocation(432,557);
        fire2.setLocation(434,562);
        fire.setLocation(386,556);
        Fire fire3 = new Fire();
        addObject(fire3,485,571);
        fire3.setLocation(484,568);
        Fire fire4 = new Fire();
        addObject(fire4,509,571);
        fire4.setLocation(502,559);
        fire4.setLocation(504,557);
        fire3.setLocation(473,567);
        platform.setLocation(203,296);
        platform3.setLocation(427,431);
        platform5.setLocation(202,566);
        platform6.setLocation(698,567);
        platform2.setLocation(696,296);
        platform4.setLocation(451,161);

        Wall wall3 = new Wall(55);
        addObject(wall3,340,301);
        wall3.setLocation(333,298);
        Wall wall4 = new Wall(55);
        addObject(wall4,557,305);
        wall4.setLocation(563,298);
        Wall wall5 = new Wall(55);
        addObject(wall5,317,439);
        wall5.setLocation(298,432);
        Wall wall6 = new Wall(55);
        addObject(wall6,575,440);
        wall6.setLocation(556,432);
        Wall wall7 = new Wall(55);
        addObject(wall7,342,126);
        wall7.setLocation(338,162);
        Wall wall8 = new Wall(55);
        addObject(wall8,557,188);
        wall8.setLocation(558,156);
        wall8.setLocation(560,165);
        wall7.setLocation(339,165);
        wall3.setLocation(333,299);
        wall4.setLocation(562,300);
        wall6.setLocation(566,438);
        wall6.setLocation(560,437);
        wall5.setLocation(290,439);
    }
    
    public void act(){
        int score=player.getScore();
        EnemySpawnPoint.setCurrentScore(score);
        counter.setValue(score);//update score
        health.setValue(player.getHealth());//update health
        if(Greenfoot.isKeyDown("r")){
            fireSound.stop();
            stopMusic();
            Greenfoot.setWorld(new Level1());
        }
        if(Greenfoot.isKeyDown("escape")){
           fireSound.stop();
            stopMusic();
            Greenfoot.setWorld(new MainMenu());
        }
    }
    
    
     public static void stopMusic(){
        sound.stop();
        
    }
}
