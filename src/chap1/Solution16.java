package chap1;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;
import java.util.Map;

public class Solution16 {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i +1;
            int k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return target;
                if (Math.abs(res - target) > Math.abs(sum - target))
                    res = sum;
                if (sum < target){
                    while (j < k && nums[j] == nums[j + 1]){
                        j++;
                    }
                    j++;
                }else if (sum > target){
                    while (j < k && nums[k] == nums[k - 1])
                        k--;
                    k--;
                }
            }
        }
        return res;
    }
}
