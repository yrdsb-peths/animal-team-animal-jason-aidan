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

    static final int SMALL = 0;
    static final int MEDIUM = 1;
    static final int LARGE = 2;

    static final int WIDTH = MyWorld.WIDTH;
    static final int HEIGHT = MyWorld.HEIGHT;
    
    double speed;
    double rotation = Greenfoot.getRandomNumber(360);
    int rotation_turn = Greenfoot.getRandomNumber(3);
    int health;
    int asteroidType;
    int imageNum = 0;
    double direction;

    
    public Asteroid(int x, int y, double direction, int type)
    {
        GreenfootImage image = new GreenfootImage("asteroid_sprite.png");
        setImage(image);
        image.scale(100,100);

        this.direction = direction;
        this.asteroidType = type;

        if (type == SMALL)
        {
            image.scale(50, 50);
            health = 2;
            speed = 4.0;
        }
        else if (type == MEDIUM)
        {
            image.scale(75, 75);
            health = 7;
            speed = 2.0;

        } else if (type == LARGE)
        {
            image.scale(130, 130);
            health = 13;
            speed = 1.5;
        }

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

        if(getX() < -100 || getX() > WIDTH+100 || getY() < -100 || getY() > HEIGHT+100)
        {

            getWorld().removeObject(this);

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
            GreenfootImage image = new GreenfootImage("asteroid_hit_standard.png");
            if(imageNum == 0)
            {
                setImage("asteroid_hit_standard.png");
                if (asteroidType == SMALL)
                {
                    image.scale(50, 50);
                }
                    else if (asteroidType == MEDIUM)
                {
                    image.scale(75, 75);
                } else if (asteroidType == LARGE)
                {
                    image.scale(130, 130);
                }
                imageNum = 1;
            }
            else
            {
                imageNum = 0;
                setImage("asteroid_sprite.png");
                if (asteroidType == SMALL)
                {
                    image.scale(50, 50);
                }
                    else if (asteroidType == MEDIUM)
                {
                    image.scale(75, 75);
                } else if (asteroidType == LARGE)
                {
                    image.scale(130, 130);
                }
            }
        }
    }

    private void splitAsteroid() {

        if (asteroidType == SMALL)
        {
            return; // small asteroids don't split
        }

        int type = asteroidType-1;

        getWorld().addObject(new Asteroid(getX(), getY(), direction+30, type), getX(), getY());

        getWorld().addObject(new Asteroid(getX(), getY(), direction-30, type), getX(), getY());
    }
}
