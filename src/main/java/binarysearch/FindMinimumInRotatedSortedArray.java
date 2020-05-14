//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找

package binarysearch;
  public class FindMinimumInRotatedSortedArray {
      public static void main(String[] args) {
           Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int lo = 0;
        int hi = nums.length - 1;
        // 说明递增 直接取最小
        if (nums[hi] > nums[lo]) {
            return nums[lo];
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // 想想那个旋转点的数有什么特点
            // 1. num[target] < num[target - 1] -- 这个好理解
            // 2. num[target] > num[target + 1]
            // 总结一下就是找到不是递增的时候，如果发现数组不递增了，那么就是旋转点
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }

            if (nums[mid] > nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return nums[lo];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }