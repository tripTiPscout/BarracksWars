package BarracksWars.Core.Commands;

import BarracksWars.Interfaces.Executable;
import BarracksWars.Interfaces.Repository;
import BarracksWars.Interfaces.UnitFactory;

public abstract class Command implements Executable {

    private final String[] data;
    private final Repository repository;
    private final UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return this.data;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getUnitFactory() {
        return this.unitFactory;
    }
}
