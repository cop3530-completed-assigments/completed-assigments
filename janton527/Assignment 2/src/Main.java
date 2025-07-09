public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        list1.add(7);
        list1.add(1);
        list1.add(6);
        System.out.println(list1);

        list2.add(5);
        list2.add(9);
        list2.add(2);
        System.out.println(list2);

        System.out.println(LinkedList.sumLists(list1, list2));


    }
}