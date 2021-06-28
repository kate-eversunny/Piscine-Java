import java.util.Scanner;

public class Program {

	static int sum(int n){
		if (n < 10)
			return n;
		return (sum(n / 10) + n % 10);
	}

	static boolean isPrime(int n)
	{
		if (n == 0 || n == 1)
			return false;
		int i = 0;
		for (int div = 2; div * div <= n && i == 0; div++)
			if ((n % div) == 0)
				i++;
		if (i == 0)
			return true;
		return false;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = 0;
		int coffee = 0;

		while (true)
		{
			n = in.nextInt();
			if (n == 42)
				break;
			if (isPrime(sum(n)))
				coffee++;
		}
		in.close();
		System.out.println("Count of coffee-request - " + coffee);
	}
}
