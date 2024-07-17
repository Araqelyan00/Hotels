package storage;

import model.User;

public class UserStorage {
    private static User[] users = new User[100];

    private static int size = 0;

    public void add(User user){
        if(users.length == size){
            extend();
        }
        users[size++] = user;
    }

    private static void extend(){
        User[] temp = new User[users.length + 10];
        for(int i = 0; i < size; i++){
            temp[i] = users[i];
        }
        users = temp;
    }

    public User getUserByPhoneNumber(String phoneNumber){
        for(int i = 0; i < size; i++){
            if(users[i].getPhoneNumber().equals(phoneNumber)){
                return users[i];
            }
        }
        return null;
    }


}
