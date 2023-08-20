package task1n1Singleton;			//source1:https://www.youtube.com/watch?v=tSZn4wkBIu8
							//source2: https://www.youtube.com/watch?v=NZaXM67fxbs
import java.util.LinkedList;
import java.util.List;



public class UndoSingleton {

	private static UndoSingleton instance;	// default value is null
	private static String command;
	private static List<String> history = new LinkedList();
	

	private UndoSingleton() {}	//private constructor to allow access only within getinstance method
	

	public static UndoSingleton getInstance() {	
		UndoSingleton result = instance;
		if (result == null) {								//first null instance is to avoid multithreading issue, if instance exists already skips creation process below
			synchronized (UndoSingleton.class) {
				result = instance;
				if (result == null) {						//if instance is null, ie new, it will go within method
					instance = result = new UndoSingleton();
				}
			}
		}
		return result;
	}
	
	public static String lastCommand() {
		if (history.size() != 0) {
			return history.get(history.size() - 1);
			
		} else {
			return "There is nothing to remove.";
		}
	}
	
	public static void addCommand(String command) {
		history.add(command);
	}
	
	public static void removeCommand() {
		if (history.size() != 0) {			
			System.out.println("Removed: " + lastCommand());
			history.remove(lastCommand());
		} else {
			System.out.println("There is nothing to remove.");
		}
	}
	
	public static void printHistory() {
		if (history.size() != 0) {
			for (int i = history.size(); i > 0; i--) {
				System.out.println(history.get(i - 1));
			}
		} else {
			System.out.println("The history is empty.");
		}
	}

}
