//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 注意数组中可能存在重复的元素。 
//
// 示例 1： 
//
// 输入: [1,3,5]
//输出: 1 
//
// 示例 2： 
//
// 输入: [2,2,2,0,1]
//输出: 0 
//
// 说明： 
//
// 
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。 
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？ 
// 
// Related Topics 数组 二分查找

package binarysearch;
  public class FindMinimumInRotatedSortedArrayIi {
      public static void main(String[] args) {
           Solution solution = new FindMinimumInRotatedSortedArrayIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        // 旋转数组的特性 可以分为两个数组 num1 num2
        // num1中的数一定都大于num2
        // 所以问题可以转化为找num2的首个元素
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            int m = (i + j) / 2;
            if (nums[m] > nums[j]) {
                // 说明m一定在num1中，此时要收缩左边界
                i = m + 1;
            } else if (nums[m] < nums[j]){
                // 说明m一定在num2中，此时收缩右边界
                j = m;
            }else {
                // 相等的时候由于数组允许存在重复元素因此不能直接判断就是nums2的第一个点
                // j--保证了遍历时不会越界，最小值不会丢失
                j --;
            }
        }
        return nums[i];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }