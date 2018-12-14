package Items;

import People.Person;

public class HealthPack implements Item{

    public static int count = 0;

    public String getName(){
        return("health pack");
    }

    public void use (Person p){
        System.out.println("You found a health pack and gained 50 health.");
        p.addHealth(50);
    }
}
