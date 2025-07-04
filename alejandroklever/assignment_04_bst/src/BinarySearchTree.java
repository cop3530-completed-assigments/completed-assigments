public class BinarySearchTree{
    BinaryNode root;

    public void treeInsert(int key) {
        BinaryNode targetNode = null;
        BinaryNode currentNode = root;

        while (currentNode != null) {
            targetNode = currentNode;
            if (key < currentNode.key) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        BinaryNode newNode = new BinaryNode(key, targetNode);

        if (root == null) {
            root = newNode;
        } else if (newNode.key < targetNode.key) {
            targetNode.left = newNode;
        } else {
            targetNode.right = newNode;
        }
    }
    
    public BinaryNode treeMinimum() {
        BinaryNode currentNode = root;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }
    
    public BinaryNode treeMaximum() {
        BinaryNode currentNode = root;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode;
    }
    
    public BinaryNode treeSearch(int key){
        return treeSearch(root, key);
    }
    
    private BinaryNode treeSearch(BinaryNode current, int key) {
        if (current == null || key == current.key) {
            return current;
        }
        
        if ( key <  current.key){
            return treeSearch(current.left, key);
        }
        
        return treeSearch(current.right, key);
    }
}