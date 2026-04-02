class Problem6 {

    static int floor(int[] arr, int target) {
        int res = -1;

        for (int num : arr)
            if (num <= target) res = num;

        return res;
    }

    static int ceiling(int[] arr, int target) {
        for (int num : arr)
            if (num >= target) return num;

        return -1;
    }
}