package chap1;

import java.util.*;

public class Solution17 {

    List<String> output = new LinkedList<>();
    //用数组记录比用map记录省内存
    String[] phone = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxzy"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)   //不为空则进行操作
            getLetters("", digits, 0);
        return output;
    }

    /**
     * 通过递归进行查询
     * @param str 返回最终的一个字符串
     * @param digits 初始的一串数字
     * @param index 每次查找的数字索引
     */
    public void getLetters(String str, String digits, int index){
        if (index == digits.length()){ //已经将数组遍历完，则记录最终字符串
            output.add(str);
        }else {
            char digit = digits.charAt(index); //找出对应索引的数字
            String letters = phone[digit - '0'];    //通过数字查找到其所对应的字母
            //对每个字母进行遍历，并且索引加1后递归
            for (int i = 0; i < letters.length(); i++) {
                getLetters(str + letters.charAt(i), digits, index+1);
            }
        }

    }

}
