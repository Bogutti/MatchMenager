package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class Tools {

    public static String[] parseStringToParameters(String reequestedScore) {
        String[] objectFields = reequestedScore.split(",");
        int lenght = objectFields.length;
        for (int i = 0; i < lenght; i++) {
            objectFields[i] = objectFields[i].substring(objectFields[i].indexOf("=") + 1).trim();
        }

        objectFields[lenght - 1] = objectFields[lenght - 1].replace("}", "");
        return objectFields;
    }

    public static String getRequestedObject(UUID id, String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            for (String line; (line = br.readLine()) != null;) {
                if (recordFound(line, id)) {
                    return line;
                }
            }
        }
        return "";
    }

    private static boolean recordFound(String line, UUID id) {
        return line.contains(id.toString());
    }

}
