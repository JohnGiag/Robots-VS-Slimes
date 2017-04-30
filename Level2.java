import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    private Counter counter,health;
    private Player player;
    private static GreenfootSound sound;
     private static GreenfootSound fireSound;

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
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

        points.add(new Point(220,510));
        points.add(new Point(720,510));
        points.add(new Point(220,375));
        points.add(new Point(720,375));
        points.add(new Point(355,250));
        points.add(new Point(455,250));
        points.add(new Point(595,250));
        points.add(new Point(80,100));
        points.add(new Point(820,100));

        CoinSpawner cs=new CoinSpawner(points);
        addObject(cs,50,50);

        EnemySpawnPoint enemyspawnpoint = new EnemySpawnPoint();
        addObject(enemyspawnpoint,259,31);
        EnemySpawnPoint enemyspawnpoint2 = new EnemySpawnPoint();
        addObject(enemyspawnpoint2,1157,24);
        player = new Player();
        addObject(player,90,445);
        addObject(player.getBubble(),0,0);

        counter = new Counter("Score :  ");
        addObject(counter,162,568);

        health = new Counter("Health :  ");
        addObject(health,1187,881);
        health.setLocation(729,568);

        FireColisionBox firecolisionbox = new FireColisionBox();
        addObject(firecolisionbox,596,859);
        firecolisionbox.getImage().scale(45,45);
        FireColisionBox firecolisionbox2 = new FireColisionBox();
        addObject(firecolisionbox2,806,859);
        firecolisionbox2.getImage().scale(45, 45);    
        firecolisionbox.setLocation(382,558);
        firecolisionbox2.setLocation(518,558);
        enemyspawnpoint.setLocation(175,10);
        enemyspawnpoint2.setLocation(753,5);
        enemyspawnpoint2.setLocation(754,7);
        Wall wall = new Wall();
        addObject(wall,25,301);
        wall.setLocation(23,289);
        Wall wall2 = new Wall();
        addObject(wall2,882,308);
        wall2.setLocation(877,293);
        Platform platform = new Platform();
        addObject(platform,160,162);
        platform.setLocation(158,155);
        Platform platform2 = new Platform();
        addObject(platform2,802,163);
        platform2.setLocation(738,157);
        platform2.setLocation(738,157);
        Platform platform3 = new Platform();
        addObject(platform3,425,298);

        Platform platform4 = new Platform();
        addObject(platform4,531,294);

        platform3.setLocation(421,294);
        platform4.setLocation(478,294);

        platform2.setLocation(739,161);
        platform.setLocation(162,161);
        Platform platform5 = new Platform();
        addObject(platform5,319,3);
        platform5.setLocation(379,1);
        Platform platform6 = new Platform();
        addObject(platform6,534,19);
        platform6.setLocation(519,0);
        Platform platform7 = new Platform();
        addObject(platform7,235,434);
        platform7.getImage().scale(140,45);
        Platform platform8 = new Platform();
        addObject(platform8,687,423);
        platform8.getImage().scale(140,45);
        platform7.setLocation(202,432);
        platform8.setLocation(697,431);
        Platform platform9 = new Platform();
        addObject(platform9,724,565);
        platform9.setLocation(700,565);
        Platform platform10 = new Platform();
        addObject(platform10,206,573);
        platform10.setLocation(201,565);
        platform7.setLocation(207,431);
        Platform platform11 = new Platform();
        addObject(platform11,447,562);
        platform11.setLocation(445,561);
        platform11.getImage().scale(90,40);
        platform11.setLocation(450,563);
        Fire fire = new Fire();
        addObject(fire,386,544);
        fire.setLocation(379,540);
        Fire fire2 = new Fire();
        addObject(fire2,517,548);
        fire2.setLocation(512,539);
        fire.setLocation(377,562);
        fire2.setLocation(515,557);

        Wall wall3 = new Wall(55);
        addObject(wall3,133,448);
        wall3.setLocation(161,436);
        Wall wall4 = new Wall(55);
        addObject(wall4,255,435);
        wall4.setLocation(247,437);
        wall4.setLocation(403,408);
        wall3.setLocation(250,435);
        wall4.setLocation(161,437);
        wall4.setLocation(161,435);
        platform3.setLocation(428,294);
        platform.setLocation(156,162);
        platform2.setLocation(744,161);
        platform8.setLocation(700,432);
        Wall wall5 = new Wall(55);
        addObject(wall5,660,448);
        wall5.setLocation(652,434);
        Wall wall6 = new Wall(55);
        addObject(wall6,786,457);
        wall6.setLocation(740,436);
        wall5.setLocation(652,437);
        wall5.setLocation(658,438);
        Wall wall7 = new Wall(55);
        addObject(wall7,292,341);
        wall7.setLocation(297,299);
        Wall wall8 = new Wall(55);
        addObject(wall8,618,298);
        wall8.setLocation(608,298);
        Wall wall9 = new Wall(55);
        addObject(wall9,281,159);
        wall9.setLocation(286,164);
        Wall wall10 = new Wall(55);
        addObject(wall10,612,166);
        wall10.setLocation(611,165);
    }
    
      public void act(){
        int score=player.getScore();
        EnemySpawnPoint.setCurrentScore(score);
        counter.setValue(score);
        health.setValue(player.getHealth());
        if(Greenfoot.isKeyDown("r")){
          
            stopMusic();
            Greenfoot.setWorld(new Level2());
        }
        if(Greenfoot.isKeyDown("escape")){
          
            stopMusic();
            Greenfoot.setWorld(new MainMenu());   
        }
    }
     public static void stopMusic(){
        sound.stop();
        fireSound.stop();
    }
    
}
