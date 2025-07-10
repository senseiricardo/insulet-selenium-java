package utils;

import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UserData {

    private static JSONObject usersJson;

    static {
        try {
            // From classpath
            InputStream is = ClassLoader.getSystemResourceAsStream("testdata/users.json");
            if (is == null) {
                throw new RuntimeException("File users.json is not found");
            }

            String content = new Scanner(is, StandardCharsets.UTF_8).useDelimiter("\\A").next();
            usersJson = new JSONObject(content);

        } catch (Exception e) {
            System.out.println("Error: users.json: " + e.getMessage());
        }
    }

    public static String getUsername(String key){
        return usersJson.getJSONObject(key).getString("username");
    }

    public static String getPassword(String key){
        return usersJson.getJSONObject(key).getString("password");
    }
}
