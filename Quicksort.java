import java.util.Random;
public class Quicksort {
    public static void main(String[] args) {
        for(int i = 2;i <= 50; i+=2){
            int[] arr = randArray(i * 1_000_000);
            long time_before = System.currentTimeMillis();
            quickSort(arr,0,arr.length-1);
            long time_after = System.currentTimeMillis();
            long runtime = time_after-time_before;
            System.out.println(i+" miljoen getallen duurt "+ runtime + " ms");
        }

    }

    private static int[] randArray(int numbers) {
        Random rd = new Random();
        int[] array = new int[numbers];
        for(int i = 0;i< array.length;i++){
            array[i] = rd.nextInt(1_000_000_000);
        }
        return array;
    }

    private static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}
