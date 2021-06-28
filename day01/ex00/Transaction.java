

public class Transaction {

	private UUID identifier;
	private User recipient;
	private User sender;
	private Category transferCategory;
	private Integer	amount;

	public Transaction(UUID id, User r, User s, Category tr, Integer am)
	{
		this.identifier = id;
		this.recipient = r;
		this.sender = s;
		this.transferCategory = tr;
		if ((this.transferCategory == DEBIT && am < 0) || (this.transferCategory == CREDIT && am > 0))
			this.amount = -am;
		else
			this.amount = am;
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

		if ((this.transferCategory == DEBIT && this->amount < 0) || (this.transferCategory == CREDIT && this->amount > 0))
			this.amount = -this->amount;
	}

	public void setAmount(Integer val) {
		if ((this.transferCategory == DEBIT && val < 0) || (this.transferCategory == CREDIT && val > 0))
			this.amount = -val;
		else
			this.amount = val;
	}

}

public enum Category {
	DEBIT,
	CREDIT
}