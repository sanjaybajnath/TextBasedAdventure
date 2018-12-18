package Game;

import Rooms.Room;

public class Cave {
    private Room[][]map;

    //Multiple constructors so the user can play on a default or custom board.
    public Cave (Room[][]map){
        this.map = map;
    }

    public Cave (int n){
        this.map = new Room [n][n];
    }

    public Room[][] getMap(){
        return this.map;
    }
    public int getRows(){
        return map.length;
    }

    public int getColumns(){
        return map[0].length;
    }

    //Prints the board in a readable format.
    public void print(){
        String row = "";
        for (int i = 0; i<map.length;i++){
            row = "";
            for(int j = 0; j<map[i].length;j++){
                row += map[i][j].toString();
            }
            System.out.println(row);
        }
    }
}