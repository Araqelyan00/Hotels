package command;

public interface Menu {
    int LOGOUT = 0;
    int PRINT_ALL_HOTELS = 1;
    int PRINT_HOTELS_BY_STARS_COUNT = 2;
    int CHOOSE_HOTEL_BY_NAME = 3;

    int PRINT_ROOM_TYPES = 1;
    int PRINT_AVAILABLE_ROOMS_BY_TYPE = 2;
    int CHOOSE_ROOM_BY_NUMBER = 3;
    int RESERVE_ROOM = 4;
    int RELEASE_ROOM = 5;

    int ADD_NEW_HOTEL = 1;
    int DELETE_HOTEL_BY_NAME = 2;
    int UPDATE_HOTEL_BY_NAME = 3;

    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;

    static void printChooseHotelCommands(){
        System.out.println("Input " + LOGOUT + " to log out");
        System.out.println("Input " + PRINT_ALL_HOTELS + " to print all hotels");
        System.out.println("Input " + PRINT_HOTELS_BY_STARS_COUNT + " to print hotels list by stars count");
        System.out.println("Input " + CHOOSE_HOTEL_BY_NAME + " to choose hotel");
        System.out.println("Input command :");
    }

    static void printChooseRoomCommands(){
        System.out.println("Input " + LOGOUT + " to log out");
        System.out.println("Input " + PRINT_ROOM_TYPES + " to print all rooms");
        System.out.println("Input " + PRINT_AVAILABLE_ROOMS_BY_TYPE + " to print available rooms");
        System.out.println("Input " + CHOOSE_ROOM_BY_NUMBER + " to choose room");
        System.out.println("Input " + RESERVE_ROOM + " to reserve room");
        System.out.println("Input " + RELEASE_ROOM + " to release room");
        System.out.println("Input command :");
    }

    static void printAdminCommands(){
        System.out.println("Input " + LOGOUT + " to log out");
        System.out.println("Input " + ADD_NEW_HOTEL + " to add new hotel");
        System.out.println("Input " + DELETE_HOTEL_BY_NAME + " to delete hotel by name");
        System.out.println("Input " + UPDATE_HOTEL_BY_NAME + " to update hotel by name");
    }

    static void printLoginCommands() {
        System.out.println("Input " + EXIT + " to exit");
        System.out.println("Input " + LOGIN + " to login");
        System.out.println("Input " + REGISTER + " to register");
        System.out.println("Input command :");
    }
}
