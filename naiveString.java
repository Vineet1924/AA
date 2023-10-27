import java.util.ArrayList;

public class naiveString {

    static ArrayList<Integer> naiveStringMatching(String text, String pattern) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        for (int s = 0; s <= (n - m); s++) {
            int i = 0;
            int j = 0;

            while (j < m && (text.charAt(s + i) == pattern.charAt(j))) {
                i++;
                j++;
            }

            if (j == m) {
                ans.add(s);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String text = "I am apple, apple is red";
        String pattern = "apple";

        System.out.println(naiveStringMatching(text, pattern));
    }
}
