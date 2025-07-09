public class BinaryTree <T>{

    public class Node<T>{
        private int data;
        private Node<T> left;
        private Node<T> right;
    }

    private Node<T> root;

    public BinaryTree(){
        root = null;
    }

    public void BSTInsert(int key){
        Node<T> z = new Node<>();
        Node<T> y = null;
        Node<T> x = this.root;

        z.data = key;

        while (x != null){
            y = x;
            if (z.data < x.data){
                x = x.left;
            }else {
                x = x.right;
            }
        }

        if (y == null){
            this.root = z;
        }else if (z.data < y.data){
            y.left = z;
        }else {
            y.right = z;
        }
    }

    public int TreeMinimum(){
        Node<T> x = this.root;

        while (x.left != null){
            x = x.left;
        }
        return x.data;
    }

    public int TreeMaximum(){
        Node<T> x = this.root;

        while (x.right != null){
            x = x.right;
        }
        return x.data;
    }

    public Node<T> TreeSearch(int key){
        return Search(this.root, key);
    }

    private Node<T> Search(Node<T> x, int key){
        if (x == null || key == x.data){
            return x;
        }
        if (key < x.data){
            return Search(x.left, key);
        }else {
            return Search(x.right, key);
        }
    }

    public String toString(){

        return "[" + preorderWalk(this.root) + "]";
    }

    private String preorderWalk(Node<T> x){
        String result = "";
        if (x != null){
            result += x.data + ", ";
            result += preorderWalk(x.left);
            result += preorderWalk(x.right);
        }
        return result;
    }
}
