package chap0;

/**
 * 寻找两个有序数组的中位数
 *  将两个数组从中间分成两等分，使得nums1[i-1]<=nums2[j]且nums1[i]>=nums2[j-1]即可
 */
public class Solution4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        //首先保证数组1的数量比数组二少
        if (nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length, n = nums2.length;
        int imin = 0, imax = m;
        while (imin <= imax){
            int i = (imin + imax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i < imax && nums2[j - 1] > nums1[i]){
                imin = i + 1;
            }else if(i > imin && nums2[j] < nums1[i - 1]){
                imax = i - 1;
            }else {
                int maxLeft;
                if (i == 0){
                    maxLeft = nums2[j - 1];
                }else if(j == 0){
                    maxLeft = nums1[i - 1];
                }else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if((m + n) % 2 == 1)
                    return maxLeft;
                int minRight;
                if (i == m){
                    minRight = nums2[j];
                }else if (j == n){
                    minRight = nums1[i];
                }else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 6, 7, 8}, nums2 = {10};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
