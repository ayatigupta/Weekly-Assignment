import java.util.*;

 class TwoSum {

    public void find(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {

            if (map.containsKey(num)) {
                System.out.println("Pair: " + num + ", " + (target - num));
                return;
            }

            map.put(target - num, num);
        }
    }
}