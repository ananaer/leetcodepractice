//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找

package binarysearch;
  public class SearchA2dMatrix {
      public static void main(String[] args) {
           Solution solution = new SearchA2dMatrix().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 重点每一行都是有序的，并且下一行的第一个数比上一行的最后一个数要大 因此可以看成一个有序数组进程二分查找
        // 转化公式matrix[i][j] -> a[i*col + j]   a[x] -> matrix[x/col][x%col]
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int lo = 0;
        int hi = col * row - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midValue = matrix[mid / col][mid % col];
            if (midValue == target) {
                return true;
            }
            if (midValue > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }