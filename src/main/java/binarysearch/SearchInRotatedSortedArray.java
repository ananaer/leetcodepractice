//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找

package binarysearch;
  public class SearchInRotatedSortedArray {
      public static void main(String[] args) {
           Solution solution = new SearchInRotatedSortedArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        // 主要思路还是二分法，但是边界判断同二分法不一样，因为它是旋转数组 不是单调有序的
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 说明从lo到mid是单调递增的
            if (nums[mid] >= nums[lo]) {
                // 说明target在区间lo到mid中，因此划分左区间
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {// 说明mid是在旋转数组的后半边
                // target在旋转数据的后半边的单调区间里，划分右区间
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }