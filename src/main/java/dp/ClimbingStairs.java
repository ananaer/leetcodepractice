//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

package dp;
  public class ClimbingStairs {
      public static void main(String[] args) {
           Solution solution = new ClimbingStairs().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        // 动态规划 递推公式 dp[n] = dp[n-1]+dp[n-2]
        // dp[0] 无意义 n是正整数 dp[1]=1, dp[2]=2
        /*if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];*/
        // f(n) = f(n-1) +f(n-2)
        // f(1) = 1; f(2) = 2;
        // 动态规划避免傻递归
        if(n <=2){
            return n;
        }
        int a=1, b=2;
        int res = 0;
        for(int i = 3; i <= n; i++){
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }