import java.util.ArrayList;

public class rabinKarpString {
    public static ArrayList<Integer> rabinKarp(String text, String pattern, int d, int q) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        int p = Integer.parseInt(pattern) % q;
        int h = (int) Math.pow(d, m - 1);
        int t = 0;

        for (int i = 0; i < m; i++) {
            t = (d * t + Character.getNumericValue(text.charAt(i))) % q;
        }

        for (int s = 0; ((s + m) <= n); s++) {
            if (t == p) {
                int i = 0;
                while (i < m && text.charAt(s + i) == pattern.charAt(i)) {
                    i++;
                }

                if (i == m) {
                    ans.add(s);
                }
            }

            if (s < n - m) {
                t = (d * (t - h * Character.getNumericValue(text.charAt(s)))
                        + Character.getNumericValue(text.charAt(s + m))) % q;
                if (t < 0) {
                    t += q;
                }
            }
        }
        return ans;
    }
 
    public static void main(String[] args) {
        String text = "354861742222";
        String pattern = "22";
        int d = 10;
        int q = 13;

        System.out.println(rabinKarp(text, pattern, d, q));
    }
}
