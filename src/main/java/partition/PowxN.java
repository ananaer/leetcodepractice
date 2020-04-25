//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找

package partition;

public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            // 主要思路是分治法， 分治法与递归的主要区别就是多了一步：对结果的Merger
            // 解决的重复子问题就是对于 x的n次方，只需要计算一次x的n/2次方就可以了，不用迭代相乘
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            return myPowHelp(x, N);
        }

        public double myPowHelp(double x, long n) {
            if (n == 0) {
                return 1.0;
            }
            double v = myPowHelp(x, n / 2);
            // 如果指数是偶数 那么结果就等于分支的结果相乘，否则还得多乘一个x本身
            return n % 2 == 0 ? v * v : v * v * x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}