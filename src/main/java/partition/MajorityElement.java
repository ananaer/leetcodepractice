//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法

package partition;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            // 分治法
            return search(nums, 0, nums.length - 1);
        }

        private int search(int[] nums, int l, int r) {
            if (l == r) {
                return nums[l];
            }
            int mid = l + (r-l)/2;
            // 找出左边出现最多数
            int lm = search(nums, l, mid);
            // 找出右边出现最多数
            int rm = search(nums, mid + 1, r);
            if (lm == rm) {
                return lm;
            }
            // 分别计算在当前子数组中左右下标的数哪个出现的次数更多，并返回次数最多的下标
            return countInRange(nums, lm, l, r) > countInRange(nums, rm, l, r) ? lm : rm;
        }

        /**
         * 计算num在数组lo-hi中出现的次数
         * @param nums
         * @param num
         * @param lo
         * @param hi
         * @return
         */
        private int countInRange(int[] nums, int num, int lo, int hi) {
            int count = 0;
            for (int i = lo; i <= hi; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}