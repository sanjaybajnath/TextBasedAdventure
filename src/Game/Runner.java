package Game;

//Find a key and get to the exit without dying.

import People.Person;
import Rooms.Room;
import Rooms.Exit;
import Rooms.BadRoom;
import Items.Key;
import Items.HealthPack;
import Items.Weapon;
import java.util.Scanner;

public class Runner {

    public static void print(String str){
        System.out.println(str);
    }

    //Fill the board with different rooms and items.
    public static void fillCave(Room[][]building){
        for (int x = 0; x<building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Room(x,y);
            }
        }

        //Create a random exit room and 2 bad rooms.
        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        while(x==0 && y == 0){
            x = (int)(Math.random()*building.length);
            y = (int)(Math.random()*building.length);
        }
        Room exitRoom = new Exit (x,y);
        building[x][y] = exitRoom;


        boolean badCoordinates = true;
        int x1 = 0;
        int y1 = 0;
        while(badCoordinates){
            x1 = (int)(Math.random()*building.length);
            y1 = (int)(Math.random()*building.length);
            if(x1==0 && y1 == 0){
                badCoordinates = true;
            }
            else if(x1==exitRoom.getxLoc() && y1 == exitRoom.getyLoc()){
                badCoordinates = true;
            }
            else{
                badCoordinates = false;
            }
        }
        Room badRoom1 = new BadRoom(x1,y1);
        building[x1][y1] = badRoom1;

        boolean badCoordinates2 = true;
        int x2 = 0;
        int y2 = 0;
        while (badCoordinates2){
            x2 = (int)(Math.random()*building.length);
            y2 = (int)(Math.random()*building.length);
            if(x2==0 && y2 == 0){
                badCoordinates2 = true;
            }
            else if(x2==exitRoom.getxLoc() && y2 == exitRoom.getyLoc()){
                badCoordinates2 = true;
            }
            else if(x2==badRoom1.getxLoc() && y2 == badRoom1.getyLoc()){
                badCoordinates2 = true;
            }
            else{
                badCoordinates2 = false;
            }
        }
        Room badRoom2 = new BadRoom(x2,y2);
        building[x2][y2] = badRoom2;



        //Place items into rooms
        int z = (int)(Math.random()*building.length);
        int w = (int)(Math.random()*building.length);
        while (building[z][w].normalRoom!=true || building[z][w].item!=null){
            z = (int)(Math.random()*building.length);
            w = (int)(Math.random()*building.length);
        }
        Key k = new Key();
        building[z][w].item = k;

        int z1 = (int)(Math.random()*building.length);
        int w1 = (int)(Math.random()*building.length);
        while (building[z][w].normalRoom!=true || building[z1][w1].item!=null){
            z1 = (int)(Math.random()*building.length);
            w1 = (int)(Math.random()*building.length);
        }
        HealthPack h1 = new HealthPack();
        building[z1][w1].item = h1;

        int z2 = (int)(Math.random()*building.length);
        int w2 = (int)(Math.random()*building.length);
        while (building[z2][w2].normalRoom!=true || building[z2][w2].item!=null){
            z2 = (int)(Math.random()*building.length);
            w2 = (int)(Math.random()*building.length);
        }
        Weapon glock = new Weapon();
        building[z2][w2].item = glock;
    }

    private static boolean gameOn = true;

    public static void main(String[] args)
    {


        Room[][] building = new Room[5][5];
        Scanner in = new Scanner(System.in);
        print("Enter your name: ");
        String name = in.nextLine();
        print("Would you like to play on a custom-sized board? Press Y to choose the size,or press anything else to play on the default 5x5 board.");
        String custom = in.nextLine();
        int size = 5;
        if(custom.toLowerCase().trim().equals("y")){
            print("What size would you like the board to be?(must be at least 5) ");
            size = in.nextInt();
        }


        Cave c = new Cave(size);
        if(size<=5){
            c = new Cave (building);
        }

        building = c.getMap();

        fillCave(building);

        //Setup player 1
        Person player1 = new Person( name, 0,0);
        building[0][0].enterRoom(player1);


        while(gameOn)
        {
            print("Where would you like to move? (Choose N, S, E, W). Press M to look at the map. Press h to check your health.");
            String move = in.nextLine();
            if (move.toLowerCase().trim().equals("m")){
                c.print();
            }
            if (move.toLowerCase().trim().equals("h")){
                print("You have "+player1.getHealth()+" health.");
            }
            else if(validMove(move, player1, building))
            {
                print("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());

            }
            else {
                print("Please choose a valid move.");
            }
            if(player1.health <= 0){
                print("Game over. "+name+" died.");
                gameOff();
            }

        }
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return true;
    }
    public static void gameOff()
    {
        gameOn = false;
    }



}