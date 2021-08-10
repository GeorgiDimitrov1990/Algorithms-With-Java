public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1,2,3,4};

        int index =binarySearch(arr, 4);
        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int element) {
        int start = 0;
        int end = arr.length -1;

        while (start<= end){
            int mid = (start + end) / 2;
            int current = arr[mid];
            if (element < current){
                end = mid -1;
            } else if (element > current){
                start = mid + 1;
            } else {
                return mid;
            }
        }


        return -1;
    }
}
