package Items;

import People.Person;

public class Weapon implements Item{

    public static int count = 0;

    public String getName(){
        return("health pack");
    }

    public void use (Person p){
        System.out.println("You found a weapon.");
        p.hasWeapon = true;
    }
}