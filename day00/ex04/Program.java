import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		short[] letters = new short[65536];
		String str = in.nextLine();
		char[] arr = str.toCharArray();

		for(int i = 0; i < str.length(); i++) {
			letters[arr[i]]++;
		}

		for (int i = 0; i < 65536; i++) {
			if (letters[i] != 0)
				System.out.println(letters[i] + " \"" + (char)i +  "\"");
		}
	}
}
