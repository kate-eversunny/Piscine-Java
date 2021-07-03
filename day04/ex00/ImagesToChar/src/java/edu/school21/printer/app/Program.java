package edu.school21.printer.app;

import edu.school21.printer.logic.*;
import java.io.*;

public class Program {

	public static void main(String[] args) {

		if (args.length != 3) {
			System.err.println("Three arguments required, e.g. --white=0 --black=. --filePath=it.bmp");
			return;
		}

		BmpHandler handler = new BmpHandler();
		try {
			char white = getValueStringFromInput(args[0], 0).charAt(0);
			char black = getValueStringFromInput(args[1], 1).charAt(0);
			String fileName = getValueStringFromInput(args[2], 2);
			handler.readBmpImage(fileName);
			handler.printImage(white, black);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

	static String getValueStringFromInput(String input, int index) throws IncorrectInputException {

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '=') {
				if ((index == 0 && !input.substring(0, i).equals("--white"))
				|| (index == 1 && ! input.substring(0, i).equals("--black"))
				|| (index == 2 && ! input.substring(0, i).equals("--filePath"))) {
					throw new IncorrectInputException();
				}
				return input.substring(++i);
			}
		}
		throw new IncorrectInputException();
	}
	
}

class IncorrectInputException extends IOException {
	public IncorrectInputException() {
		System.err.println("Incorrect input");
	}
}
