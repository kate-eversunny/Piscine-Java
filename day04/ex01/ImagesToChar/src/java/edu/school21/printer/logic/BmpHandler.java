package edu.school21.printer.logic;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.*;

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

	public void printImage(char white, char black) {
		if (this.array2D == null) {
			System.err.println("Read image file first with BmpHandler::readBmpImage(String BmpFileName)");
			return;
		}
		for (int x = 0; x < array2D.length; x++) {
			for (int y = 0; y < array2D[x].length; y++) {
				if (array2D[x][y] == 0) {
					System.out.print(white);
				} else {
					System.out.print(black);
				}
			}
			System.out.println();
		}
	}	
}
