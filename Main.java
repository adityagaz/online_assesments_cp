import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] arrayInput = new int[size];
        for (int i = 0; i < size; i++) {
            arrayInput[i] = s.nextInt();
        }
        System.out.println(minSwapsToMakeBeautiful(arrayInput));
    }

    static int minSwapsToMakeBeautiful(int[] arr) {
        int[] arrAsc = arr.clone();
        int[] arrDesc = arr.clone();
        int minSwaps = bubbleSort(arrAsc);

        return minSwaps;
    }

    static int bubbleSort(int[] arr) {
        int swapCountAsc = 0;
        int swapCountDsc = 0;
        int n = arr.length;

        // Perform bubble sort in ascending order
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap and increase the swap count
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapCountAsc++;
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Swap and increase the swap count
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapCountDsc++;
                }
            }
        }

        return Math.min(swapCountDsc , swapCountAsc);
    }

}
