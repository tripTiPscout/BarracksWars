package BarracksWars.Core.Commands;

import BarracksWars.Annotation.Inject;
import BarracksWars.Interfaces.Executable;
import BarracksWars.Interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;

public class Retire implements Executable {

    @Inject
    private String[] data;
    @Inject
    private Repository repository;

    protected Retire() {

    }

    public Retire(String[] data, Repository repository) {
        this.data = data;
        this.repository = repository;
    }

    @Override
    public String execute() {
        String unitType = this.data[1];
        try {
            this.repository.removeUnit(unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
        return unitType + " retired!";
    }
}
