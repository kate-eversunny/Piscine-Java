public class User {

	private final int IDENTIFIER;
	private String name;
	private Integer balance;
	private TransactionsList transactionsList;

	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";

	public User(String n, Integer b) {
		this.IDENTIFIER = UserIdsGenerator.getInstance().generateId();
		this.name = n;
		if (b > 0)
			this.balance = b;
		else {
			this.balance = 0;
			System.out.println("Error: Attempt to record negative balance");
		}
		this.transactionsList = new TransactionsLinkedList();
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
		if (val > 0)
			this.balance = val;
		else {
			this.balance = 0;
			System.out.println("Error: Attempt to record negative balance");
		}
	}

	public TransactionsList getTransactionsList() {
		return this.transactionsList;
	}

	public void printUserData() {
		System.out.println(ANSI_GREEN + "User " + this.IDENTIFIER + ":" + ANSI_RESET);
		System.out.println("NAME          " + this.name);
		System.out.println("BALANCE       " + this.balance + "\n");
	}
	public void printTransactionsList() {
		Transaction[] tmp = transactionsList.toArray();
		String category;
		System.out.println(ANSI_YELLOW + "Transactions (User " + this.IDENTIFIER + " " + this.name + "):" + ANSI_RESET);
		for (int i = 0; i < transactionsList.getSize(); i++) {
			category = tmp[i].getTransferCategory() == Category.DEBIT ? "debit" : "credit";
			System.out.print((i + 1) + ". ");
			System.out.print("ID = " + tmp[i].getIdentifier());
			System.out.print(" RECIPIENT = " + tmp[i].getRecipient().getName());
			System.out.print(" SENDER = " + tmp[i].getSender().getName());
			System.out.print(" TRANSACTION = " + category);
			System.out.println(" AMOUNT = " + tmp[i].getAmount());
		}
		System.out.print("\n");
	}
}