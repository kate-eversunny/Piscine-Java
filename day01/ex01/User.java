public class User {

	private final int IDENTIFIER;
	private String name;
	private Integer balance;
	
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";

	public User(String n, Integer b) {
		this.IDENTIFIER = UserIdsGenerator.getInstance().generateId();
		this.name = n;
		if (b > 0) {
			this.balance = b;
		} else {
			this.balance = 0;
			System.out.println("Error: Attempt to record negative balance");
		}
	}

	public Integer getIdentifier() {
		return this.IDENTIFIER;
	}

	public String getName() {
		return this.name;
	}

	public Integer getBalance() {
		return this.balance;
	}

	public void setName(String val) {
		this.name = val;
	}

	public void setBalance(Integer val) {
		if (val > 0) {
			this.balance = val;
		} else {
			this.balance = 0;
			System.out.println("Error: Attempt to record negative balance");
		}
	}

	public void printUserData() {
		System.out.println(ANSI_GREEN + "User " + this.IDENTIFIER + ":" + ANSI_RESET);
		System.out.println("NAME          " + this.name);
		System.out.println("BALANCE       " + this.balance + "\n");
	}
}
