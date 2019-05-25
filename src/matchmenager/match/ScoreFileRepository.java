package matchmenager.match;

import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import tools.Tools;

public class ScoreFileRepository {

    final String filePath = "database/score.txt";

//<editor-fold defaultstate="collapsed" desc="create">
    public void create(ScoreDto score) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) { //dopisuje do pliku
            fileWriter.write(score.toString() + System.lineSeparator());// nowa linia
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="get">
    public ScoreDto get(UUID scoreId) throws IOException {
        String reequestedScore = "";

        reequestedScore = Tools.getRequestedScore(scoreId, filePath);

        if (couldNotFindScore(reequestedScore)) {
            return null;
        }

        ScoreDto result = convertRequestedScoreToScoreObject(reequestedScore);
        return result;
    }

    private static boolean couldNotFindScore(String reequestedScore) {
        return reequestedScore.equals("");
    }

    private ScoreDto convertRequestedScoreToScoreObject(String reequestedScore) {
        String[] objectFields = Tools.parseStringToParameters(reequestedScore);

        ScoreDto score = assignParametersToScore(objectFields);
        return score;
    }

    private ScoreDto assignParametersToScore(String[] objectFields) throws NumberFormatException {
        ScoreDto score = new ScoreDto();
        score.setId(UUID.fromString(objectFields[0]));
        score.setGuestPoints(Integer.parseInt(objectFields[1]));
        score.setHostPoints(Integer.parseInt(objectFields[2]));
        return score;
    }
//</editor-fold>
}
