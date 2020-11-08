package ru.geekbrains.generics.handlers;

import ru.geekbrains.generics.entity.Developer;
import ru.geekbrains.generics.entity.LoggedEntity;
import ru.geekbrains.generics.entity.TeamLead;
import ru.geekbrains.generics.handlers.crisis.DeveloperCrisisHandler;
import ru.geekbrains.generics.handlers.crisis.LeadCrisisHandler;
import ru.geekbrains.generics.repository.DeveloperRepository;
import ru.geekbrains.generics.repository.Repository;

import java.util.Collections;
import java.util.List;

public class HandlerWithRepo {
    public static void main(String[] args) {
        Repository<Developer> developerRepository = new DeveloperRepository();
        developerRepository.save(new Developer("Dimon", 150_000, "Sberbank"));
        developerRepository.save(new Developer("Alex", 125_000, "Sberbank"));
        developerRepository.save(new Developer("Anton", 100_000, "Sberbank"));

        TeamLead teamLead = new TeamLead("Sergei", "Sberbank", 200_000, Collections.emptyList());
        teamLead = teamLead.hireDeveloper(developerRepository.findByName("Dimon"))
                .hireDeveloper(developerRepository.findByName("Alex"))
                .hireDeveloper(developerRepository.findByName("Anton"));
        DeveloperCrisisHandler developerCrisisHandler = new DeveloperCrisisHandler();
        System.out.println(developerCrisisHandler.handleEmployee(developerRepository.findByName("Anton")));
        LeadCrisisHandler handler = new LeadCrisisHandler(developerRepository);
        LoggedEntity<TeamLead> teamLeadLoggedEntity = handler.handleEmployee(teamLead);
        System.out.println(teamLeadLoggedEntity);
    }
}
