package ru.geekbrains.generics.handlers.crisis;

import ru.geekbrains.generics.entity.Developer;
import ru.geekbrains.generics.entity.TeamLead;
import ru.geekbrains.generics.repository.Repository;

public class LeadCrisisHandler extends AbstractCrisisHandler<TeamLead> {

    private Repository<Developer> repository;

    public LeadCrisisHandler(Repository<Developer> repository) {
        this.repository = repository;
    }

    @Override
    protected TeamLead handle(TeamLead employee) {
        Developer anton = repository.findByName("Anton");
        repository.delete(anton);
        return employee.fireDeveloper(anton);
    }
}
