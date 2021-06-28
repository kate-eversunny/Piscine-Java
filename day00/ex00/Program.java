public class Program {

	static int bitness(int n) {
		int i = 1;

		while (n / 10 != 0) {
			n = n / 10;
			i++;
		}
		return i;
	}

	static int sum(int n){
		if (n < 10)
			return n;
		return (sum(n / 10) + n % 10);
	}

	public static void main(String[] args) {
		int n = 495789;
		if (n < 0)
			n = -n;
		if (bitness(n) != 6)
			System.out.println("Wrong number of digits");
		else
			System.out.println(sum(n));
	}
}
