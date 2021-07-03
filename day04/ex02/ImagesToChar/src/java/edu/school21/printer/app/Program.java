package edu.school21.printer.app;

import edu.school21.printer.logic.*;
import java.io.*;
import com.beust.jcommander.*;
import com.beust.jcommander.Parameter;
import java.util.ArrayList;
import java.util.List;

public class Program {

	// @Parameter private List<String> parameters = new ArrayList<>();

	@Parameters(separators = "=")
	public static class SeparatorEqual {
		@Parameter(names = "--white", required = true)
		public static String white;

		@Parameter(names = "--black", required = true)
		public static String black;
	  }

	public static void main(String[] args) {

		if (args.length != 2) {
			System.err.println("Two arguments required, e.g. --white=GREEN --black=BLUE");
			return;
		}

		SeparatorEqual params = new SeparatorEqual();
		JCommander.newBuilder().addObject(params).build().parse(args);
		handle(params);
	}

	static void handle(SeparatorEqual params) {

		BmpHandler handler = new BmpHandler();
		try {
			handler.readBmpImage();
			handler.printImage(params.white, params.black);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
}

class IncorrectInputException extends IOException {
	public IncorrectInputException() {
		System.err.println("Incorrect input");
	}
}
