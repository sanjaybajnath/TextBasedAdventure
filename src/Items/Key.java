package Items;

import People.Person;

public class Key implements Item{

    public String getName(){
        return ("key");
    }

    public void use(Person p){
        p.hasKey = true;
        System.out.println("You found the key! Get to the exit to win!");
    }
}
