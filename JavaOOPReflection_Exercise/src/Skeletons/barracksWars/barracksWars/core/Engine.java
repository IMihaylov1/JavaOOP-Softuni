package Skeletons.barracksWars.barracksWars.core;
import Skeletons.barracksWars.core.commands.Command;
import Skeletons.barracksWars.interfaces.Repository;
import Skeletons.barracksWars.interfaces.Unit;
import Skeletons.barracksWars.interfaces.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {
	private static final String PATH = "Skeletons.barracksWars.core.commands.";
	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName) {
		String result = "";
		commandName = commandName.substring(0, 1).toUpperCase()
				+ commandName.substring(1) + "Command";
		try {
			Class<?> command = Class.forName(PATH + commandName);
			Object object = command.
					getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class).
					newInstance(data, repository, unitFactory);
			Command cmd = (Command) object;
			Method execute = command.getDeclaredMethod("execute");
			result = execute.invoke(cmd).toString();
		} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}


}
