public class Hashes {
    public static int getLinearProbIndex(int key, int i, int mod) {
        return (h1(key, mod) + i) % mod;
    }

    public static int getQuadraticProbIndex(int key, int i, int mod) {
        return (h1(key, mod) + (int) Math.floor(Math.pow(i, 2))) % mod;
    }

    public static int getDoubleHash(int key, int i, int mod) {
        return (h1(key, mod) + i * h2(key, mod)) % mod;
    }

    private static int h1(int key, int mod) {
        return key % mod;
    }

    private static int h2(int key, int mod) {
        return 1 + (key % (mod - 1));
    }
}
