import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 Player actor
 can walk left/right,jump,shoot
 */
public class Player extends Character
{
    
    private int shootDelay;
    private GreenfootImage[] anim;
    private int imageCount ; // number of images in the animation
    private int actsPerImage ; // act cycles per image
    private int animationActCounter ;// act counter for the animation
    private int invicibilityFrames; 
    private int score;
    private Bubble b;
    
    public Player(){
        b=new Bubble(this);
      
        score=0;
        health=5;
        imageCount = 9; // number of images in the animation
        actsPerImage = 4; // act cycles per image
        getImage().scale(80,80);
        shootDelay=0;
        animationActCounter = 0; // act counter for the animation
        invicibilityFrames = 1 ;
        anim=new GreenfootImage[imageCount];
        int i=1;
        for(i=0;i<imageCount;i++){        
            anim[i]=new GreenfootImage("images/heroAnim/RunShoot ("+(i+1)+").png");
            anim[i].scale(80,80);
        }
        
    
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
       collisionWithWorld();
       checkKeys();
       incScore();
       gotHit();
       die();
       shootDelay--;
      if(invicibilityFrames>0){ 
           
            invicibilityFrames--;
      }
      else{
          b.deActivate();
          
        }
    }    
    
    
    public void checkKeys(){
        if(Greenfoot.isKeyDown("space") && !jumping){
            jump();
            
        }
        if(Greenfoot.isKeyDown("right")){
             animate();
            moveRight();
            
        }
        if(Greenfoot.isKeyDown("left")){
            animate();
            moveLeft();
            
        }
         if((Greenfoot.isKeyDown("z")|| Greenfoot.isKeyDown("ζ")) && shootDelay<=0){
            
            shoot();
            
        }
        
        
        
        
    }
    
    //player action methods
    public void moveRight(){
       
        if(direction==-1){
           for(int i=0;i<imageCount;i++){        
              anim[i].mirrorHorizontally();
            
           
           
           }
            
            direction= -direction;
        }
        setLocation(getX()+speed,getY());
    }
    
     public void moveLeft(){
         if(direction==1){
             
         for(int i=0;i<imageCount;i++){        
            anim[i].mirrorHorizontally();
           
         }
             direction= -direction;
        }
        setLocation(getX()-speed,getY());
    }
    
    
    
    public void jump(){
        vSpeed-=jmpStrength;   
        jumping=true;
        fall();
        
    }
    
    public void shoot(){
       getWorld().addObject(new Bullet(1,direction),getX() +30*direction,getY()+10);
       Greenfoot.playSound("sounds/shoot.wav");
       shootDelay=15;
       
    }
    //player action methods end
    
    //method to check collision with platforms above
    public void platformAbove(){
        
       int sprHeight=getImage().getHeight();
       int lookForGround = (int)(sprHeight/-2);
       
       Platform platform=(Platform) getOneObjectAtOffset(0,lookForGround,Platform.class);
       if(platform != null){
           vSpeed=1;
           hitCeiling(platform);
        
        }
        
    }
    
   
    //method to correct charactes possition
    public void hitCeiling(Platform p){
        int pHeight=p.getImage().getHeight();
        int newY=p.getY()+(pHeight +getImage().getHeight())/2;
        setLocation(getX(),newY);
        
        
    }
    
    
    //animation method
    protected void animate(){
            animationActCounter = (animationActCounter + 1) % (imageCount * actsPerImage); // act counter that cycles for each complete cycle of images
            int imageNumber = animationActCounter / actsPerImage;
            if (animationActCounter % actsPerImage == 0) // if time to change image
                 setImage(anim[imageNumber]);
               
           
        
        
    }
    
    
    //method to check if hit by enemy or fire
    public void gotHit(){
       Actor fire= getOneObjectAtOffset(0, 0, FireColisionBox.class);
       Actor enemy= getOneObjectAtOffset(0, 20 , Enemy.class);
       GreenfootImage bubble=new GreenfootImage(70,70);
       
       if(invicibilityFrames<=0){
           
           if(enemy != null ){
                Greenfoot.playSound("sounds/bang.wav");
               health -= 1;
               //make player invulnerable for 100 ticks
               invicibilityFrames=100;
               b.activate();
               
               
            }
            else if(fire != null )
            {
               Greenfoot.playSound("sounds/hitFire.wav");
               health -= 1;
               ////make player invulnerable for 100 ticks and reset his position
               invicibilityFrames=100;
               setLocation(120,440);
               b.activate();
            }
        }
        if(fire != null )
        {
               Greenfoot.playSound("sounds/hitFire.wav"); 
               setLocation(120,440);
        }
        
    }
    //check if player is dead
    public void die(){
        
        if (health<=0)
        {
            getWorld().addObject(new ScoreBoard(score),450, 267);
            getWorld().removeObject(b);
            getWorld().removeObject(this);
            
        }
        
    }
    ///increment score when a coin is collected
    public void incScore(){
        Actor coin= getOneIntersectingObject(Coin.class); 
        if(coin != null ){
               Greenfoot.playSound("sounds/coin.wav");
               score++;
               getWorld().removeObject(coin);
               
            }
    }
    
    public int getScore(){
        return score;
    }
    
    public int getHealth(){
        return health;
    }
    
    //method calling all the collision with the world methods
    public void collisionWithWorld(){
        checkFall();
        platformAbove();
        checkRightWalls();
        checkLeftWalls();
    }
    
    
    public Bubble getBubble(){
        return b;
    }
}
