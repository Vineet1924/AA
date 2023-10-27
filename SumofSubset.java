public class SumofSubset {

    public static boolean getKnapsack(int arr[], int sum) {
        int n = arr.length;
        int p[] = new int[n];
        int w[] = new int[n];
        int c = sum;
        int v = sum;
        int matrix[][] = new int[n + 1][sum + 1];
        
        for(int i = 0; i < n; i++) {
            p[i] = arr[i];
            w[i] = arr[i];
        }

        for(int i = 0; i <= n; i++) {
            matrix[i][0] = 0;
        }

        for(int i = 0; i <= sum; i++) {
            matrix[0][i] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(j < w[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], p[i - 1] + matrix[i - 1][j - w[i - 1]]);
                }
            }
        }

        if(matrix[n][sum] == sum) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean sumOfSubset(int arr[], int sum) {
        if(getKnapsack(arr, sum)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        int arr[] = {0, 2, 4, 6, 8};
        int sum = 8;

        System.out.println(sumOfSubset(arr, sum));
    }
}