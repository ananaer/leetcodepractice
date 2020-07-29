//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

package doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public List<List<Integer>> threeSum(int[] nums) {
              // 在两数之和的基础之上转化为 a + b = -c + target, 实际就是穷举每个值,只不过这里的target正好是零
              // 排序后使用双指针，注意判重
              // 时间复杂度 O(n2)
              Arrays.sort(nums);
              List<List<Integer>> res = new ArrayList();
              for(int i = 0; i < nums.length; i++){
                  if (nums[i] > 0) break;
                  // 注意这里需要i+1开始而不是 0 也是避免重复
                  List<List<Integer>> tmp = twoSum(nums, i+1,-nums[i]);
                  for (List<Integer> list : tmp) {
                      list.add(nums[i]);
                      res.add(list);
                  }
                  // 在跳过重复的
                  while (i < nums.length -2 && nums[i] == nums[i+1]) i++;
              }
              return res;
          }

          // 求两数之和
          public List<List<Integer>> twoSum(int[] nums, int start, int target){
              int left =start;
              int right = nums.length - 1;
              List<List<Integer>> res = new ArrayList();
              while(left < right){
                  int sum = nums[left] + nums[right];
                  int leftValue = nums[left];
                  int rightValue = nums[right];
                  if(sum < target){
                      while(left < right && leftValue == nums[left]) left++;
                  }else if(sum > target){
                      while(left < right && rightValue == nums[right]) right--;
                  }else {
                      // sum == target
                      res.add(new ArrayList<>(Arrays.asList(leftValue, rightValue)));
                      while(left < right && leftValue == nums[left]) left++;
                      while(left < right && rightValue == nums[right]) right--;
                  }
              }
              return res;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }