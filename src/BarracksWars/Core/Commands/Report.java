package BarracksWars.Core.Commands;

import BarracksWars.Annotation.Inject;
import BarracksWars.Interfaces.Executable;
import BarracksWars.Interfaces.Repository;

public class Report implements Executable {

    @Inject
    private Repository repository;

    public Report() {

    }

    public Report(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
