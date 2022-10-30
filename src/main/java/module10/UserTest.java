package module10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserTest {
    public static void main(String[] args) {

        List<User> listOfUsers = new ArrayList<>();

        try (InputStream fis = new FileInputStream("userdata.txt");
             OutputStream fos = new FileOutputStream("user.json");
             Scanner scanner = new Scanner(fis)) {

            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                if (s.matches("^(\\D+\\s\\d+)$")) {
                    User user = new User();
                    String[] s1 = s.split(" ");
                    user.setName(s1[0]);
                    user.setAge(Integer.parseInt(s1[1]));
                    listOfUsers.add(user);
                }
            }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String s2 = gson.toJson(listOfUsers);
            System.out.println(s2);
            fos.write(s2.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
