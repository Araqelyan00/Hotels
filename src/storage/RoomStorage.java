package storage;

import model.Hotel;
import model.Room;
import model.RoomType;

public class RoomStorage {
    private static Room[] rooms = new Room[10];

    private static int size = 0;

    public void add(Room room){
        if(rooms.length == size){
            extend();
        }
        rooms[size++] = room;
    }

    private void extend(){
        Room[] temp = new Room[rooms.length + 10];
        for(int i = 0; i < size; i++){
            temp[i] = rooms[i];
        }
        rooms = temp;
    }

    public Room getAvailableRoomsByType(RoomType type){
        for(int i = 0; i < size; i++){
            if(rooms[i].getRoomType() == type && !(rooms[i].isReserved())){
                return (rooms[i]);
            }
        }
        return null;
    }

    public Room getRoomByNumber(int number){
        for(int i = 0; i < size; i++){
            if(rooms[i].getNumber() == number){
                rooms[i].setReserved(true);
                return (rooms[i]);
            }
        }
        return null;
    }
}
