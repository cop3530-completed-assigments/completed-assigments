public class Stack <T> {

    private class Node<T> {
        private T data;
        private Node<T> next;
    }

    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(T data){
        Node<T> node = new Node<>();
        node.data = data;
        node.next = top;
        top = node;
        size++;
    }

    public T pop(){
        if (top == null)
            throw new IndexOutOfBoundsException("Stack is empty.");
        T data = top.data;
        top = top.next;
        size--;

        return data;
    }

    public T peek(){
        if (top == null)
            throw new IndexOutOfBoundsException("Stack is empty.");

        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public String toString(){
        String str = "[";
        Node<T> temp = top;
        while (temp.next != null) {
            str = str + temp.data + ", ";
            temp = temp.next;
        }

        str = str + temp.data + "]";
        return str;
    }
}
