import java.util.*;

public class kmp {
    public static ArrayList<Integer> createPieTable(String pattern) {
        int m = pattern.length();
        ArrayList<Integer> pie = new ArrayList<>(m);
        int k = 0;
        pie.add(0);
        pie.add(0);

        for (int q = 2; q <= m; q++) {
            while (k > 0 && pattern.charAt(k) != pattern.charAt(q - 1)) {
                k = pie.get(k);
            }

            if (pattern.charAt(k) == pattern.charAt(q - 1)) {
                k = k + 1;
            }

            pie.add(k);
        }

        return pie;
    }

    public static ArrayList<Integer> matcher(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        ArrayList<Integer> pie = createPieTable(pattern);
        ArrayList<Integer> ans = new ArrayList<>();
        int q = 0;

        for (int i = 0; i < n; i++) {
            while (q > 0 && pattern.charAt(q) != text.charAt(i)) {
                q = pie.get(q - 1);
            }

            if (pattern.charAt(q) == text.charAt(i)) {
                q = q + 1;
            }

            if (q == m) {
                ans.add(i - m + 1);
                q = pie.get(q - 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String text = "I am apple, apple is red";
        String pattern = "apple";
        System.out.println(matcher(text, pattern));
    }
}
