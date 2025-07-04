public class BinaryNode {
    public BinaryNode parent;
    public BinaryNode left;
    public BinaryNode right;
    public int key;

    public BinaryNode(int key) {
        this.key = key;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public BinaryNode(int key, BinaryNode parent) {
        this.key = key;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    public BinaryNode(int key, BinaryNode parent, BinaryNode left, BinaryNode right) {
        this.key = key;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}