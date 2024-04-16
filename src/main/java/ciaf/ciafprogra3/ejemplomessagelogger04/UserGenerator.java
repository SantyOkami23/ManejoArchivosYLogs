package ciaf.ciafprogra3.ejemplomessagelogger04;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static ciaf.ciafprogra3.utils.MessageLogger.MENSAJE_ERROR_CREACION_USUARIOS;
import static ciaf.ciafprogra3.utils.MessageLogger.MENSAJE_EXITO_CREACION_USUARIOS;

public class UserGenerator {
    private static final Logger logger = LogManager.getLogger(UserGenerator.class);
    private static final int NUM_USERS = 10;

    public static List<User> generateUsers() {
        List<User> users = new ArrayList<>();
        Faker faker = new Faker();

        try {
            for (int i = 0; i < NUM_USERS; i++) {
                String name = faker.name().fullName();
                String email = faker.internet().emailAddress();
                String phoneNumber = faker.phoneNumber().cellPhone();

                User user = new User(name, email, phoneNumber);
                users.add(user);
            }

            logger.info(MENSAJE_EXITO_CREACION_USUARIOS);
        } catch (Exception e) {
            logger.error(MENSAJE_ERROR_CREACION_USUARIOS, e);
            throw new RuntimeException(MENSAJE_ERROR_CREACION_USUARIOS, e);
        }

        return users;
    }
}
