package task3;

import java.util.HashMap;

public class User {
    private static HashMap<String, String> users = new HashMap<>();

    static {
        // Pre-defined users (username -> password)
        users.put("admin", "admin123");
        users.put("user", "user123");
    }

    public static boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

