import java.lang.Thread;

public class Program {
	
	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.err.println("One argument required, e.g. \"--count=50\"");
			return;
		}

		int count = 0;
		try {
			String countString = getCountStringFromInput(args[0]);
			count = calculateCount(countString);
		} catch (IncorrectInputException e) {
			return;
		}

		launchPrinting(count);
	}

	static String getCountStringFromInput(String input) throws IncorrectInputException {

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '=') {
				if (! input.substring(0, i).equals("--count")) {
					throw new IncorrectInputException();
				}
				return input.substring(++i);
			}
		}
		throw new IncorrectInputException();
	}

	static int calculateCount(String input) throws IncorrectInputException {
		try {
			int result = Integer.parseInt(input);
			if (result <= 0) {
				throw new IncorrectInputException();
			}
			return result;
		} catch (NumberFormatException e) {
			throw new IncorrectInputException();
		}
	}

	static void launchPrinting(int count) {

		Monitor monitor = new Monitor();
		EggThread egg = new EggThread(count, monitor);
		HenThread hen = new HenThread(count, monitor);
		egg.start();
		hen.start();
	}
}

class IncorrectInputException extends Exception {
	public IncorrectInputException() {
		System.err.println("Incorrect input");
	}
}

class Monitor {
	private boolean eggTurn = true;
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";

	public synchronized void eggPrint() {
		while (!eggTurn) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Egg");
		eggTurn = false;
		notify();
	}

	public synchronized void henPrint() {
		while (eggTurn) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(ANSI_YELLOW + "Hen" + ANSI_RESET);
		eggTurn = true;
		notify();
	}
}

class EggThread extends Thread {
	private int count = 0;
	private Monitor monitor;

	public EggThread(int count, Monitor monitor) {
		this.count = count;
		this.monitor = monitor;
	}

	public void run() {
		for (int i = 0; i < count; i++) {
			monitor.eggPrint();
		}
	}
}

class HenThread extends Thread {
	private int count = 0;
	private Monitor monitor;

	public HenThread(int count, Monitor monitor) {
		this.count = count;
		this.monitor = monitor;
	}

	public void run() {
		for (int i = 0; i < count; i++) {
			monitor.henPrint();
		}
	}
}
