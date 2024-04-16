package ciaf.ciafprogra3.ejemplomessagelogger04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static ciaf.ciafprogra3.utils.MessageLogger.MENSAJE_ERROR_CREACION_USUARIOS;
import static ciaf.ciafprogra3.utils.MessageLogger.MENSAJE_EXITO_CREACION_USUARIOS;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            logger.info(MENSAJE_EXITO_CREACION_USUARIOS);
            List<User> users = UserGenerator.generateUsers();

            // Imprime la lista de usuarios
            for (User user : users) {
                System.out.println(user);
            }
            logger.info(MENSAJE_EXITO_CREACION_USUARIOS);
        } catch (Exception e) {
            logger.error(MENSAJE_ERROR_CREACION_USUARIOS, e);
            throw new RuntimeException(MENSAJE_ERROR_CREACION_USUARIOS, e);
        }
    }
}