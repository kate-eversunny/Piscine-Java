package edu.school21.printer.app;

import edu.school21.printer.logic.*;
import java.io.*;

public class Program {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.err.println("Two arguments required, e.g. --white=0 --black=.");
			return;
		}

		BmpHandler handler = new BmpHandler();
		try {
			char white = getValueStringFromInput(args[0], 0).charAt(0);
			char black = getValueStringFromInput(args[1], 1).charAt(0);
			handler.readBmpImage();
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
				|| (index == 1 && ! input.substring(0, i).equals("--black"))) {
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

