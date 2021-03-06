//今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分
//钟结束后离开。
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一
//分钟的顾客就会不满意，不生气则他们是满意的。
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
//
// 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
//
//
// 示例：
//
// 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//输出：16
//解释：
//书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
//
//
//
//
// 提示：
//
//
// 1 <= X <= customers.length == grumpy.length <= 20000
// 0 <= customers[i] <= 1000
// 0 <= grumpy[i] <= 1
//
// Related Topics 数组 Sliding Window

package slidewindow;

import java.util.PriorityQueue;
import java.util.Queue;

public class GrumpyBookstoreOwner {
      public static void main(String[] args) {
           Solution solution = new GrumpyBookstoreOwner().new Solution();
//          solution.maxSatisfied()
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int maxSatisfied(int[] customers, int[] grumpy, int X) {
              if (customers.length == 0) {
                  return 0;
              }
              int left = 0, right = 0;
              // 窗口内生气时间的客户
              int curCustomer = 0;
              // 不会生气时间的客户总数
              int noAngryCustomer = 0;
              // 生气时间内能利用秘诀得到的最多的客户
              int result = Integer.MIN_VALUE;
              while (right < customers.length) {
                  int rightCustomer = customers[right];
                  int isAngry = grumpy[right];
                  if (isAngry == 1) {
                      curCustomer += rightCustomer;
                  } else {
                      noAngryCustomer += rightCustomer;
                  }
                  right++;
                  // 窗口收缩的条件 开始生气的地方就需要开始使用秘诀
                  while (right - left > X) {
                      int leftCustomer = customers[left];
                      if (grumpy[left] == 1) {
                          curCustomer -= leftCustomer;
                      }
                      left++;
                  }
                  result = Math.max(result, curCustomer);
              }
              return result + noAngryCustomer;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }