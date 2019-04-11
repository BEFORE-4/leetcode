package chap0;

public class Solution9 {
    public boolean isPalindrome(int x) {
        String str = Integer.valueOf(x).toString();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++){
            if (chars[i] != chars[chars.length - i - 1])
                return false;
        }
        return true;
    }
}
