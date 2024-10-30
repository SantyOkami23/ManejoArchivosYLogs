package ciaf.ciafprogra3.ejemplologger03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            logger.info("HOLA ESTO ES UN LOGGER");
            List<User> users = UserGenerator.generateUsers();

            // Imprime la lista de usuarios
            for (User user : users) {
                System.out.println(user);
            }
        } catch (Exception e) {
            logger.error("Error al generar usuarios.", e);
            throw new RuntimeException("Error al generar usuarios.", e);
        }
    }
}