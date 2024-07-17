import command.Menu;
import exception.HotelNotFoundException;
import model.*;
import storage.HotelStorage;
import storage.RoomStorage;
import storage.UserStorage;

import java.util.Scanner;

import static command.Menu.*;

public class Main {
    private static final HotelStorage hotelStorage = new HotelStorage();
    private static final RoomStorage roomStorage = new RoomStorage();
    private static final UserStorage userStorage = new UserStorage();

    private static final Scanner scanner = new Scanner(System.in);

    private static User registeredUser;
    static boolean runnable = true;

    public static void main(String[] args) {
        initData();
        while (runnable) {
            Menu.printLoginCommands();

            int command;

            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    runnable = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
        login();
    }

    private static void initData() {
        Hotel Marriott = new Hotel("Marriott", "Yerevan Amiryan 1", "010599000", 5, 4);
        hotelStorage.add(Marriott);
        Hotel Ibis = new Hotel("ibis", "Yerevan North Avenue 5/1", "010595959", 4, 5);
        hotelStorage.add(Ibis);

        Room roomMarriott1 = new Room(Marriott, 1, RoomType.STUDIO_CLASSIC, false);
        Room roomMarriott2 = new Room(Marriott, 2, RoomType.ONE_PLUS_ONE_CLASSIC, false);
        Room roomMarriott3 = new Room(Marriott, 3, RoomType.LUXURY, true);
        Room roomMarriott4 = new Room(Marriott, 4, RoomType.STUDIO_CLASSIC, false);
        Room roomMarriott5 = new Room(Marriott, 5, RoomType.ONE_PLUS_ONE_CLASSIC, false);
        roomStorage.add(roomMarriott1);
        roomStorage.add(roomMarriott2);
        roomStorage.add(roomMarriott3);
        roomStorage.add(roomMarriott4);
        roomStorage.add(roomMarriott5);

        Room roomIbis1 = new Room(Ibis, 1, RoomType.STUDIO_CLASSIC, false);
        Room roomIbis2 = new Room(Ibis, 2, RoomType.LUXURY, false);
        Room roomIbis3 = new Room(Ibis, 3, RoomType.LUXURY, false);
        Room roomIbis4 = new Room(Ibis, 4, RoomType.ONE_PLUS_ONE_CLASSIC, false);
        roomStorage.add(roomIbis1);
        roomStorage.add(roomIbis2);
        roomStorage.add(roomIbis3);
        roomStorage.add(roomIbis4);

        User user = new User("User", "099887766", "user", false, Role.USER);
        userStorage.add(user);
        User admin = new User("Admin", "055667788", "admin", false, Role.ADMIN);
        userStorage.add(admin);
    }

    private static void register() {
        System.out.println("Enter your name, phone number and password with commas.\nInput :");
        String userDataStr = scanner.nextLine();
        String[] userData = userDataStr.split(",");
        if (userData.length < 3) {
            System.out.println("Incorrect data");
        }
        if (userStorage.getUserByPhoneNumber(userData[1]) == null) {
            User user = new User();
            user.setName(userData[0]);
            user.setPhoneNumber(userData[1]);
            user.setPassword(userData[2]);
            user.setHaveReservedRoom(false);
            user.setRole(Role.USER);
            userStorage.add(user);
        } else {
            System.out.println("User with phone number " + userData[1] + " already exists");
        }
    }

    private static void login() throws HotelNotFoundException {
        System.out.println("Input your phone number and password with commas.");
        String phonePasswordStr = scanner.nextLine();

        String[] phonePassword = phonePasswordStr.split(",");

        User user = userStorage.getUserByPhoneNumber(phonePassword[0]);
        if (user == null) {
            System.out.println("Invalid phone number");
        } else {
            if (user.getPassword().equals(phonePassword[1])) {
                registeredUser = user;
                if (user.getRole().equals(Role.ADMIN)) {
                    loginAdmin();
                } else if (user.getRole().equals(Role.USER)) {
                    loginUser();
                }
            }
        }
    }

    private static void loginAdmin() throws HotelNotFoundException {
        boolean run = true;
        Menu.printAdminCommands();
        int command;
        try {
            command = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            command = -1;
        }
        switch (command) {
            case LOGOUT:
                run = false;
                break;
            case ADD_NEW_HOTEL:
                addHotel();
                break;
            case DELETE_HOTEL_BY_NAME:
                deleteHotel();
                break;
        }
    }

    private static void loginUser() throws HotelNotFoundException {
        boolean run = true;
        Menu.printChooseHotelCommands();
        int command;
        try {
            command = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            command = -1;
        }
        switch (command) {
            case LOGOUT:
                run = false;
                break;
            case PRINT_ALL_HOTELS:
                printAllHotels();
                break;
            case PRINT_HOTELS_BY_STARS_COUNT:
                printHotelsByStarsCount();
                break;
            case CHOOSE_HOTEL_BY_NAME:
                chooseHotel();
                break;
        }
    }

    private static void addHotel() {
        System.out.print("Input Hotel's name :");
        String name = scanner.nextLine();
        System.out.print("Input Hotel's address :");
        String address = scanner.nextLine();
        System.out.print("Input Hotel's phone number :");
        String phoneNumber = scanner.nextLine();
        System.out.println("Input rooms count :");
        int roomsCount = Integer.parseInt(scanner.nextLine());
        System.out.println("Input stars count :");
        int starsCount = Integer.parseInt(scanner.nextLine());

        Hotel hotel = new Hotel(name, address, phoneNumber, roomsCount, starsCount);
        hotelStorage.add(hotel);
    }

    private static void deleteHotel() throws HotelNotFoundException {
        System.out.print("Input Hotel's name :");
        String name = scanner.nextLine();;
        try {
            if(hotelStorage.getHotelByName(name) == null){
                throw new HotelNotFoundException();
            }else {
                hotelStorage.deleteHotelByName(name);
            }
        }catch (HotelNotFoundException e){
            e.getMessage();
        }
    }

    private static void printAllHotels() {
        hotelStorage.printHotels();
    }

    private static void printHotelsByStarsCount() throws HotelNotFoundException {
        System.out.println("Input Hotel's stars count :");
        int starsCount = Integer.parseInt(scanner.nextLine());
        try {
            System.out.println(hotelStorage.getHotelByStarsCount(starsCount).toString());
        }catch (HotelNotFoundException e){
            e.getMessage();
        }
    }

    private static void chooseHotel(String name) throws HotelNotFoundException {
        System.out.println("Input Hotel's name :");
        try {
            name = scanner.nextLine();
            System.out.println(hotelStorage.getHotelByName(name).toString());
        }catch (HotelNotFoundException e){
            e.getMessage();
        }
        boolean run = true;
        Menu.printChooseRoomCommands();
        int command;
        try {
            command = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            command = -1;
        }
        switch (command) {

        }
    }

}