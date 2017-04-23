import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 animated fire
 */
public class Fire extends Actor
{
  
    private GreenfootImage[] images=new GreenfootImage[4];
    private int fc=0;
    private int imageCount = 4; // number of images in the animation
    private int actsPerImage = 7; // act cycles per image
    public Fire(){
       
        getImage().scale(120,120);
        for(int i=0;i<4;i++){
            images[i]=new GreenfootImage("fireAnim/"+(i+1)+".png");
            images[i].scale(120,120);
        }
        
    }
    /**
     * Act - do whatever the Fire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         animate();
    }  
    
    private void animate(){
         fc = (fc + 1) % (imageCount * actsPerImage); // act counter that cycles for each complete cycle of images
         int imageNumber = fc / actsPerImage;
         if (fc % actsPerImage == 0) // if time to change image
              setImage(images[imageNumber]);
       
            
    }
    

}
