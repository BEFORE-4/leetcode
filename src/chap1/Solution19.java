package chap1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 四数之和
 */
public class Solution19 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 4)  //少于四个，直接返回
            return res;
        Arrays.sort(nums); //排序
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;   //数组值相同，跳过
            int min = nums[i] + nums[i + 1] + nums[i+2] + nums[i+3];
            if (min > target)  //目标值比循环的最小值都小，结束循环
                break;
            int max = nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (target > max)
                continue;   //目标值比本轮循环的最大值都大，结束本轮循环
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j])
                    continue;   //同外层循环，数组值相同，跳过
                min = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (min > target)
                    break;  //同外层循环，目标值小于循环的最小值，结束循环
                max = nums[i] + nums[j] + nums[len -1] + nums[len - 2];
                if (target > max)
                    continue;   //目标值大于循环的最大值，跳过本轮循环
                int L = j + 1;  //左指针
                int R = len - 1;    //右指针
                while (L < R){
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target){
                        //符合值，记录下来
                        res.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        L++;    //记录后左指针向右移动
                        while (L < R && nums[L] == nums[L - 1])
                            L++;    //移动后的值和之前值相同时，继续移动，跳过重复
                        R--;
                        while (L < R && nums[R] == nums[R + 1])
                            R --; //移动后的值和之前值相同时，继续移动，跳过重复
                    }else if (sum < target){
                        L++; //求和比目标值小，左指针向右移动
                        while (L < R && nums[L] == nums[L - 1])
                            L++; //移动后的值和之前值相同时，继续移动，跳过重复
                    }else {
                        R--;  //求和比目标值大，右指针向左移动
                        while (L < R && nums[R] == nums[R + 1])
                            R --;  //移动后的值和之前值相同时，继续移动，跳过重复
                    }
                }
            }
        }
        return res;
    }
}
