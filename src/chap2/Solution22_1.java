package chap2;

import java.util.LinkedList;
import java.util.List;

/**
 * dfs深度优先搜索回溯
 */
public class Solution22_1 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        dfs(res, "", 0, 0, n);
        return res;
    }

    /**
     * 产生所有的结果
     * @param res 返回所有的字符串列表
     * @param str 每步生成的字符串
     * @param open 字符串中开括号数量
     * @param close 字符串中闭括号数量
     * @param max 括号最大数量
     */
    public void dfs(List<String> res, String str, int open, int close, int max){
        //如果开括号和闭括号都已经达到最大值，则记录最大值到链表
        if (open == max && close ==max){
            res.add(str);
            return;
        }
        //如果开括号数量小于闭括号数量，显然不对，结束
        if (open < close)
            return;
        //当开括号没有达到最大，字符串中增加一个开括号，并且开括号数量加1
        if (open < max){
            dfs(res, str+"(", open+1, close, max);
        }
        //同上
        if (close < max){
            dfs(res, str+")", open, close+1, max);
        }
    }
}
