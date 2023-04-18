package BarracksWars.Interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
