import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;


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

    static final int SMALL = 0;
    static final int MEDIUM = 1;
    static final int LARGE = 2;

    static final int WIDTH = MyWorld.WIDTH;
    static final int HEIGHT = MyWorld.HEIGHT;

    static final int ANIMATION_INTERVAL = 5;
    
    double speed;
    double rotation = Greenfoot.getRandomNumber(360);
    int rotation_turn = Greenfoot.getRandomNumber(3);
    int health;
    int asteroidType;
    int animationDelay = 0;
    int hitboxRadius;
    double direction;

    GreenfootImage[] hitAnimation;

    
    public Asteroid(int x, int y, double direction, int type)
    {
        GreenfootImage[] hitAnimation = {
        new GreenfootImage("asteroid_sprite.png"),
        new GreenfootImage("asteroid_hit_standard.png")
        };

        this.direction = direction;
        this.asteroidType = type;
        this.animationDelay = 0;
        this.hitAnimation = hitAnimation;

        if (type == SMALL)
        {
            hitAnimation[0].scale(50, 50);
            hitAnimation[1].scale(50, 50);
            health = 2;
            speed = 3.0;
            hitboxRadius = 35;
        }
        else if (type == MEDIUM)
        {
            hitAnimation[0].scale(75, 75);
            hitAnimation[1].scale(75, 75);
            health = 7;
            speed = 2.0;
            hitboxRadius = 50;

        } else if (type == LARGE)
        {
            hitAnimation[0].scale(130, 130);
            hitAnimation[1].scale(130, 130);
            health = 13;
            speed = 1.5;
            hitboxRadius = 80;
        }

        setImage(hitAnimation[0]);

    }
    public void act()
    {
        // Add your action code here.
        move();
        collide();

        setRotation((int)rotation);
        if(rotation_turn == 0)
        {
            rotation += 0.5;
        }
        else if (rotation_turn == 1)
        {
            rotation -= 0.5;
        }

        if (animationDelay > 0)
        {
            animationDelay--;
            if (animationDelay == 0)
            {
                setImage(hitAnimation[0]);
            }
        }

        if(getX() < -100 || getX() > WIDTH+100 || getY() < -100 || getY() > HEIGHT+100)
        {
            direction = direction + 180;
            //getWorld().removeObject(this);

        } else if (health <= 0)
        {
            splitAsteroid();
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

    public void collide()
    {
        if (isTouching(Projectile.class))
        {
            removeTouching(Projectile.class);
            health -= 1;
            setImage(hitAnimation[1]);
            animationDelay = ANIMATION_INTERVAL;
        }


        List<Ship> ships = getObjectsInRange(hitboxRadius, Ship.class);
        if (ships != null && !ships.isEmpty() && !Ship.practice) {
           MyWorld.loseGame();
        }
    }

    private void splitAsteroid() {

        MyWorld.score += (asteroidType + 1) * 10;

        if (asteroidType == SMALL)
        {
            return; // small asteroids don't split
        }

        

        int type = asteroidType-1;
        getWorld().addObject(new Asteroid(getX(), getY(), direction+30, type), getX(), getY());
        getWorld().addObject(new Asteroid(getX(), getY(), direction-30, type), getX(), getY());
    }
}
