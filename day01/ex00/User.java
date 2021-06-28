public class User {

	private Integer identifier;
	private String name;
	private Integer balance;

	public User(Integer id, String n, Integer b) {
		this.identifier = id;
		this.name = n;
		if (b > 0)
			this.balance = b;
		else
			this.balance = 0;
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

	public void setIdentifier(Integer val) {
		this.identifier = val;
	}

	public void setName(String val) {
		this.name = val;
	}

	public void setBalance(Integer val) {
		if (val > 0)
			this.balance = val;
		else
			this.balance = 0;
	}
}