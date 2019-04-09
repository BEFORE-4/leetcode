package chap0;

/**
 * int的取值范围是int max=2147483647
 * int min=-2147483648
 * 需要结果小于最大值10倍，或者刚好是最大值10倍并且最后一位不大于7
 */
public class Solution7 {
    public static int reverse(int x) {
        int result = 0;
        while ( x != 0){
            int pop = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10 ||
                    (result == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            result = (result * 10) + pop;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(reverse(0));
    }
}
