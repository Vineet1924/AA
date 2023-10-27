import java.util.Random;

public class RandomizeQuickSort {
    static int comparisson = 0;
    
    public void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;
        return randomNumber;
    }

    public int partition(int arr[], int p, int r) {
        int x = arr[r];
        int i = p - 1;
        
        for(int j = p; j < r; j++) {
            comparisson++;
            if(arr[j] <= x) {
                i = i + 1;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, r);
        return i + 1;
    }

    public int randomizedPartion(int arr[], int p, int r) {
        int i = p + generateRandomNumber(0, r - p); 
        swap(arr, i, r);
        return(partition(arr, p, r));
    }

    public void randomizedQuickSort(int arr[], int p, int r) {
        if(p < r) {
            int q = randomizedPartion(arr, p, r);
            randomizedQuickSort(arr, p, q - 1);
            randomizedQuickSort(arr, q + 1, r);
        }
    }

    public static void main(String args[]) {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
                     91, 92, 93, 94, 95, 96, 97, 98, 99, 100,
                     11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 
                     21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 
                     31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 
                     41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 
                     51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 
                     61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 
                     71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 
                     81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
        };
        RandomizeQuickSort rq = new RandomizeQuickSort();
        rq.randomizedQuickSort(arr, 0, (arr.length - 1));

        System.out.println("Total comparision = " + rq.comparisson);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}