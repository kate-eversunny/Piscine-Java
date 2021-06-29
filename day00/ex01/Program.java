import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		if (in.hasNextInt()) {
			int n = in.nextInt();
			in.close();

			if (n <= 1) {
				System.err.println("Illegal argument");
				System.exit(-1);
			}
			else if (n == 2 || n == 3)
				System.out.println("true 1");
			else {
				int iter = 0;
				for (int div = 2; div * div <= n; div++, iter++)
					if ((n % div) == 0) {
						iter++;
						System.out.println("false " + iter);
						System.exit(0);
					}
				System.out.println("true " + iter);
			}
		}
		else
		{
			System.err.println("Illegal argument");
			System.exit(-1);
		}
	}
}
