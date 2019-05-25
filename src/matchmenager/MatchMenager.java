package matchmenager;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import matchmenager.match.MatchDto;
import matchmenager.match.ScoreDto;
import matchmenager.match.ScoreFileRepository;
import matchmenager.team.TeamDto;

public class MatchMenager {
    
    public static void main(String[] args) {
        ScoreDto score = new ScoreDto();
        score.setId(UUID.randomUUID());
        score.setGuestPoints(2);
        score.setHostPoints(1);
       
        ScoreFileRepository scoreRepository = new ScoreFileRepository();
        try {
            scoreRepository.create(score);
        } catch (IOException ex) {
            Logger.getLogger(MatchMenager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
             scoreRepository.get(score.getId());
        } catch (IOException ex) {
            Logger.getLogger(MatchMenager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TeamDto guest = new TeamDto();
        guest.setId(UUID.randomUUID());
        
        ETamDto host = new T
 
        
        
        
        
        MatchDto match = new MatchDto();
        score.setId(UUID.randomUUID());
        
        
        
        
        
    }
}
