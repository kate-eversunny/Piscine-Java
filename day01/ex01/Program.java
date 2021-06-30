public class Program {
	public static void main(String[] args) {
	
		User user1 = new User("Nicolas Douvet", 3000);
		user1.printUserData();

		User user2 = new User("Roberto Cabaliero", 5000);
		user2.printUserData();

		System.out.println("LastId: " + UserIdsGenerator.getInstance().getLastId());

		User user3 = new User("Rosalia Cabaliero", 100000);
		user3.printUserData();

		System.out.println("LastId: " + UserIdsGenerator.getInstance().getLastId());
	}
}