package Rooms;

import Items.Item;
import People.Person;

public class Room {
    public boolean normalRoom = true;
    public Item item;
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

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        if (this.item == null){
            System.out.println("You enter a plain old room");
        }
        else{
            this.item.use(x);
            this.item = null;
        }


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

    public int getxLoc(){
        return this.xLoc;
    }
    public int getyLoc(){
        return this.yLoc;
    }



}