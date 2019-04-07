package chap0;

/**
 * 回文中心的两侧互为镜像。因此，回文可以从它的中心展开
 * 在中心点两侧相等即可。
 * 判断所有中心点的最长回文即可
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        int start = 0, end =0;
        for (int i = 0; i < s.length(); i++){
            int length1 = expand(s, i, i);  //计算回文为奇数个
            int length2 = expand(s, i, i + 1);  //计算回文为偶数个
            int len = Math.max(length1, length2);
            if (len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1); //含头不含尾，需要加1
    }

    /**
     * 从中心点展开算最长回文
     * @param s 字符串
     * @param left 左边索引
     * @param right 右边索引
     * @return 最长回文的长度
     */
    private int expand(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
