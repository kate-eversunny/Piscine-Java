import java.util.UUID;

public class Program {

	public static void main(String[] args) {
	
		User user1 = new User("Nicolas Douvet", 3000);
		user1.printUserData();

		User user2 = new User("Roberto Cabaliero", 5000);
		user2.printUserData();

		Transaction tr1 = new Transaction(UUID.randomUUID(), user2, user1, Category.CREDIT, -2000);
		Transaction tr2 = new Transaction(tr1.getIdentifier(), user2, user1, Category.DEBIT, 2000);
		user1.printUserData();
		user1.printTransactionsList();
		user2.printUserData();
		user2.printTransactionsList();


		Transaction tr3 = new Transaction(UUID.randomUUID(), user1, user2, Category.DEBIT, 100);
		Transaction tr4 = new Transaction(tr3.getIdentifier(), user1, user2, Category.CREDIT, -100);
		user1.printUserData();
		user1.printTransactionsList();
		user2.printUserData();
		user2.printTransactionsList();

		Transaction tr5 = new Transaction(UUID.randomUUID(), user1, user2, Category.DEBIT, 1000000);
		Transaction tr6 = new Transaction(tr5.getIdentifier(), user1, user2, Category.CREDIT, 1000000);
		user1.printUserData();
		user1.printTransactionsList();
		user2.printUserData();
		user2.printTransactionsList();

		try {
			user1.getTransactionsList().removeTransaction(UUID.randomUUID());
		} catch (TransactionNotFoundException e) {
			System.out.println(e);
		}

		try {
			user1.getTransactionsList().removeTransaction(tr3.getIdentifier());
		} catch (TransactionNotFoundException e) {
			System.out.println(e);
		}
		user1.printUserData();
		user1.printTransactionsList();
		user2.printUserData();
		user2.printTransactionsList();
	}
}