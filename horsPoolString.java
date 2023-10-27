import java.util.ArrayList;
import java.util.HashMap;

public class horsPoolString {
    private static HashMap<Character, Integer> createShiftTable(String pattern) {
        HashMap<Character, Integer> shift = new HashMap<>();
        int m = pattern.length();

        for (int i = 0; i < m - 1; i++) {
            shift.put(pattern.charAt(i), m - 1 - i);
        }

        return shift;
    }

    static ArrayList<Integer> horsPool(String text, String pattern) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        int j = 0;
        HashMap<Character, Integer> shift = new HashMap<>();

        shift = createShiftTable(pattern);

        while (j + m < n) {
            int i = m;

            while (i > 0 && (text.charAt(j + m - i) == pattern.charAt(m - i))) {
                i--;
            }

            if (i == 0) {
                ans.add(j);
            }

            if (shift.containsKey(text.charAt(j + m - 1))) {
                j += shift.get(text.charAt(j + m - 1));
            } else {
                j += m;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String text = "jimy ran and hailed the leader to shop";
        String pattern = "leader";

        System.out.println(horsPool(text, pattern));
    }
}
