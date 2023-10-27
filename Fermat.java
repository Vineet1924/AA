import java.util.*;

public class Fermat {
    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;
        return randomNumber;
    }

    public static int gcd(int a, int b) {
        if(a < b) {
            return gcd(b, a);
        } else if(a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    public static int power(int a, int x, int n) {
        int result = 1;

        while(x > 0) {
            if(x % 2 == 1) {
                result = (result * a) % n;
            }

            x /= 2;
            a = (a * a) % n;
        }

        return result;
    }

    public static boolean isPrime(int n) {
        if(n <= 1 && n == 4) {
            return false;
        } else if (n < 4) {
            return true;
        } else {
            int k = 100;
            int a = generateRandomNumber(2, n - 2);

            while(k > 0) {
                if(gcd(a, n) != 1) {
                    return false;
                } 
                if (power(a, n - 1, n) != 1) {
                    return false;
                }
                k--;
            }

            return true;
        }
    } 

    public static double getLiar(int n) {
        int liar = 0;

        for(int a = 2; a < n - 2; a++) {
            if(power(a, n - 1, n) == 1) {
                liar++;
            }
        }

        return ((double)liar / (n - 3));
    }

    public static void main(String argd[]) {
        int n = 563;
        System.out.println(isPrime(n));
        System.out.print(getLiar(n));
    }
}