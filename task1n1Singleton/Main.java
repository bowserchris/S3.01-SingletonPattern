package task1n1Singleton;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		start();
		
	}
	
	static String inputString(String message) {				//request a string input
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		return input.nextLine();
	}
	
	public static void start() {
		UndoSingleton.getInstance();
		menu();
	}
	
	public static void menu() {
		
		boolean exitProgram = false;
		String userInput;
		
		do {
			userInput = inputString("What would you like to do next?:\r"
					+ "1.) Add a command\r"
					+ "2.) Remove a command\r"
					+ "3.) Show last command\r"
					+ "4.) Print History of commands (in reverse order)\r"
					+ "5.) Exit the program");
			
			switch(userInput) {
				case "1", "add":
					UndoSingleton.addCommand(inputString("What would you like to do?"));
					System.out.println();
					break;
				case "2", "remove":
					UndoSingleton.removeCommand();
					break;
				case "3", "show":
					System.out.println(UndoSingleton.lastCommand());
					break;
				case "4", "print", "history":
					UndoSingleton.printHistory();
					break;
				case "5", "exit":
					exitProgram = true;
					break;
				default: 
					System.out.println("Sorry. That´s not one of the options. Try again.\r");
			}
			
			
		} while (!exitProgram);
		
		System.out.println("Program terminated.");
	}
	
}
/*
 * In this practice we will learn to identify and build programs using design patterns. 
 * The use of patterns is fundamental in the construction of extensible and reusable software.
 *  The Java language, as well as all software frameworks, are made according to the most important 
 *  software patterns.
 *  
 *  
Level 1

In all exercises, create a project with a Main class that demonstrates the use of the pattern 
(with the necessary invocations).
Singleton

Create a class that replicates the operation of the 'Undo' command. This class will be used 
by the Main class, which will allow entering options by console.

    The 'Undo' class must save the last commands entered. It should allow adding or removing 
    commands, as well as listing the last commands entered (similar to the 'history' command 
    in Linux).
    The 'Undo' class must implement a Singleton pattern.



Level 2
Abstract Factory

Create a small manager of international phone numbers and addresses.

    The application must allow international addresses and phone numbers to be added to the 
    address book. Taking into account the different formats of different countries, it builds
     the phone book, addresses and phones by implementing an Abstract Factory pattern.



Level 3
Command

Design a parking lot of 4 vehicles: a car, a bicycle, a plane and a boat.

It shows how the Command pattern works that implements the start, accelerate, and brake methods
 for each vehicle type.
 * 
 * 
 * 
 * */
