package authorization;

import java.io.*;
import java.util.ArrayList;

public class Authorization {
    public static final String DATABASE_PATH = "C:\\Users\\Сэм\\NewTheme\\src\\resources\\database.txt";

    File databaseFile = new File(DATABASE_PATH);

    ArrayList<String> usernames = new ArrayList<>();
    ArrayList<String> passwords = new ArrayList<>();

    public void readDatabaseFile() {
        try (FileReader fileReader = new FileReader(databaseFile)) {
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            parseUserName(line);
            parsePassword(line);
            System.out.println(passwords);
            System.out.println(usernames);
            System.out.println("Username - " + usernames.get(0));
            System.out.println("Password - " + passwords.get(0));
        }
        catch(FileNotFoundException exception) {
            System.out.println("Database not found.");

        } catch (IOException e) {
        }
            throw new RuntimeException();
        }



    private void parseUserName(String line) {
        char[] chars = line.toCharArray();
        StringBuilder username = new StringBuilder();

        for (char aChar : chars) {
            String symbol = String.valueOf(aChar);
            if (symbol.equals(" ")) {
                usernames.add(username.toString());
                break;
            } else {
                username.append(symbol);
            }
        }

    }
    private void parsePassword(String databaseLine) {
        char[] chars = databaseLine.toCharArray();
        StringBuilder password = new StringBuilder();
        for (int  i = 0;  i< chars.length; i++) {
            String symbol = String.valueOf(chars[i]);
            if (symbol.equals(" ")) {
                for ( int k = i + 3; k< chars.length; k ++) {
                    password.append(chars[k]);
                }
                passwords.add(password.toString());
                break;
            }
        }

    }
}


