package org.inversion_of_control;

import java.util.List;

public class TeamConfig {
    @Bean(name = "team")
    @Prototype
    public static Team getTeam(TeamLead teamLead, List<TeamWorker> workers){
        Team team = new Team();
        team.setTeamLead(teamLead);
        team.setWorkers(workers);
        return team;
    }
}
