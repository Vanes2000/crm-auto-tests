package crm.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataTests  {

    public Map<String, String> readUsersFromFile() throws IOException, CsvException {
        Map<String, String> userMap = new HashMap<String, String>();
        List<String[]> allRows;
        FileReader fileReader = new FileReader("src/test/resources/DataUser/sys_account.csv");
        CSVReader csvReader = new CSVReader(fileReader);
        allRows = csvReader.readAll();

        for (String[] row :allRows) {
            userMap.put(row[0], row[1]);
        }
        return userMap;

    }
}