package ciaf.ciafprogra3.ejemplojavafaker02;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class UserGenerator {
    private static final int NUM_USERS = 5;

    public static List<User> generateUsers() {
        List<User> users = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < NUM_USERS; i++) {
            String name = faker.name().fullName();
            String email = faker.internet().emailAddress();
            String phoneNumber = faker.phoneNumber().cellPhone();

            User user = new User(name, email, phoneNumber);
            users.add(user);
        }

        return users;
    }

    public static void main(String[] args) {
        List<User> users = generateUsers();

        // Imprime la lista de usuarios
        for (User user : users) {
            System.out.println(user);
        }
    }
}