package model;

public class User {
    private String name;
    private String phoneNumber;
    private String password;
    private boolean haveReservedRoom;

    public User(String name, String phoneNumber, String password, boolean haveReservedRoom) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.haveReservedRoom = haveReservedRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isHaveReservedRoom() {
        return haveReservedRoom;
    }

    public void setHaveReservedRoom(boolean haveReservedRoom) {
        this.haveReservedRoom = haveReservedRoom;
    }
}
