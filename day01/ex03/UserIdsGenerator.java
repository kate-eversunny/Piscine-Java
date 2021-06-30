
public class UserIdsGenerator {
	private int lastId = 0;
	private static UserIdsGenerator gen = new UserIdsGenerator();
	private UserIdsGenerator() {}

	public static UserIdsGenerator getInstance() {
		return gen;
	}
	public int generateId() {
		return ++lastId;
	}
	public int getLastId() {
		return lastId;
	}
}