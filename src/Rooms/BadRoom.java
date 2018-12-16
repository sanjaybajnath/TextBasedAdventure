package Rooms;

import Game.Runner;
import People.Person;

public class BadRoom extends Room {

    public boolean normalRoom = false;
    private boolean discovered = false;

    public BadRoom(int x, int y) {
        super(x, y);

    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    public void enterRoom(Person x) {
        this.discovered = true;
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        if(!(x.hasWeapon)){
            System.out.println("A cave monster attacked you and you lost 50 health.");
            x.addHealth(-50);
        }
        else{
            System.out.println("There was a cave monster in this room, but you defeated it before it could attack you.");
        }

    }

    @Override
    public String toString(){
        if(this.occupant != null){
            return("[P]");
        }
        else if (this.discovered == false){
            return("[?]");
        }
        else{
            return ("[!]");
        }
    }
}
