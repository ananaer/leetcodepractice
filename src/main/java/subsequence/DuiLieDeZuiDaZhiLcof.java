//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 栈 Sliding Window

package subsequence;

import java.util.Deque;
import java.util.LinkedList;

public class DuiLieDeZuiDaZhiLcof {
      public static void main(String[] args) {
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class MaxQueue {

          // 主要思路 一个双端队列用于维护整体的数据，进行出队和入队操作
          // 一个普通队列作为辅助队列用于记录每个操作后的最大值，类比维护滑动窗口的最大值
          private Deque<Integer> dequeue;

          private Deque<Integer> max;

          public MaxQueue() {
              dequeue = new LinkedList<>();
              max = new LinkedList<>();
          }

          public int max_value() {
              if(max.isEmpty()){
                  return -1;
              }else{
                  return max.peekFirst();
              }
          }

          public void push_back(int value) {
              dequeue.addLast(value);
              while(!max.isEmpty() && max.peekLast() <= value){
                  max.pollLast();
              }
              max.addLast(value);
          }

          public int pop_front() {
              if(dequeue.isEmpty()){
                  return -1;
              }
              int ans = dequeue.pollFirst();
              if(ans == max.peekFirst()){
                  max.pollFirst();
              }
              return ans;
          }
      }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

  }