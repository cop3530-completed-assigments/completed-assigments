import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMap {
    private final Integer[] hashMap;
    private final int capacity;
    private int size;
    private final HashType hashType;

    public HashMap() {
        this.hashMap = new Integer[100];
        this.capacity = 100;
        this.size = 0;
        this.hashType = HashType.linear;
    }

    public HashMap(HashType hashType) {
        this.hashMap = new Integer[100];
        this.capacity = 100;
        this.size = 0;
        this.hashType = hashType;
    }

    public HashMap(int capacity) {
        this.hashMap = new Integer[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.hashType = HashType.linear;
    }

    public HashMap(int capacity, HashType hashType) {
        this.hashMap = new Integer[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.hashType = hashType;
    }
    
    public int size() {
        return this.size;
    }
    
    public int capacity() {
        return this.capacity;
    }

    public void hashInsert(int value) {
        int i = 0;

        do {
            int j = hash(value, i);

            if (hashMap[j] == null) {
                hashMap[j] = value;
                size++;
                return;
            }

            if (hashMap[j] == value) {
                return;
            }

            i++;
        } while (i < this.capacity);

        throw new IllegalArgumentException("Hash Table Overflow");
    }

    public Integer hashSearch(int value) {
        int i = 0;

        do {
            int j = hash(value, i);

            if (hashMap[j] == null) {
                return null;
            }

            if (hashMap[j] == value) {
                return j;
            }

            i++;
        } while (i < this.capacity);

        return null;
    }

    public boolean contains(int value) {
        return hashSearch(value) != null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        AtomicInteger count = new AtomicInteger();
        Arrays.stream(hashMap).filter(Objects::nonNull).forEach((x) -> {

            sb.append(x);

            if (count.get() < this.size - 1) {
                sb.append(", ");
            }

            count.getAndIncrement();
        });


        return sb.append("]").toString();
    }
    
    private int hash(int key, int i) {
        return switch (hashType) {
            case linear -> Hashes.getLinearProbIndex(key, i, capacity);
            case quadratic -> Hashes.getQuadraticProbIndex(key, i, capacity);
            case doubleHash -> Hashes.getDoubleHash(key, i, capacity);
        };
    }
}

