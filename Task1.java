
import java.util.Random;

public class Task1 {

    private static final Random random = new Random();

    public static void main(String[] args) {
        int[] arr = randomArray(20, 10, 100);
        printArray(arr);
        heapSort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, i, n);

        for (int i = n - 1; i >= 0; i--) {

            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }

    }

    private static void heapify(int[] arr, int i, int n) {
        int l = i * 2 + 1;

        int r = i * 2 + 2;

        int largest = i;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (i != largest) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, largest, n);
        }
    }

    public static int[] randomArray(int size, int smallest, int largest) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(smallest, largest);
        }
        return result;

    }

    public static void printArray(int[] toPrint) {
        for (int element : toPrint) {
            System.out.printf("%d ", element);
        }
        System.out.println();
    }

}
