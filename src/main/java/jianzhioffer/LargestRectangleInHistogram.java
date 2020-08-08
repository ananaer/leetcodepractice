//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组

package jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {
      public static void main(String[] args) {
           Solution solution = new LargestRectangleInHistogram().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int largestRectangleArea(int[] heights) {
              // 1.暴力穷举 将每一根棒子往左右两边括，分别找到比它低的第一个作为左右边界
              //   , 然后计算面积，对每个棒子做出重复的操作,其中的最大值就是最大面积
              //  2. 利用单调栈的特性（栈中的元素都是单调递增的），当前元素比栈顶的大则直接压入
              //       当前元素比栈顶小，则栈顶弹出 -》说明找到第一个比栈顶小的右边界了，栈顶的下面元素就是左边界，计算比更新最大面积
              int len = heights.length;
              Deque<Integer> s = new LinkedList<>();
              int maxArea = 0;
              // 注意边界条件 有循环到最大长度，保证栈中元素都计算完
              for (int i = 0; i <= len; i++){
                  int h = (i == len ? 0 : heights[i]);
                  if (s.isEmpty() || h >= heights[s.peek()]) {
                      s.push(i);
                  } else {
                      int tp = s.pop();
                      maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                      i--;
                  }
              }
              return maxArea;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }