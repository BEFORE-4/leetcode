package chap0;

/**
 * Z字形变换
 * 第0行为 k(2m-2) m为行号
 * 最后一行为 k(2m-2)+m-1
 * 中间的为 k(2m-2)+i 或者 (k+1)(2m-2)-i i为行号索引
 * 全部可以统一为 k(2m-2)+i 其中，i为行号索引；再者，中间的每次多一个 (k+1)(2m-2)-i
 */
public class Solution6 {
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int len = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++){
            if (i == 0){
                for (int j = 0;;j++){
                    if (j * len >= s.length())
                        break;
                    else
                        sb.append(s.charAt(j * len));
                }
            }else if (i == numRows - 1){
                for (int j = 0;;j++){
                    if (j * len + numRows - 1 >= s.length())
                        break;
                    else
                        sb.append(s.charAt(j * len + numRows - 1));
                }
            }else{
                for (int j = 0;; j++){
                    if (j * len + i >= s.length() &&
                            (j + 1) * len - i >= s.length())
                        break;
                    else{
                        if (s.length() > j * len + i){
                            sb.append(s.charAt(j * len + i));
                        }
                        if (s.length() > ((j + 1) * len - i)){
                            sb.append(s.charAt((j + 1) * len - i));
                        }

                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
