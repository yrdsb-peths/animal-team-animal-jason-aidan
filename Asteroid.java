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
    
    int speed;
    double direction;
    
    static int angleVariation = 30; // how much it varies from center 
    
    public Asteroid(int speed, int x, int y)
    {
        GreenfootImage image = new GreenfootImage("button-green.png");
        setImage(image);
        
        this.speed = speed;
        
        
        
    }
    public void act()
    {
        // Add your action code here.
        move();
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    public void move()
    {
        double radians = Math.toRadians(direction);
        int dx = (int)(speed * Math.cos(radians));
        int dy = (int)(speed * Math.sin(radians));
        setLocation(getX() + dx, getY() + dy);

    }
}
