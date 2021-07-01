import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;


public class Program {

	public static void main(String[] args) {
		Scanner sig;
		OutputStream res;
		Scanner line;

		try {
			sig = new Scanner(new File("signatures.txt"));
		} catch (FileNotFoundException e) {
			System.err.println(e);
			return;
		}

		HashMap<ArrayList<BigInteger>, String> signatures = new HashMap<>();
		String value;
		ArrayList<BigInteger> key;
		BigInteger temp;
		while (sig.hasNext())
		{
			key = new ArrayList<>();
			value = sig.next();
			temp = new BigInteger("0", 16);
			int i = 0;
			if (!sig.hasNextLine()) {	
				break;
			}
			line = new Scanner(sig.nextLine());

			while (line.hasNext()) {
				temp = new BigInteger(line.next(), 16);
				key.add(temp);
			}
			line.close();
			signatures.put(key, value);
		}
		sig.close();

		// int i = 0;
		// while ((i = sig.read()) >= 0) {
		// 	StringBuilder str = new StringBuilder();

		// 	while ((char)i != ' ') {
		// 		str.append((char)i);
		// 	}

		// 	signatures.put(, str);
		// }

		try {
			res = new FileOutputStream(new File("result.txt"));
		} catch (FileNotFoundException e) {
			System.err.println(e);
			return;
		}

	}
}