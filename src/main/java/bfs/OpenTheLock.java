//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
// 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：
//把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], targ
//et = "8888"
//输出：-1
//解释：
//无法旋转到目标数字且不被锁定。
// 
//
// 示例 4: 
//
// 
//输入: deadends = ["0000"], target = "8888"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 死亡列表 deadends 的长度范围为 [1, 500]。 
// 目标数字 target 不会在 deadends 之中。 
// 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。 
// 
// Related Topics 广度优先搜索

package bfs;

import java.util.*;

public class OpenTheLock {
      public static void main(String[] args) {
           Solution solution = new OpenTheLock().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int openLock(String[] deadends, String target) {
              // 遍历都有两种选择把当前位置的数字往上拨 或者 往下拨
              String start = "0000";
              if (target.equals(start)) {
                  return 0;
              }
              Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
              // 访问过的路径 避免回头路
              Set<String> visited = new HashSet<>();
              Queue<String> queue = new LinkedList<>();
              queue.offer(start);
              visited.add(start);
              int ans = 0;
              while (!queue.isEmpty()) {
                  int size  = queue.size();
                  for (int i = 0; i < size; i++) {
                      String cur = queue.poll();
                      if (cur.equals(target)) {
                          return ans;
                      }
                      // 不能走此条路
                      if (deadendSet.contains(cur)) {
                          continue;
                      }
                      for (int j = 0; j < 4; j++) {
                          String up = plusOne(cur, j);
                          if (!visited.contains(up)) {
                              visited.add(up);
                              queue.add(up);
                          }
                          String down = minusOne(cur, j);
                          if (!visited.contains(down)) {
                              visited.add(down);
                              queue.add(down);
                          }
                      }
                  }
                  ans++;
              }
              return -1;
          }

          /**
           * 把数字往上拨
           * @param s
           * @param i
           * @return
           */
          private String plusOne(String s, int i) {
              char[] chars = s.toCharArray();
              if (chars[i] == '9') {
                  chars[i] = '0';
              } else {
                  chars[i] = (char) (chars[i] + 1);
              }
              return new String(chars);
          }

          /**
           * 把数字往下拨
           * @param s
           * @param i
           * @return
           */
          private String minusOne(String s, int i) {
              char[] chars = s.toCharArray();
              if (chars[i] == '0') {
                  chars[i] = '9';
              } else {
                  chars[i] = (char) (chars[i] - 1);
              }
              return new String(chars);
          }


      }
//leetcode submit region end(Prohibit modification and deletion)

  }