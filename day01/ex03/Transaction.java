import java.util.UUID;

public class Transaction {

	private UUID identifier;
	private User recipient;
	private User sender;
	private Category transferCategory;
	private Integer	amount;

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";

	public Transaction(UUID id, User s, User r, Category tr, Integer am)
	{
		this.identifier = id;
		this.recipient = r;
		this.sender = s;
		this.transferCategory = tr;
		this.amount = am;
		if ((this.transferCategory == Category.DEBIT && am < 0) || (this.transferCategory == Category.CREDIT && am > 0)) {
			System.err.println(ANSI_RED + "Transaction failed: incorrect sum" + ANSI_RESET + "\n");
			return;
		}
		if ((this.amount >= 0 && this.sender.getBalance() < this.amount) || (this.amount < 0 && -this.sender.getBalance() > this.amount)) {
			System.err.println(ANSI_RED + "Transaction failed: insufficient funds" + ANSI_RESET + "\n");
			return;
		}
		changeBalance();
	}

	public UUID getIdentifier() {
		return this.identifier;
	}

	public User getRecipient() {
		return this.recipient;
	}

	public User getSender() {
		return this.sender;
	}
	
	public Category getTransferCategory() {
		return this.transferCategory;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setIdentifier(UUID val) {
		this.identifier = val;
	}

	public void setRecipient(User val) {
		this.recipient = val;
	}

	public void setSender(User val) {
		this.sender = val;
	}

	public void setTransferCategory(Category val) {
		this.transferCategory = val;

		if ((this.transferCategory == Category.DEBIT && this.amount < 0) || (this.transferCategory == Category.CREDIT && this.amount > 0)) {
			this.amount = -this.amount;
		}
	}

	public void setAmount(Integer val) {
		if ((this.transferCategory == Category.DEBIT && val < 0) || (this.transferCategory == Category.CREDIT && val > 0)) {
			this.amount = -val;
		} else {
			this.amount = val;
		}
	}

	private void changeBalance() {
		if (this.transferCategory == Category.CREDIT) {
			this.sender.setBalance(this.sender.getBalance() - this.amount);
			this.sender.getTransactionsList().addTransaction(this);
		} else {
			this.recipient.setBalance(this.recipient.getBalance() + this.amount);
			this.recipient.getTransactionsList().addTransaction(this);
		}
	}
}

enum Category {
	DEBIT,
	CREDIT
}