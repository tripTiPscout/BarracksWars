package BarracksWars.Core.Commands;

import BarracksWars.Annotation.Inject;
import BarracksWars.Interfaces.CommandInterpreter;
import BarracksWars.Interfaces.Executable;
import BarracksWars.Interfaces.Repository;
import BarracksWars.Interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandModel implements CommandInterpreter {

    private static final String COMMANDS_PACKAGE_NAME = "BarracksWars.Core.Commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandModel(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        Executable executable;

        commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);

        try {
            Class<?> clazz = Class.forName(COMMANDS_PACKAGE_NAME + commandName);

            Constructor<?> constructor = clazz.getDeclaredConstructor();

            executable = (Executable) constructor.newInstance();

            injectFields(executable, data);

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException
                 | InstantiationException | IllegalAccessException exception) {

            throw new RuntimeException(exception);
        }

        return executable;
    }

    private void injectFields(Executable executable, String[] data) {
        try {
            Field[] declaredFields = executable.getClass().getDeclaredFields();

            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                if (declaredField.isAnnotationPresent(Inject.class)) {
                    if (declaredField.getType().equals(String[].class)) {
                        declaredField.set(executable, data);
                    } else if (declaredField.getType().equals(Repository.class)) {
                        declaredField.set(executable, this.repository);
                    } else if (declaredField.getType().equals(UnitFactory.class)) {
                        declaredField.set(executable, this.unitFactory);
                    }
                }
            }
        } catch (Exception ignore) {

        }
    }
}
