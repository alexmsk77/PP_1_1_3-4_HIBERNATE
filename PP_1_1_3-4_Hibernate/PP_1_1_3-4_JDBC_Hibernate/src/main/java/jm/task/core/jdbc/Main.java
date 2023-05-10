package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Petr", "Ivanov", (byte) 45);
        userService.saveUser("Alex", "Denisov", (byte) 25);
        userService.saveUser("Denis", "Petrov", (byte) 35);
        userService.saveUser("Ivan", "Novikov", (byte) 40);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.getAllUsers();
        userService.dropUsersTable();
        Util.closeConnection();
    }
}