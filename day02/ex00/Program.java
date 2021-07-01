import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;


public class Program {

	static HashMap<ArrayList<Integer>, String> getSignaturesList() {

		Scanner in = null;
		try {
			in = new Scanner(new File("signatures.txt"));
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(-1);
		}

		HashMap<ArrayList<Integer>, String> signatures = new HashMap<>();
		Scanner line;
		String value;
		ArrayList<Integer> key;
		Integer temp;
		while (in.hasNext())
		{
			key = new ArrayList<>();
			value = in.next();
			value = value.substring(0, value.length() - 1);
			int i = 0;
			if (!in.hasNextLine()) {	
				System.err.println("Error in signatures.txt file");
				System.exit(-1);
			}
			line = new Scanner(in.nextLine());

			while (line.hasNext()) {
				temp = Integer.parseInt(line.next(), 16);
				key.add(temp);
			}
			line.close();
			signatures.put(key, value);
		}
		in.close();
		return signatures;
	}

	static void compareSignatures(HashMap<ArrayList<Integer>, String> signatures, String path) {

		try (InputStream file = new FileInputStream(new File(path)); FileWriter writer = new FileWriter("result.txt", true)) {

			ArrayList<Integer> fileSignature = new ArrayList<>();
			final int MAX_BYTE = 8;
			int readRes = 0;
			String str;
			Integer temp;
	
			for (int i = 0; i < MAX_BYTE; i++)
			{
				if ((readRes = file.read()) >= 0) {
					str = Integer.toHexString(readRes);
					temp = Integer.parseInt(str, 16);
					fileSignature.add(temp);
					if (signatures.containsKey(fileSignature)) {
						writer.write(signatures.get(fileSignature));
						writer.append('\n');
						writer.flush();
						writer.close();
						System.out.println("PROCESSED");
						file.close();
						return;
					}
				}
			}
			System.out.println("UNDEFINED");
			writer.close();
			file.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
	}

	public static void main(String[] args) {

		HashMap<ArrayList<Integer>, String> signatures = getSignaturesList();
		try (FileWriter writer = new FileWriter("result.txt", false)) {
			writer.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(-1);
		}

		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String path = in.nextLine();
			if (path.equals("42")) {
				return;
			}
			compareSignatures(signatures, path);
		}
	}
}