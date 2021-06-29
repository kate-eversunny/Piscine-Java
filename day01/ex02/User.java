public class User {

	private final int identifier;
	private String name;
	private Integer balance;

	public User(String n, Integer b) {
		this.identifier = UserIdsGenerator.getInstance().generateId();
		this.name = n;
		if (b > 0)
			this.balance = b;
		else {
			this.balance = 0;
			System.out.println("Error: Attempt to record negative balance");
		}
	}

	public Integer getIdentifier() {
		return this.identifier;
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
		if (val > 0)
			this.balance = val;
		else {
			this.balance = 0;
			System.out.println("Error: Attempt to record negative balance");
		}
	}
}