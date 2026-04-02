class Problem5 {

    static int linearSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(key)) return i;
        return -1;
    }

    static int binarySearch(String[] arr, String key) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid].equals(key)) return mid;
            else if (arr[mid].compareTo(key) < 0) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}