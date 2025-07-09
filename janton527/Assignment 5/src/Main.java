public class Main {
    public static void main(String[] args) {

        int[] numbers = {7, 9, 23, 45, 5, 10, 11, 92, 34, 55, 101, 43, 71};
        int size = numbers.length;
        HashMap<Integer, Integer> myHash = new HashMap<>(size);

        for (int number : numbers) {
            myHash.hashInsert(number);
        }

        System.out.println(myHash.hashSearch(92));
        System.out.println(myHash.hashSearch(1));

    }
}