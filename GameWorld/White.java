import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class White here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class White extends Bits
{
    /**
     * Act - do whatever the White wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public White()
    {
        GreenfootImage img = getImage();
        img.scale(50,50);
    }
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            PlayBoardWorld w = (PlayBoardWorld) getWorld();
            if (w.getClass().getSimpleName().equalsIgnoreCase("PlayBoardWorld"))
            {
                if(this.getX()== w.getBitX()&& this.getY()== w.getBitY())
                {
                     System.out.println("Maa ki aankh");
                }
                
            System.out.println("Mouse Clicked White");
            w.removeObject(this);}
        }
    }    
}
