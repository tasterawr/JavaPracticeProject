package org.inversion_of_control;

import java.util.List;

public class Team {
    private TeamLead teamLead;
    private List<TeamWorker> workers;

    public TeamLead getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(TeamLead teamLead) {
        this.teamLead = teamLead;
    }

    public List<TeamWorker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<TeamWorker> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "Team:" +
                "\n-------------------------------" +
                "\nTeamLead: " + teamLead +
                "\nWorkers:" + workers;
    }
}
