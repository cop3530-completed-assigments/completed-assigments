

public class Stack<T> {
    private class StackNode {
        T data;
        StackNode next;

        public StackNode(T data) {
            this.data = data;
        }
    }
    
    private StackNode top;
    
    public Stack() {}
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public void push(T data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
    }
    
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        
        T data = top.data;
        top = top.next;
        return data;
    }
    
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        
        return top.data;
    }
    
    
}
