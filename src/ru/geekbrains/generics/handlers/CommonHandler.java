package ru.geekbrains.generics.handlers;

import ru.geekbrains.generics.entity.Developer;
import ru.geekbrains.generics.entity.LoggedEntity;
import ru.geekbrains.generics.entity.TeamLead;
import ru.geekbrains.generics.handlers.crisis.LeadCrisisHandler;
import ru.geekbrains.generics.repository.DeveloperRepository;
import ru.geekbrains.generics.repository.Repository;

import java.util.Collections;

public class CommonHandler {

    public static void main(String[] args) {
        Developer dimonDev = new Developer("Dimon", 100_000, "OpenSource");
        Developer promotedDeveloper = changeDeveloper(dimonDev);
        LoggedEntity<Developer> loggedDeveloper = new LoggedEntity<>(dimonDev, promotedDeveloper);
        System.out.println(loggedDeveloper);

        TeamLead teamLead = new TeamLead(
                "Sergei",
                "Sberbank",
                200_000,
                Collections.singletonList(promotedDeveloper)
        );

        TeamLead teamLeadWithIncreasedTeam = changeTeamLead(teamLead);
        LoggedEntity<TeamLead> loggedTeamLead = new LoggedEntity<>(teamLead, teamLeadWithIncreasedTeam);
        System.out.println(loggedTeamLead);
    }

    public static Developer changeDeveloper(Developer d) {
        return d.changeProject("Sberbank")
                .changeSalary(1.5);
    }

    public static TeamLead changeTeamLead(TeamLead teamLead) {
        return teamLead.hireDeveloper(new Developer("Anton", 100_000, "Sberbank"));
    }
}
