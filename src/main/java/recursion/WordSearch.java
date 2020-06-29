//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法

package recursion;
  public class WordSearch {
      public static void main(String[] args) {
           Solution solution = new WordSearch().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        // 主要思路在每个点都进行dfs
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

          private boolean exist(char[][] board, int i, int j, String word, int curLength) {
              if (curLength == word.length()) {
                  return true;
              }
              if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || word.charAt(curLength) != board[i][j]) {
                  return false;
              }
              // 置为*避免走回头路
              board[i][j] = '*';
              // 从一个点的上下左右开始出发
              boolean result = exist(board, i + 1, j, word, curLength + 1)
                      || exist(board, i - 1, j, word, curLength + 1)
                      || exist(board, i, j + 1, word, curLength + 1)
                      || exist(board, i, j - 1, word, curLength + 1);
              // 复原
              board[i][j] = word.charAt(curLength);
              return result;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }