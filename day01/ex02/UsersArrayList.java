public class UsersArrayList implements UsersList {
	User[] users = new User[10];
	int	size = 0;
	int capacity = 10;

	public void addUser(User user) {
		if (this.size == this.capacity) {
			this.capacity *= 2;
			User[] temp = new User[this.capacity];
			for (int i = 0; i < this.size; i++)
				temp[i] = this.users[i];
		 	this.users = temp;
		}
		this.users[this.size] = user;
		this.size++;
	}
	
	public User getUserById(int id) throws UserNotFoundException {
		for (int i = 0; i < this.size; i++)
			if (this.users[i].getIdentifier() == id)
				return this.users[i];
		throw new UserNotFoundException();
	}

	public User getUserByIndex(int index) throws UserNotFoundException {
		if (index < this.size)
			return this.users[index];
		throw new UserNotFoundException();
	}

	public int getNumberOfUsers() {
		return this.size;
	}
}

class UserNotFoundException extends ArrayIndexOutOfBoundsException {
	public UserNotFoundException() {
		System.err.println("User not found");
	}
}