package crm.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserCredentialsReader {

    private static final String FILE_PATH = "src/test/resources/DataUser/sys_account.csv";

    public Map<String, String> readUsersFromFile() throws IOException, CsvException {
        Map<String, String> userMap = new HashMap<>();
        List<String[]> allRows;

        try (FileReader fileReader = new FileReader(FILE_PATH);
             CSVReader csvReader = new CSVReader(fileReader)) {
            allRows = csvReader.readAll();

            for (int i = 1; i < allRows.size(); i++) {
                String[] row = allRows.get(i);

                if (row.length < 2) {
                    throw new IllegalArgumentException("Нет данных в строке " + i);
                }

                String login = row[0];
                String password = row[1];

                if (login == null || login.trim().isEmpty()) {
                    throw new IllegalArgumentException("Отсутствует логин в строке " + i);
                }

                if (password == null || password.trim().isEmpty()) {
                    throw new IllegalArgumentException("Отсутствует пароль в строке " + i);
                }
                userMap.put(login.trim(), password.trim());
            }
        }
        return userMap;
    }
}

