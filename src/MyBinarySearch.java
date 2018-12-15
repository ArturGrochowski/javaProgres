//public class MyBinarySearch {
//
//    public int binarySearch(int[] inputArr, int key) {
//
//        int start = 0;
//        int end = inputArr.length - 1;
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            if (key == inputArr[mid]) {
//                return mid;
//            }
//            if (key < inputArr[mid]) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return -1;
//    }
//
//    public static void main(String[] args) {
//        SimpleGeneric<String> sgs = new SimpleGeneric<String>("JAVA2NOVICE");
//        sgs.printType();
//        //we are going to create SimpleGeneric object with Boolean as type parameter
//        SimpleGeneric<Boolean> sgb = new SimpleGeneric<Boolean>(Boolean.TRUE);
//        sgb.printType();
//
//        MyBinarySearch mbs = new MyBinarySearch();
//        int[] arr = {200, 14, 6, 8, 10, 12, 4, 16};
//        System.out.println("Key 14's position: "+mbs.binarySearch(arr, 14));
//        int[] arr1 = {600,34,78,123,432,900};
//        System.out.println("Key 432's position: "+mbs.binarySearch(arr1, 432));
//    }
//}