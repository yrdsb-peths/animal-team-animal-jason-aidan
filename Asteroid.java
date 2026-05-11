import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Actor
{
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int speed = 6;
    double direction;
    
    static int angleVariation = 30; // how much it varies from center 
    
    public Asteroid(int x, int y)
    {
        GreenfootImage image = new GreenfootImage("button-green.png");
        setImage(image);
        
        //double angle = Math.atan((double)(y - getWorld().getHeight() / 2.0) / (double)(x - getWorld().getWidth() / 2.0));
        // if (x < getWorld().getWidth() / 2.0)
        // {
        //     // arctan's range is only -90 to 90, so we need to add 180 if it's coming from the left
        //     angle += Math.PI; 
        // }
        // this.direction = angle * 180 / Math.PI + Greenfoot.getRandomNumber(angleVariation * 2) - angleVariation; // convert to degrees
    }
    public void act()
    {
        // Add your action code here.
        // move();
        // if (isAtEdge())
        // {
        //     getWorld().removeObject(this);
        // }
    }
    public void move()
    {
        double radians = Math.toRadians(direction);
        int dx = (int)(speed * Math.cos(radians));
        int dy = (int)(speed * Math.sin(radians));
        setLocation(getX() + dx, getY() + dy);

    }
}
