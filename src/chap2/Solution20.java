package chap2;

import java.util.*;

public class Solution20 {
    public boolean isValid(String s) {
        //设置对应的括号
        Map<Character, Character> map = new HashMap(){{
           put('[',']');
           put('(',')');
           put('{','}');
        }};
        //定义栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                stack.push(c);//左括号，压栈处理
            }else {
                if (stack.isEmpty())//栈为空，并且是右括号，不匹配
                    return false;
                if (map.get(stack.pop()) != c){ //出栈元素和map的value不同，不匹配
                    return false;
                }
            }
        }
        //结束后，栈内还有元素，则不匹配
        return stack.isEmpty();
    }
}
