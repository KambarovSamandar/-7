import authorization.Authorization;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Registration {
    public void registrate(String NewUsername, String NewPassword)
            throws IOException {



        FileWriter fileWriter = new FileWriter(Authorization.DATABASE_PATH, true);
        fileWriter.write("\n" + NewUsername + " - " + NewPassword);
            fileWriter.close();
        }
        public void startRegistration() throws IOException {
            Scanner scanner = new Scanner(System.in) ;
            System.out.println("придумайте логин: ");
            String newUsename = scanner.nextLine();
            System.out.println("придумацте пароль");
            String newPassword = scanner.nextLine();

            registrate(newUsename,newPassword);
            System.out.println("вы успешно зарегистрировались");

    }
}
