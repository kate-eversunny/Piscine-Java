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

		for (int i = 0; i < count; i++) {
			System.out.println("Human");
		}
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

		EggThread egg = new EggThread(count);
		HenThread hen = new HenThread(count);
		egg.start();
		hen.start();
		try {
			egg.join();
			hen.join();
		} catch (InterruptedException e) {
			System.err.println("Thread execution is interrupted");
		}
	}
}

class IncorrectInputException extends Exception {
	public IncorrectInputException() {
		System.err.println("Incorrect input");
	}
}

class EggThread extends Thread {
	private int count = 0;

	public EggThread(int count) {
		this.count = count;
	}

	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println("Egg");
		}
	}
}

class HenThread extends Thread {
	private int count = 0;

	public HenThread(int count) {
		this.count = count;
	}

	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println("Hen");
		}
	}
}
