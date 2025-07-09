public class HashMap<K, V> {
    private static final int DEFAULT_SIZE = 10;
    private int size;
    private Node<K, V>[] table;


    private class Node<K, V> {
        int key;
        int value;

        //peramatized constructor
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

        //copy constructor
        public Node(Node<K,V> node){
            this.key = node.key;
            this.value = node.value;
        }
    }

    //default constructor
    public HashMap(){
        this(DEFAULT_SIZE);
    }

    //peramitized constructor
    public HashMap(int size){
        this.size = size;
        this.table = (Node<K, V>[]) new Node[size];
    }

    //inserts a new key/value pair into the hashmap
    public void hashInsert(int value){
        int i, j;
        i = 0;

        do {
            //j = getLinearProbIndex(value, i);     //gets hash value Linearly
            //j = getQuadraticProbIndex(value, i);  //gets hash value Quadradicly
            j = getDoubleHash(value, i);            //gets hash value using Double Hash
            if (this.table[j] == null){
                Node<K, V> node = new Node<>(j,value);
                this.table[j] = node;
                return;
            }else {
                i++;
            }
        } while (i != size);
        System.out.println("ERROR: Hash table overflow!");
    }

    //Searches the table to find the given value
    public Node hashSearch(int value){
        int i, j;
        i = 0;

        do {
            j = getLinearProbIndex(value, i);
            if (this.table[j].value == value){
                Node<K, V> node = new Node<>(this.table[j]);
                return node;
            }else
                i++;
        } while (this.table[j] == null || i == size);
        return null;
    }

    //returns Linear hash index
    private int getLinearProbIndex(int value, int i){
        int index = hash(value) + i;
        return index;
    }

    //returns Quadadic hash index
    private int getQuadraticProbIndex(int value, int i){
        int index = hash(value) + (int)Math.pow(i, 2);
        return index;
    }

    //returns double hash index
    private int getDoubleHash(int value, int i){
        int index = (hash(value) + (i * hash2(value))) % this.size;
        return index;
    }

    //returns simple hash value
    private int hash(int value){
        int index = value % this.size;
        return index;
    }

    //returns secondary hash value
    private int hash2(int value){
        int index = 1 + (value % (this.size - 1));
        return index;
    }
}
