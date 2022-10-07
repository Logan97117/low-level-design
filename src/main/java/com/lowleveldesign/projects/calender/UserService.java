package com.lowleveldesign.projects.calender;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<Integer,User> users;
    public UserService() {
        this.users = new HashMap<Integer,User>();
    }

    public void addUser(int id, User user) {
        this.users.put(id, user);
    }

    public User getUser(int id) {
        return this.users.get(id);
    }
}
