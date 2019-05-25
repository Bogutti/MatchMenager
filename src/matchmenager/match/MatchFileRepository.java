package matchmenager.match;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import tools.Tools;

public class MatchFileRepository {

    final String filePath = "database/match.txt";

    public void create(MatchDto match) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) { //dopisuje do pliku
            fileWriter.write(match.toString() + System.lineSeparator());// nowa linia
        }
    }

    public MatchDto get(UUID scoreId) throws IOException {
        String reequestedMatch = "";

        reequestedMatch = Tools.getRequestedObject(scoreId, filePath);

        if (couldNotFindScore(reequestedMatch)) {
            return null;
        }

        MatchDto result = convertRequestedMatchToMatchObject(reequestedMatch);
        return result;
    }

    private boolean couldNotFindScore(String reequestedScore) {
        return reequestedScore.equals("");
    }

    private MatchDto convertRequestedMatchToMatchObject(String reequestedScore) {
        String[] objectFields = Tools.parseStringToParameters(reequestedScore);

        MatchDto match = assignParametersToMatch(objectFields);
        return match;
    }

    private MatchDto assignParametersToMatch(String[] objectFields) throws NumberFormatException {
        MatchDto match = new MatchDto();
        match.setId(UUID.fromString(objectFields[0]));
        match.setHostId(UUID.fromString(objectFields[1]));
        match.setGuestId(UUID.fromString(objectFields[2]));
        match.setMatchDate(LocalDateTime.parse(objectFields[3]));
        match.setScoreId(UUID.fromString(objectFields[4]));
        match.setTicketPrice(Double.parseDouble(objectFields[5]));
        match.setMatchPlace((objectFields[6]));

        return match;
    }

    public List<MatchDto> getAll() throws IOException {

        List<MatchDto> results = new ArrayList<MatchDto>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = null;
        while ((line = br.readLine()) != null) {
            MatchDto result = convertRequestedMatchToMatchObject(line);

            results.add(result);

        }
        return results;

    }

}
