package storage;

import model.Hotel;
import model.Room;
import model.RoomType;

public class RoomStorage {
    private static Room[] rooms = new Room[10];

    private static int size = 0;

    public void add(Room room) {
        if (rooms.length == size) {
            extend();
        }
        rooms[size++] = room;
    }

    private void extend() {
        Room[] temp = new Room[rooms.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = rooms[i];
        }
        rooms = temp;
    }

//    public Room[] getAvailableRoomsByType(RoomType type) {
//        Room[] temp = new Room[size + 10];
//        int index = 0;
//
//            for (int i = 0; i < size; i++) {
//                if (rooms[i].getRoomType().equals(type) && !(rooms[i].isReserved())) {
//                    temp[index] = rooms[i];
//                    index++;
//                }
//            }
//            return temp;
//        }

    public void getAvailableRoomsByType(RoomType type) {
        System.out.println("\nAvailable Rooms are");
        for (int i = 0; i < size; i++) {
            if (rooms[i].getRoomType().equals(type) && !(rooms[i].isReserved())) {
                System.out.println(rooms[i].toString());
            }
        }
    }


    public Room getRoomByNumber(int number) {
        for (int i = 0; i < size; i++) {
            if (rooms[i].getNumber() == number) {
                rooms[i].setReserved(true);
                return (rooms[i]);
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }
}
