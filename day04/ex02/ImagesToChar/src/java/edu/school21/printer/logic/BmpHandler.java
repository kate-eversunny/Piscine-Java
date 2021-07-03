package edu.school21.printer.logic;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.*;
import com.diogonunes.jcolor.*;
import com.diogonunes.jcolor.Attribute;
import java.util.HashMap;


public class BmpHandler {
	int[][] array2D = null;;

	public void readBmpImage() throws IOException {
		BufferedImage image = ImageIO.read(new File("./src/resources/image.bmp"));
		this.array2D = new int[image.getHeight()][image.getWidth()];
	
		for (int xPixel = 0; xPixel < image.getHeight(); xPixel++)
		{
			for (int yPixel = 0; yPixel < image.getWidth(); yPixel++)
			{
				int color = image.getRGB(yPixel, xPixel);
				if (color==Color.BLACK.getRGB()) {
					this.array2D[xPixel][yPixel] = 1;
				} else {
					this.array2D[xPixel][yPixel] = 0;
				}
			}
		}
	}

	public void printImage(String white, String black) {
		if (this.array2D == null) {
			System.err.println("Read image file first with BmpHandler::readBmpImage(String BmpFileName)");
			return;
		}

		HashMap<String, Integer> colors = new HashMap<>();
		colors.put("BLACK", 0);
		colors.put("RED", 1);
		colors.put("GREEN", 2);
		colors.put("YELLOW", 3);
		colors.put("BLUE", 4);
		colors.put("MAGENTA", 5);
		colors.put("CYAN", 6);
		colors.put("WHITE", 7);

		int first, second;

		try {
		first = colors.get(white);
		second = colors.get(black);
		} catch (NullPointerException e) {
			System.err.println("Only the next colors sipported: BLACK, RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN, WHITE");
			return;
		}


		for (int x = 0; x < array2D.length; x++) {
			for (int y = 0; y < array2D[x].length; y++) {
				if (array2D[x][y] == 0) {
					System.out.print(Ansi.colorize(" ", Attribute.BACK_COLOR(colors.get(white))));
				} else {
					System.out.print(Ansi.colorize(" ", Attribute.BACK_COLOR(colors.get(black))));
				}
			}
			System.out.println();
		}
	}	
}
