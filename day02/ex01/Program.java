import java.io.*;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;
import java.lang.Math;


public class Program {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.err.println("Two arguments required");
		}

		TreeMap<String, Integer[]> dictionary = getWordsFromFiles(args);

		double res = calculateSimilarity(dictionary);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("dictionary"))) {
			Set<String> keySet = dictionary.keySet();
			for (String value : keySet) {
				writer.write(value + "\n");
			}
		}
        catch (IOException e) {
			System.err.println(e.getMessage());
		}
		System.out.printf("Similarity = " + (long)(res * 1e2)/1e2);

	}

	static TreeMap<String, Integer[]> getWordsFromFiles(String[] files) {

		TreeMap<String, Integer[]> dictionary = new TreeMap<>();

		for (int i = 0; i < files.length; i++) {
			try (Scanner in = new Scanner(new File(files[i]))) {
				while (in.hasNext()) {
					String str = in.next();
					if (dictionary.containsKey(str)) {
						Integer[] values = dictionary.get(str);
						values[i]++;
						dictionary.remove(str);
						dictionary.put(str, values);
					} else {
						Integer[] values = {0, 0};
						values[i] = 1;
						dictionary.put(str, values);
					}
				}
				in.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
				System.exit(-1);
			}
		}
		return dictionary;
	}

	static double calculateSimilarity(TreeMap<String, Integer[]> dictionary) {
		double numerator = 0;
		double denominator;
		double sum1 = 0;
		double sum2 = 0;

		for (Map.Entry<String,Integer[]> entry : dictionary.entrySet()) {
			String key = entry.getKey();
			numerator += dictionary.get(key)[0] *  dictionary.get(key)[1];
			sum1 += Math.pow(dictionary.get(key)[0], 2);
			sum2 += Math.pow(dictionary.get(key)[1], 2);
		}
		denominator = Math.sqrt(sum1) * Math.sqrt(sum2);
		return numerator/denominator;
	}
}