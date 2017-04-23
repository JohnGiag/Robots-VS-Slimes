import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


import java.util.Calendar;


/**
 * The ScoreBoard is used to display results on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kolling
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 70.0f;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 480;
    
    /**
     * Create a score board with dummy result for testing.
     */
    public ScoreBoard()
    {
        this(100);
    }

    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(int score)
    {
        makeImage("Game Over", "Score: ", score);
    }

    /**
     * Make the score board image.
     */
    private void makeImage(String title, String prefix, int score)
    {
        
     
        Font font = getImage().getFont();    
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(255,255,255,120));
       
        image.setColor(new Color(0, 0, 0, 200));
        image.fillRect(0, 0, WIDTH, HEIGHT);
       // Font font = image.getFont();                 
        font =font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 200, 100);
        image.drawString(prefix + score, 200, 200);
        image.drawString("Press R to restart", 100, 300);
        image.drawString("Escape to exit to menu", 50, 400);
        setImage(image);
    }
}
