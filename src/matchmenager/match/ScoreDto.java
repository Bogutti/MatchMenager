package matchmenager.match;

import java.util.UUID;

public class ScoreDto {

    private UUID id;
    private int guestPoints;
    private int hostPoints;

    public ScoreDto(UUID id, int hostPoints, int guestPoints) {
        this.id = id;
        this.hostPoints = hostPoints;
        this.guestPoints = guestPoints;
    }

    public ScoreDto() {
    }

    public UUID getId() {
        return id;
    }

    public int getHostPoints() {
        return hostPoints;
    }

    public int getGuestPoints() {
        return guestPoints;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setHostPoints(int hostPoints) {
        this.hostPoints = hostPoints;
    }

    public void setGuestPoints(int guestPoints) {
        this.guestPoints = guestPoints;
    }

}
