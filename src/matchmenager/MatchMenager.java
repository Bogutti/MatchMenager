package matchmenager;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import matchmenager.match.MatchDto;
import matchmenager.match.MatchFileRepository;
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

        TeamDto host = new TeamDto();
        host.setId(UUID.randomUUID());

        MatchDto match = new MatchDto();
        match.setId(UUID.randomUUID());
        match.setGuestId(guest.getId());
        match.setHostId(host.getId());
        match.setMatchDate(LocalDateTime.now());
        match.setScoreId(score.getId());
        match.setTicketPrice(20.0);
        match.setMatchPlace("Wawa");

        MatchFileRepository matchRepository = new MatchFileRepository();
        try {
            matchRepository.create(match);
        } catch (IOException ex) {
            Logger.getLogger(MatchMenager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            System.out.println(matchRepository.get(match.getId()));
        } catch (IOException ex) {
            Logger.getLogger(MatchMenager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        List<MatchDto> matches = new ArrayList<>();
        try {
            matches = matchRepository.getAll();
        } catch (IOException ex) {
            Logger.getLogger(MatchMenager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(MatchDto match1: matches){
            System.out.println(match1);
        }
    }
    
    
}
