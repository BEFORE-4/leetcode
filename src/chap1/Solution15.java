package chap1;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Solution15 {

    public static void main(String[] args) {
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        threeSum(nums);
    }

    public static   List<List<Integer>> threeSum(int[] nums) {
       int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < n; first++){
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; second++){
                if (second > first + 1 && nums[second] == nums[second-1])
                    continue;
                while ( second < third && nums[second] + nums[third] > target){
                    --third;
                }
                if (second == third){
                    break;
                }
                if (nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }


            }
        }
        return ans;
    }
}
