package Rooms;

import People.Person;

public class Room {
    Person occupant;
    int xLoc,yLoc;
    private boolean discovered = false;
    public Room(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        this.discovered = true;
        System.out.println("You enter a plain old room");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveRoom(Person x)
    {
        occupant = null;
    }

    public String toString(){
        if(this.occupant != null){
            return("[P]");
        }
        else if (this.discovered == false){
            return("[?]");
        }
        else{
            return ("[-]");
        }
    }

}