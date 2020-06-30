//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法

package recursion;
  public class SudokuSolver {
      public static void main(String[] args) {
           Solution solution = new SudokuSolver().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

          private Boolean backtrack(char[][] board) {
              for (int i = 0; i < board.length; i++) {
                  for (int j = 0; j < board[0].length; j++) {
                      if (board[i][j] == '.') {
                          for (char k = '1'; k <= '9'; k++) {
                              if (isValid(board, i, j, k)) {
                                  board[i][j] = k;
                                  if (backtrack(board)) {
                                      return true;
                                  } else {
                                      board[i][j] = '.';
                                  }
                              }
                          }

                          return false;
                      }
                  }
              }
              return true;
          }

          private boolean isValid(char[][] board, int row, int col, char k) {
              for (int l = 0; l < 9; l++) {
                  if (board[row][l] == k) return false;
                  if (board[l][col] == k) return false;
                  if (board[3 * (row / 3) + l / 3][ 3 * (col / 3) + l % 3] == k) return false;
              }
              return true;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }