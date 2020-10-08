package com.codegym.service;

import com.codegym.model.Login;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static List<User> users ;
    static {
        users = new ArrayList<>();
      User user1 = new User("van1","12345","dang anh van","van@gmail.com",15);
      User user2 = new User("van2","12345","dang anh van","van@gmail.com",15);
      User user3 = new User("van3","12345","dang anh van","van@gmail.com",15);
      User user4 = new User("van4","12345","dang anh van","van@gmail.com",15);
      users.add(user1);
      users.add(user2);
      users.add(user3);
      users.add(user4);
    }
    public User checkLogin (Login login){
        for (User user1 : users) {
            if (user1.getAccount().equals(login.getAccount()) && user1.getPassword().equals(login.getPassword())){
                return user1;
            }
        }
        return null;
    }
}
