public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 16, 27, 31, 32, 51};

        BinarySearch binarySearch = new BinarySearch();
        int valueIndex = binarySearch.search(arr, 15);

        System.out.println("Index of searched value is \n" + valueIndex);
    }

    private int search(int[] arr, int value) {
        int startIndex = 0;
        int endIndex = arr.length-1;
        int mid;

        while (startIndex <= endIndex) {
            mid = (startIndex + endIndex) / 2;
            if (value == arr[mid]) {
                return mid;
            }
            if (value < arr[mid]) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return -1;
    }
}
