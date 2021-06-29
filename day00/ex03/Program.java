import java.util.Scanner;

public class Program {

	static void illegal() {
		System.err.println("Illegal argument");
		System.exit(-1);
	}

	static int bitness(long n) {
		int i = 1;

		while (n / 10 != 0) {
			n = n / 10;
			i++;
		}
		return i;
	}

	static long power(long grades) {
		long power = 1;
		for (int j = 1; j < bitness(grades); j++)
			power *= 10;
		return power;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int weeks = 0;
		long grades = 0;
		int grade;

		while (weeks <= 18)
		{
			String str = in.next();
			if (str.equals("42"))
				break;
			
			if (!str.equals("Week") || !in.hasNextInt())
				illegal();
			int i = in.nextInt();
			if (i != weeks + 1)
				illegal();
			weeks = i;
			grade = 9;

			for(i = 0; i < 5; i++)
			{
				if (!in.hasNextInt())
					illegal();
				int n = in.nextInt();
				if (n < 1 || n > 9)
					illegal();
				if (n < grade)
					grade = n;
			}
			grades *= 10;
			grades += grade;
		}
		in.close();
		for (int i = 0; i < weeks; i++)
		{
			System.out.printf("Week %d ", i + 1);
			long power = power(grades);
			grade = (int)(grades / power);
			grades -= grade * power;

			for (int j = 0; j < grade; j++)
				System.out.print("=");
			System.out.print(">\n");
		}
	}
}
