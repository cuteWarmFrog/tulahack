package com.example.p2p.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

public class SessionService {
    private static SessionService instance;
    private HashMap<String, String> userMap;

    private SessionService() {
        userMap = new HashMap<>();
    };

    public static SessionService getSessionService() {
        if (instance == null) {
            instance = new SessionService();
        }
        return instance;
    }

    public void addUser(String login, String public_key) {
        userMap.put(login, public_key);
    }

    public Boolean checkUser(String login) {
        return userMap.containsKey(login);
    }

    public String getPublicKey(String login) {
        return userMap.get(login);
    }

    public void deleteUser(String login) {
        userMap.remove(login);
    }
}
