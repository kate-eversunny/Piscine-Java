public class Program {
	public static void main(String[] args) {
	
		User user1 = new User("Nicolas Douvet", 3000);
		System.out.println("User: " + user1.getIdentifier() + " " + user1.getName() + ", balance = " + user1.getBalance());

		User user2 = new User("Roberto Cabaliero", 5000);
		System.out.println("User: " + user2.getIdentifier() + " " + user2.getName() + ", balance = " + user2.getBalance());

		System.out.println("LastId: " + UserIdsGenerator.getInstance().getLastId());

		User user3 = new User("Rosalia Cabaliero", 100000);
		System.out.println("User: " + user3.getIdentifier() + " " + user3.getName() + ", balance = " + user3.getBalance());

		System.out.println("LastId: " + UserIdsGenerator.getInstance().getLastId());
	}
}