import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 animated coin
 */
public class Coin extends Actor
{
    private int imageCount = 8;
    private GreenfootImage[] images=new GreenfootImage[imageCount];
    private int fc=0;
    
    private int actsPerImage = 4; // act cycles per image
    
    public Coin(){
        
        for(int i=0;i<imageCount;i++){
            images[i]=new GreenfootImage("coinAnim/cc_coins_gold_"+i+".png");
            images[i].scale(25,25);
           
        }
        
        
    }

    
    
    public void act() 
    {
        // Add your action code here.
        animate();
    }    
    
      private void animate(){
         fc = (fc + 1) % (imageCount * actsPerImage); // act counter that cycles for each complete cycle of images
         int imageNumber = fc / actsPerImage;
         if (fc % actsPerImage == 0) // if time to change image
              setImage(images[imageNumber]);
       
            
    }
}
