import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
	private Node head;
	private Node last;
	private int size;

	private class Node {
		private Node prev;
		private Node next;
		private Transaction data;

		public Node(Node prev, Node next, Transaction data) {
			this.prev = prev;
			this.next = next;
			this.data = data;
		}
	}

	public TransactionsLinkedList() {
		this.head = null;
		this.last = this.head;
		this.size = 0;
	}

	@Override
	public void addTransaction(Transaction tr) {
		Node newNode = new Node(this.last, null, tr);
		if (this.head == null) {
			this.head = newNode;
		} else {
			this.last.next = newNode;
		}
		this.last = newNode;
		this.size++;
	}

	@Override
	public void removeTransaction(UUID id) throws TransactionNotFoundException {
		Node temp = this.head;
		for (; temp != null; temp = temp.next) {
			if (temp != null && temp.data.getIdentifier() == id) {
				if (temp.prev != null && temp.prev.next != null) {
					temp.prev.next = temp.next;
				}
				if (temp.next != null &&  temp.next.prev != null) {
					temp.next.prev = temp.prev;
				}
				if (temp == this.head) {
					this.head = temp.next;
				}
				if (temp == this.last) {
					this.last = temp.prev;
				}
				temp = null;
				this.size--;
				return;
			}
		}
		throw new TransactionNotFoundException();
	}

	@Override
	public Transaction[] toArray() {
		Transaction[] arr = new Transaction[this.size];
		Node temp = this.head;
		for (int i = 0; temp != null && i < this.size; temp = temp.next, i++) {
			if (temp != null) {
				arr[i] = temp.data;
			}
		}
		return arr;
	}

	@Override
	public int getSize() {
		return this.size;
	}
}
class TransactionNotFoundException extends IndexOutOfBoundsException {
	public TransactionNotFoundException() {
		System.err.println("Transaction not found");
	}
}