import java.util.UUID;

interface TransactionsList {
	void addTransaction(Transaction tr);

	void removeTransaction(UUID id);

	Transaction[] toArray();

	int getSize();
}