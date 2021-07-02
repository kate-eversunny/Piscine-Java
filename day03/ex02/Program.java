import java.lang.Thread;
import java.lang.Math;

public class Program {
	
	public static void main(String[] args) {
		
		if (args.length != 2) {
			System.err.println("Two arguments required, e.g. \"--arraySize=13 --threadsCount=3\"");
			return;
		}

		int arraySize = 0;
		int threadsCount = 0;
		try {
			arraySize = calculateCount(getStringFromInput(args[0]));
			threadsCount = calculateCount(getStringFromInput(args[1]));
			if (arraySize > 2000000 || threadsCount > arraySize)
				throw new IncorrectInputException();
		} catch (IncorrectInputException e) {
			return;
		}

		launchCalculation(arraySize, threadsCount);
		return;
	}

	static String getStringFromInput(String input) throws IncorrectInputException {

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '=') {
				if (! input.substring(0, i).equals("--arraySize") && ! input.substring(0, i).equals("--threadsCount")) {
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

	static void launchCalculation(int arraySize, int threadsCount) {

		int[] array = createArray(arraySize);
		calculateDirectly(array);
		long[] resultsFromThreads = calculateInThreads(threadsCount, array);

		long result = 0;
		for (int i = 0; i < threadsCount; i++) {
			result += resultsFromThreads[i];
		}
		System.out.println("\nSum by threads: " + result);

	}

	static int[] createArray(int arraySize) {

		final int MAX_VALUE = 1000000;
		int[] array = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			array[i] = (int)(Math.random() * MAX_VALUE);
		}
		return array;
	}

	static long calculateDirectly(int[] array) {

		long firstResult = 0;
		for (int i = 0; i < array.length; i++) {
			firstResult += array[i];
		}
		System.out.println("Sum: " + firstResult + "\n");
		return firstResult;
	}

	static long[] calculateInThreads(int threadsCount, int[] array) {

		SumThread[] threads = new SumThread[threadsCount];
		long[] results = new long[threadsCount];
		int range = array.length / threadsCount;
		int begin = 0;
		int end = 0;

		for (int i = 0; i < threadsCount; i++, begin = end) {
			end = begin + range;
			if (i + 1 == threadsCount) {
				end = array.length;
			}
			threads[i] = new SumThread(array, begin, end, results, i);
			threads[i].start();
		}
		waitForAllThreads(threads);
		return results;
	}

	static void waitForAllThreads(SumThread[] threads) {

		try {
			for (int i = 0; i < threads.length; i++) {
				threads[i].join();
			}
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

class SumThread extends Thread {
	private int begin = 0;
	private int end = 0;
	private int[] array;
	private long[] results;
	private int index;

	public SumThread(int[] arr, int begin, int end, long[] results, int index) {
		this.array = arr;
		this.begin = begin;
		this.end = end;
		this.results = results;
		this.index = index;
	}

	public void run() {
		this.results[this.index] = 0;
		for (int i = this.begin; i < this.end; i++) {
			this.results[this.index] += array[i];
		}
		System.out.println("Thread " + (this.index + 1) + ": from " + this.begin + " to " + (this.end - 1) + " sum is " + this.results[this.index]);
	}
}
