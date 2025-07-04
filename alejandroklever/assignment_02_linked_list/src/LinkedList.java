public class LinkedList <T>{
	
	static private class Node<T>{
		private T data;
		private Node<T> next;
		private Node() {
			data = null;
			next = null;
		}
	}
	private int size;
	private Node<T> head;
	
	public LinkedList() {
		size = 0;
		head = null;
	}
	
	public LinkedList(T[] values) {
		size = 0;
		head = null;
        for (T value : values) {
            add(value);
        }
	}
	
	public void addFirst(T data) {
		insert(0,data);
	}
	
	public void addLast(T data) {
		insert(size,data);
	}
	
	public void add(T data) {
		addLast(data);
	}
	
	public void insert(int index, T data) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		Node<T> newNode = new Node<>();
		newNode.data = data;
		if(index == 0) {
			newNode.next = head;
			head = newNode;
			size ++;
			return;
		}
		Node<T> temp = head;
		for(int i=0; i<index-1; i++)
			temp = temp.next;
		newNode.next = temp.next;
		temp.next =  newNode;
		size++;
	}
	
	public void remove(int index) {
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		if(index == 0) {
			head = head.next;
			size--;
			return;
		}
		Node<T> temp = head;
		for(int i=0; i<index-1; i++)
			temp = temp.next;
		Node<T> temp2 = temp.next;
		temp.next = temp2.next;
		size--;
	}
	
	public void removeFirst() {
		remove(0);
	}
	public void removeLast() {
		remove(size-1);
	}
	public void remove() {
		removeLast();
	}
	
	public int size() {
		return size;
	}
	
	public T get(int index) {
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		Node<T> temp = head;
		for(int i=0; i<index; i++)
			temp = temp.next;
		return temp.data;
	}
	
	public T getFirst() {
		return get(0);
	}
	public T getLast() {
		return get(size-1);
	}
	
	public void set(int index, T data) {
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		Node<T> temp = head;
		for(int i=0; i<index; i++)
			temp = temp.next;
		temp.data = data;
	}
	
	public void clear() {
		head = null;
		size = 0;
	}
	
	public boolean contains(T data) {
		Node<T> temp = head;
		for(int i=0; i<size; i++) {
			if(temp.data.equals(data))
				return true;
			temp = temp.next;
		}
	return false;	
	}
	
	public String toString() {
		String str = "[";
		if(head == null)
			return str + "]";
		Node<T> temp = head;
		while(temp.next != null) {
			str = str + temp.data + ", ";
			temp = temp.next;
		}
		str = str + temp.data + "]";
		return str;
	}
	
	public void reverse() {
		if (size == 0) return ;
		
		Node<T> prev = head;
		Node<T> current = head.next;
		
		prev.next = null;
		
		while (current != null) {
			Node<T> next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		head = prev;
	}
	
	public LinkedList<T> reversedList() {
		LinkedList<T> list = new LinkedList<>();
		list.head = new Node<>();
		lis

		Node<T> listCurrent = list.head;
		Node<T> current = this.head;
		for (int s = 0; s < size; s++) {
			list.head = current;
			current = current.next;
		}
		
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		if (this.getClass() != o.getClass()) return false;
		LinkedList<T> otherList = (LinkedList<T>) o;
		if (this.size != otherList.size) return false;
		
		Node<T> head1 = this.head;
		Node<T> head2 = otherList.head;
		while (head1 != null && head2 != null) {
			if (head1.data != head2.data) return false;
			head1 = head1.next;
			head2 = head2.next;
		}
		
		return true;
	}
}
