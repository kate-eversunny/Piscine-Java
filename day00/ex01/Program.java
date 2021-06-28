import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		in.next();
		int n = in.nextInt();
		in.close();

		if (n <= 1) {
			System.err.println("Illegal argument");
			System.exit(-1);
		}
		else if (n == 2 || n == 3)
			System.out.println("true 1");
		else {
			int limit = n;
			if (n > 100)
				limit = n / 10;
			int iter = 0;
			int i = 0;
			for (int div = 2; div < limit && i == 0; div++, iter++)
				if ((n % div) == 0)
					i++;

			if (i > 0)
				System.out.println("false " + iter);
			else
				System.out.println("true " + iter);
		}
	}
}
