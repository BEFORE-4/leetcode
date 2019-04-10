package chap0;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution8 {
    public static void main(String[] args) {
        System.out.println(myAtoi1("42"));
//        boolean flag = "123 ".matches("^\\d+");
//        System.out.println(flag);
    }

    /**
     * 解法1，判断每一个字符
     * @param str
     * @return
     */
    public static int myAtoi1(String str) {
        str = str.trim();
        int result = 0;
        long num0 = 0;
        String s = str;
        if (s.startsWith("+"))
            s = s.substring(1);
        char[] strs = s.toCharArray();
        for (int i = 0; i < strs.length; i++){
            if (strs[i] >= 48 && strs[i] <= 57) {
                num0 = num0 * 10 + Integer.parseInt(Character.valueOf(strs[i]).toString());
                result = result * 10 + Integer.parseInt(Character.valueOf(strs[i]).toString());
                if (num0 > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }else
                break;
        }
        if (num0 > 0)
            return result;
        String result1 = "-";
        if (!str.startsWith("-"))
            return 0;
        char[] strs1 = str.toCharArray();
        for (int i = 1; i < strs1.length; i++) {
            if (strs1[i] >= 48 && strs1[i] <= 57) {
                num0 = num0 * 10 - Integer.parseInt(Character.valueOf(strs1[i]).toString());
                result = result * 10 - Integer.parseInt(Character.valueOf(strs1[i]).toString());
                if (num0 < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }else
                break;
        }
        if (result < 0)
            return result;
        return 0;
    }

    /**
     * 解法2，转换为字符串判断
     */
    public static int myAtoi(String str) {
        str = str.trim();
        Pattern p = Pattern.compile("^\\d+");
        Matcher matcher = p.matcher(str);
        String result = "";
        if (matcher.find()){
            result = matcher.group();
        }
        if (result.length() > 10){
            return Integer.MAX_VALUE;
        }else if (result.length() > 0){
            long num = Long.parseLong(result);
            if (num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else
                return Integer.parseInt(result);
        }
        Pattern p1 = Pattern.compile("^-\\d+");
        Matcher matcher1 = p1.matcher(str);
        String result1 = "";
        if (matcher1.find())
            result1 = matcher1.group();
        if (result1.length() > 11){
            return Integer.MIN_VALUE;
        }else if (result.length() > 1){
            long num = Long.parseLong(result1);
            if (num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else
                return Integer.parseInt(result1);
        }
            return 0;
    }
}
