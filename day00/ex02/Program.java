import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = 0;
		int coffee = 0;

		while (n != 42)
		{
			in.next();
			n = in.nextInt();

			int i = 0;
			for (int div = 2; div < n && i == 0; div++)
				if ((n % div) == 0)
					i++;
			if (i == 0)
				coffee++;
		}
		in.close();
		System.out.println("   Count of coffee-request - " + coffee);
	}
}
