package matchmenager.team;

import java.util.List;
import java.util.UUID;

public class TeamDto {//data transfer object
   
    private UUID id;
    private String name;
    private List<String> teamMembers;

    public TeamDto(UUID id, String name, List<String> teamMembers) {
        this.id = id;
        this.name = name;
        this.teamMembers = teamMembers;
    }
    
    public TeamDto(){}
    
    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeamMembers(List<String> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getTeamMembers() {
        return teamMembers;
    }
}
