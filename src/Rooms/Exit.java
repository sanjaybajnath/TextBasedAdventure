package Rooms;

import Game.Runner;
import People.Person;

public class Exit extends Room
{
    public boolean normalRoom = false;
    private boolean discovered = false;

    public Exit(int x, int y) {
        super(x, y);

    }

    /**
     * Ends the game if the user already found the key.
     * @param x the Person entering
     */
    public void enterRoom(Person x) {
        this.discovered = true;
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        if(x.hasKey){
            System.out.println("Congratulations,"+x.getName()+". You win.");
            Runner.gameOff();
        }
        else{
            System.out.println("The exit is locked.");
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
            return ("[E]");
        }
    }



}