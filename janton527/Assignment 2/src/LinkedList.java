public class LinkedList <T> {
    private static class Node<T> {
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

    public void addFirst(T data) {
        insert(0, data);
    }

    public void addLast(T data) {

            insert(size, data);

    }

    public void add(T data) {
        addLast(data);
    }

    public void insert(int index, T data) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node<T> newNode = new Node<>();
        newNode.data = data;
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++)
            temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++)
            temp = temp.next;
        Node<T> temp2 = temp.next;
        temp.next = temp2.next;
        size--;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void remove() {
        removeLast();
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<T> temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;
        return temp.data;
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    public void set(int index, T data) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<T> temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;
        temp.data = data;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean contains(T data) {
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data.equals(data))
                return true;
            temp = temp.next;
        }
        return false;
    }

    public void reverse(){
        Node<T> prev = null;
        Node<T> curr = head;

        while (curr != null){
            Node<T> nextElem = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextElem;
        }
        head = prev;
    }

    public static LinkedList<Integer> sumLists(LinkedList<Integer> list1, LinkedList<Integer> list2){
        LinkedList<Integer> result = new LinkedList<>();

        Node<Integer> temp1 = (Node<Integer>) list1.head;
        Node<Integer> temp2 = (Node<Integer>) list2.head;

        while (temp1 != null || temp2 != null){
            result.add(temp1.data + temp2.data);

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        Node<Integer> curr = result.head;
        Node<Integer> next = curr.next;

        while (curr != null){
            if (curr.data >= 10 && next == null) {
                curr.data = curr.data % 10;
                result.add(1);

                curr = curr.next;
            }else if (curr.data >= 10){
                curr.data = curr.data % 10;
                next.data++;

                curr = curr.next;
                next = next.next;
            }else if (curr.data < 10 && next == null){
                curr = curr.next;
            }else {
                curr = curr.next;
                next = next.next;
            }
        }

        return result;
    }

    public String toString() {
        String str = "[";
        if (head == null)
            return str + "]";
        Node<T> temp = head;
        while (temp.next != null) {
            str = str + temp.data + ", ";
            temp = temp.next;
        }
        str = str + temp.data + "]";
        return str;
    }
}