//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找

package binarysearch;
  public class Sqrtx {
      public static void main(String[] args) {
           Solution solution = new Sqrtx().new Solution();
          System.out.println(solution.mySqrt(2147395599));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//          二分查找模板
//          left, right = 0, len(array) - 1
//                  while left <= right:
//          mid = (left + right) / 2
//                  if array[mid] == target:
//                  # find the target!!
//                  break or return result
//          elif array[mid] < target:
//          left = mid + 1
//                  else:
//          right = mid - 1
public int mySqrt(int x) {
    int lo = 0;
    int hi = x;
    while (lo <= hi) {
        // 与mid = (lo + hi) / 2 避免大数情况下越界
        int mid = lo + (hi - lo) / 2;
        long target = (long)mid * mid;
        if (target == x) {
            return mid;
        } else if (target < x) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    return hi;

}
}
//leetcode submit region end(Prohibit modification and deletion)

  }