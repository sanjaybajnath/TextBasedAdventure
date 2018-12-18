package Items;

import People.Person;

public class HealthPack implements Item{


    public String getName(){
        return("health pack");
    }

    //The player gains 50 health if they pick up a health pack.
    public void use (Person p){
        System.out.println("You found a health pack and gained 50 health.");
        p.addHealth(50);
    }
}
