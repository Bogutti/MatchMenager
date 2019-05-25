package matchmenager.match;

import java.io.FileWriter;
import java.io.IOException;

public class MatchFileRepository {
    final String filePath = "database/match.txt";
    
    public void create(MatchDto match) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) { //dopisuje do pliku
            fileWriter.write(match.toString() + System.lineSeparator());// nowa linia
        }
    }
    
    
    
}
