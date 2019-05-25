package matchmenager.match;

import java.time.LocalDateTime;
import java.util.UUID;

public class MatchDto {
    
    private UUID id;
    private UUID hostId;
    private UUID guestId;
    private LocalDateTime matchDate;
    private UUID scoreId;
    private Double ticketPrice;
    private String matchPlace;

    public MatchDto(UUID id, UUID hostId, UUID guestId, LocalDateTime matchDate, UUID scoreId, Double ticketPrice, String matchPlace) {
        this.id = id;
        this.hostId = hostId;
        this.guestId = guestId;
        this.matchDate = matchDate;
        this.scoreId = scoreId;
        this.ticketPrice = ticketPrice;
        this.matchPlace = matchPlace;
    }
    public MatchDto(){}

    public UUID getId() {
        return id;
    }

    public UUID getHostId() {
        return hostId;
    }

    public UUID getGuestId() {
        return guestId;
    }

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public UUID getScoreId() {
        return scoreId;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public String getMatchPlace() {
        return matchPlace;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setHostId(UUID hostId) {
        this.hostId = hostId;
    }

    public void setGuestId(UUID guestId) {
        this.guestId = guestId;
    }

    public void setMatchDate(LocalDateTime matchDate) {
        this.matchDate = matchDate;
    }

    public void setScoreId(UUID scoreId) {
        this.scoreId = scoreId;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setMatchPlace(String matchPlace) {
        this.matchPlace = matchPlace;
    }
    
    
    
    
    
    
    
    
}
