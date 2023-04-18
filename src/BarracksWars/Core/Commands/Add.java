package BarracksWars.Core.Commands;

import BarracksWars.Annotation.Inject;
import BarracksWars.Interfaces.Executable;
import BarracksWars.Interfaces.Repository;
import BarracksWars.Interfaces.Unit;
import BarracksWars.Interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Add implements Executable {

    @Inject
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public Add() {

    }

    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = this.data[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
