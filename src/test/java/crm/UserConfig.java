package crm;

import com.opencsv.exceptions.CsvException;
import crm.utils.UserCredentialsReader;

import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;

public class UserConfig {

    private static final UserCredentialsReader dataTests = new UserCredentialsReader();
    private static final Map<String, String> users;

    static {
        try {
            users = dataTests.readUsersFromFile();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPassword(String login) {
        if (users.get(login) == null) {
            throw new NoSuchElementException("Данные для авторизации не найдены");
        }
        return users.get(login);
    }
}