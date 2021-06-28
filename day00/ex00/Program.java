public class Program {

	public static void main(String[] args) {
		int n = 495789;
		int res = 0;

		res += n % 10;
		n = n / 10;
		res += n % 10;
		n = n / 10;
		res += n % 10;
		n = n / 10;
		res += n % 10;
		n = n / 10;
		res += n % 10;
		n = n / 10;
		res += n;

		System.out.println(res);
	}
}
