package BarracksWars;

import BarracksWars.Core.Commands.CommandModel;
import BarracksWars.Core.Engine;
import BarracksWars.Core.Factories.UnitFactoryImpl;
import BarracksWars.Data.UnitRepository;
import BarracksWars.Interfaces.CommandInterpreter;
import BarracksWars.Interfaces.Repository;
import BarracksWars.Interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandModel(repository, unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
