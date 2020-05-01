//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法

package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            // 回溯法
            // 初始化存放棋盘
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }
            List<List<String>> result = new ArrayList<>();
            dfs(board, 0, result);
            return result;
        }

        private void dfs(char[][] board, int col, List<List<String>> result) {
            // 终止条件
            if (col == board.length) {
                result.add(construct(board));
                return;
            }
            for (int i = 0; i < board.length; i++) {
                if (validate(board, i, col)) {
                    // 若可以放上皇后符合条件
                    board[i][col] = 'Q';
                    // 继续探到下一层
                    dfs(board, col + 1, result);
                    // 消除本层影响
                    board[i][col] = '.';
                }
            }
        }

        /**
         * 校验当前格子是否能放上皇后
         * @param board
         * @param curRow
         * @param curCol
         * @return
         */
        private boolean validate(char[][] board, int curRow, int curCol) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < curCol; j++) {
                    // 因为我们采用的思想是按照列从左向右的递推
                    // 因此皇后冲突的地方只可能是左半边，也就是45度，左水平（90度），135度的三条直线上(Ps：这里参照0度的起始位置上半根线)
                    // 所以三根直线代表的斜率分别是
                    // 135度: (curRow-j)/(curCol-i) = -1 -> curRow + curCol = i + j
                    // 90度：curRow = i
                    // 45度： (curCol-j)/(curRow-i) = 1 -> curCol + i = curRow + j
                    if (board[i][j] == 'Q' && (curRow + curCol == i + j || curRow == i || curCol + i == curRow + j)) {
                        return false;
                    }
                }
            }
            return true;
        }
        /**
         * 格式化输出，与逻辑无关
         * @param board
         * @return
         */
        private List<String> construct(char[][] board) {
            LinkedList<String> res = new LinkedList<>();
            for (char[] aBoard : board) {
                res.add(new String(aBoard));
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}