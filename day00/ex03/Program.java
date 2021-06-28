import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int weeks = 0;
		int[] grades = new int[18];

		while (weeks <= 18)
		{
			in.next();
			String str = in.next();
			if (str.equals("42"))
				break;
			
			int i = in.nextInt();
			if (!str.equals("Week") || i != weeks + 1) {
				System.err.println("Illegal argument");
				System.exit(-1);
			}
			weeks = i;
			grades[weeks -1] = 9;

			in.next();
			for(i = 0; i < 5; i++)
			{
				int n = in.nextInt();
				if (n < grades[weeks - 1])
					grades[weeks -1] = n;
			}
		}
		in.close();
		for (int i = 0; i < weeks; i++)
		{
			System.out.printf("Week %d ", i + 1);
			for (int j = 0; j < grades[i]; j++)
				System.out.print("=");
			System.out.print(">\n");
		}
	}
}
