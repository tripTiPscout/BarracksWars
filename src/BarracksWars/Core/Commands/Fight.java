package BarracksWars.Core.Commands;

import BarracksWars.Interfaces.Executable;

public class Fight implements Executable {

    public Fight() {

    }

    @Override
    public String execute() {
        return "fight";
    }
}
