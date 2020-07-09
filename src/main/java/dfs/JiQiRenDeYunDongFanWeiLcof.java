//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
//

package dfs;
  public class JiQiRenDeYunDongFanWeiLcof {
      public static void main(String[] args) {
           Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          int result = 0;
    public int movingCount(int m, int n, int k) {
        // 关键点 这题问的是机器人总共能到达多少个格子，而不是走出一条路，因此不能用回溯
        int[][] bord = new int[m][n];
        back_track(bord, 0, 0, 0, k);
        return result;
    }

          private void back_track(int[][] bord, int i, int j, int path, int k) {
              if (i < 0 || j < 0
                      || i >= bord.length || j >= bord[0].length
                      || bord[i][j] == 1
                      || ( (i / 10 + i % 10 + j / 10 + j % 10) > k)) {
                  return ;
              }
              bord[i][j] = 1;
              result++;
              back_track(bord, i, j - 1, path + 1, k);
              back_track(bord, i, j + 1, path + 1, k);
              back_track(bord, i -1, j , path + 1, k);
              back_track(bord, i + 1, j, path + 1, k);

          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }