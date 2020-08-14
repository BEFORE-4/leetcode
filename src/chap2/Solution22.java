package chap2;

import java.util.LinkedList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        generateList(new char[n * 2], 0, res); //生成所有字符串
        return res;
    }

    /**
     * 利用递归生成所有符合的字符串
     * @param c
     * @param position
     * @param res
     */
    public void generateList(char[] c, int position, List<String> res){
        if (position == c.length){
            if (valid(c)){      //如果有效，则存入链表中
                res.add(String.valueOf(c));
            }
        }else {
            //每次只有两种现象，要么左括号，要么右括号。分别对两种递归
            c[position] = '(';
            generateList(c, position + 1, res);
            c[position] = ')';
            generateList(c, position + 1, res);
        }
    }

    /**
     * 判断该字符串是否符合括号规则
     * 有左括号就是入栈,num加1，反正num减1
     * 如果num小于0，那么就是出现了一个 ) ，肯定不符合，直接返回false
     * @param c
     * @return
     */
    public boolean valid(char[] c){
        int num = 0;
        for (char ch:c){
            if (ch == '(')
                num++;
            else
                num--;
            if (num < 0)    //小于则直接返回false
                return false;
        }
        return num == 0;    //最终的num必须为0才符合括号规则
    }
}
