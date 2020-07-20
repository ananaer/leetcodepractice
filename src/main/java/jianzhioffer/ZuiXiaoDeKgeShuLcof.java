//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法

package jianzhioffer;

import java.util.PriorityQueue;
import java.util.Queue;

public class ZuiXiaoDeKgeShuLcof {
      public static void main(String[] args) {
           Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int[] getLeastNumbers(int[] arr, int k) {
              // top K问题
              // 主要思路准备一个最大堆
              // 默认是最小堆->改为最大堆
              if (k == 0) {
                  return new int[0];
              }
              Queue<Integer> dump =  new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
              for(int i : arr){
                  if(dump.size() < k || i < dump.peek()){
                      dump.offer(i);
                  }
                  // 弹出最大的数
                  if(dump.size() > k){
                      dump.poll();
                  }
              }
              int[] res = new int[k];
              for(int j = 0; j < k; j++){
                  res[j]=dump.poll();
              }
              return res;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }