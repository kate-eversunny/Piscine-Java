import java.util.UUID;

public class Program {
	public static void main(String[] args) {
	
		User user1 = new User(356, "Nicolas Douvet", 3000);
		user1.printUserData();

		user1.setBalance(-3000);
		user1.setIdentifier(500);
		user1.setName("Amanda Douvet");
		user1.printUserData();

		User user2 = new User(300, "Roberto Cabaliero", 5000);
		user2.printUserData();

		Transaction tr1 = new Transaction(UUID.randomUUID(), user2, user1, Category.CREDIT, 2000);
		System.out.println(tr1.getSender().getName() + " -> " + tr1.getRecipient().getName() + ", " + tr1.getAmount() + ", OUTCOME, transaction " + tr1.getIdentifier());

		tr1.setIdentifier(UUID.randomUUID());
		tr1.setSender(user1);
		tr1.setRecipient(user2);
		tr1.setTransferCategory(Category.DEBIT);
		tr1.setAmount(-2000);
		System.out.println(tr1.getSender().getName() + " -> " + tr1.getRecipient().getName() + ", +" + tr1.getAmount() + ", INCOME, transaction " + tr1.getIdentifier());
		
	}
}