package BarracksWars.Core.Factories;

import BarracksWars.Interfaces.Unit;
import BarracksWars.Interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME = "BarracksWars.Models.Units.";

	@Override
	public Unit createUnit(String unitType) {
		Unit unit;

		try	{
			Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<?> constructor = clazz.getDeclaredConstructor();

			unit = (Unit) constructor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException
				 | IllegalAccessException | InvocationTargetException exception) {
			throw new IllegalStateException(exception);
		}

		return unit;
	}
}
