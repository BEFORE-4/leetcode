package chap1;

public class Solution10 {
    public static void main(String[] args) {
        String s = "";
        String p = "a";
        System.out.println(p.charAt(1));
    }


    //递归(速度慢，逻辑清晰易懂)
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
        boolean firstMatch = (!s.isEmpty()) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || (firstMatch && (isMatch(s.substring(1), p )));
        }else{
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}