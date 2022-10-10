package com.lowleveldesign.projects.atm.concrete;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String,User> users;
    private Map<String,String> pinInfo;

    public UserService() {
        this.users = new HashMap<>();
        this.pinInfo = new HashMap<>();
        this.dbConnection();
    }

    private void dbConnection() {
        //load the DB client here
        //we are using in memory data for now
        this.users.put("123", new User("A", "B", "123"));
        this.users.put("456", new User("C", "D", "456"));
        this.users.put("789", new User("E", "F", "789"));
        this.pinInfo.put("123", "4128");
        this.pinInfo.put("456", "4120");
        this.pinInfo.put("789", "7456");
    }

    public boolean validateUser(String userId, Card card, String pinInfo) {
        if(!this.users.containsKey(userId) || !this.pinInfo.containsKey(userId))
            return false;

        //Logic to validate the card can also be added
        return pinInfo.equals(this.pinInfo.get(userId));
    }

    public User getUser(String userId) {
        return this.users.get(userId);
    }
}
