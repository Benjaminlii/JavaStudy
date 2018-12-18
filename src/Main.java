/**
 * ≤›∏Â÷Ω
 * <p>
 * author:Benjamin
 */

public class Main {
    private static boolean isPalindromic(int num) {
        String s = num + "";
        char[] chars = s.toCharArray();
        StringBuilder s_builder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            s_builder.append(chars[i]);
        }
        String s_ = s_builder.toString();
        return s.equals(s_);
    }

    public static void main(String[] args) {
        int count = 1;
        int num = 3;
        System.out.print(2 + " ");
        while (count < 100) {
            for (int i = 2; i <= num / 2 + 1; i++) {
                if (num % i == 0)
                    break;
                if (i == num / 2 + 1)
                    if (isPalindromic(num)) {
                        System.out.print(num + " ");
                        count++;
                        if (count % 10 == 0) {
                            System.out.print("\n");
                        }
                    }
            }
            num++;
        }
    }
}
