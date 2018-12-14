package Game;

import Rooms.Room;

public class Cave {
    private Room[][]map;

    public Cave (Room[][]map){
        this.map = map;
    }

    public int getRows(){
        return map.length;
    }

    public int getColumns(){
        return map[0].length;
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