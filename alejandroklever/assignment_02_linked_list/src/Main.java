public class Main {
    public static void main(String[] args) {
        // TASK 1
        LinkedList<Integer> list = new LinkedList<>(new Integer[]{1, 2, 3, 4, 5});
        list.reverse();
        System.out.println(list);
        
        //  TASK 2
        LinkedList<Integer> list1 = new LinkedList<>(new Integer[]{7, 1, 6});
        LinkedList<Integer> list2 = new LinkedList<>(new Integer[]{5, 9, 2});
        LinkedList<Integer> result = sum(list1, list2);
        System.out.println(result);
        
        list1 = new LinkedList<>(new Integer[]{9, 9});
        list2 = new LinkedList<>(new Integer[]{1});
        result = sum(list1, list2);
        System.out.println(result);

        list1 = new LinkedList<>(new Integer[]{9, 9, 9});
        list2 = new LinkedList<>(new Integer[]{1});
        result = sum(list1, list2);
        System.out.println(result);

        list1 = new LinkedList<>(new Integer[]{1, 8});
        list2 = new LinkedList<>(new Integer[]{9, 9, 9});
        result = sum(list1, list2);
        System.out.println(list1 + " + " + list2 + " = " + result);
        
        System.out.println(list1.equals(new LinkedList<>(new Integer[]{1, 8})));
    }

    public static LinkedList<Integer> sum(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        int carry = 0;
        LinkedList<Integer> result = new LinkedList<>();
        
        int maxSize = Math.max(l1.size(), l2.size());
        for (int i = 0; i < maxSize; i++) {
            int x = (i < l1.size()) ? l1.get(i) : 0;
            int y = (i < l2.size()) ? l2.get(i) : 0;
            int sum = x + y + carry;
            result.addLast(sum % 10);
            carry = sum / 10;
        }
        
        if (carry > 0) {
            result.add(carry);
        }

        return result;
    }
}