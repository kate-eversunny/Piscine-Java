public class Program {
	public static void main(String[] args) {
	
		User user1 = new User("Nicolas Douvet", 3000);
		User user2 = new User("Roberto Cabaliero", 5000);
		User user3 = new User("Rosalia Cabaliero", 100000);
		User user4 = new User("Nicola Douveto", 3000);
		User user5 = new User("Robert Cabalier", 5000);
		User user6 = new User("Rosali Cabalier", 100000);
		User user7 = new User("Nicolo Douvets", 3000);
		User user8 = new User("Roberta Cabaliera", 5000);
		User user9 = new User("Rosalio Cabaliera", 100000);
		User user10 = new User("Nicolaj Douvej", 3000);
		User user11 = new User("Robertoj Cabalieroj", 5000);
		User user12 = new User("Rosaliaj Cabalieroj", 100000);

		UsersArrayList users = new UsersArrayList();
		System.out.println("Number of users: " + users.getNumberOfUsers());
		try {
			System.out.println("User #0: " + users.getUserById(1).getName());
		} catch (UserNotFoundException e) {
			System.out.println(e);
		}
		try {
			System.out.println("User #0: " + users.getUserByIndex(0).getName());
		} catch (UserNotFoundException e) {
			System.out.println(e);
		}

		users.addUser(user1);
		users.addUser(user2);
		users.addUser(user3);
		users.addUser(user4);
		users.addUser(user5);
		users.addUser(user6);
		users.addUser(user7);
		users.addUser(user8);
		users.addUser(user9);
		users.addUser(user10);

		System.out.println("Number of users: " + users.getNumberOfUsers());
		users.addUser(user11);
		users.addUser(user12);

		System.out.println("Number of users: " + users.getNumberOfUsers());
		System.out.println("User #0: " + users.getUserById(1).getName());
		System.out.println("User #0: " + users.getUserByIndex(0).getName());

	}
}