package People;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
    String name;
    int xLoc, yLoc;
    public static int health;
    public static boolean hasKey = false;
    public static boolean hasWeapon = false;

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public Person (String name, int xLoc, int yLoc)
    {
        this.name = name;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.health = 100;
    }

    public void addHealth(int h){
        this.health += h;
    }

    public int getHealth(){
        return health;
    }

    public String getName(){
        return this.name;
    }

}