
public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.BSTInsert(15);
        tree.BSTInsert(6);
        tree.BSTInsert(18);
        tree.BSTInsert(3);
        tree.BSTInsert(2);
        tree.BSTInsert(4);
        tree.BSTInsert(7);
        tree.BSTInsert(13);
        tree.BSTInsert(9);
        tree.BSTInsert(17);
        tree.BSTInsert(20);

        System.out.println(tree);
        System.out.println(tree.TreeMinimum());
        System.out.println(tree.TreeMaximum());
        System.out.println(tree.TreeSearch(7));
        System.out.println(tree.TreeSearch(30));

    }
}
