package chap1;

public class Solution11 {

    //动态规划，时间复杂度为O(n)
    public int maxArea1(int[] height){
        int max = 0, l = 0, r = height.length - 1;//左右两个索引
        while (l < r){
            int area = (r - l) * Math.min(height[l], height[r]);
            if (max < area){
                max = area;
            }
            if (height[l] > height[r])  //控制索引移动
                r--;
            else
                l++;
        }
        return max;
    }

    //暴力解法最简单易懂 时间复杂度：O(n^2)
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int length = j - i;
                int heigh = Math.min(height[i], height[j]);
                if (max < heigh * length)
                    max = heigh * length;
            }
        }
        return max;
    }
}
