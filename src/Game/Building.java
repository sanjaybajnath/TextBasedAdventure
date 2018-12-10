package Game;

import Rooms.Room;

public class Building {
    private Room[][]map;

    public Building (Room[][]map){
        this.map = map;
    }

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