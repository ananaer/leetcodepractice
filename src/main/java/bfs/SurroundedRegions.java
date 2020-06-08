//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solve(char[][] board) {
            // 基本思路 把能与边界上的O联通的内部O标记，再把未标记的O给置为#
            if (board == null || board.length == 0) return;
            int row = board.length;
            int col = board[0].length;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    boolean isEdge = i == 0 || i == row - 1 || j == 0 || j == col - 1;
                    if (isEdge && board[i][j] == 'O') {
                        // 标记出所有与这个点相通的O
                        board[i][j] = '#';
                        bfs(board, i, j);
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                    if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void bfs(char[][] board, int row, int col) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{row, col});
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = queue.poll();
                    //上
                    int up = cur[0] - 1;
                    if (up > -1 && board[up][cur[1]] == 'O') {
                        queue.offer(new int[]{up, cur[1]});
                        board[up][cur[1]] = '#';
                    }
                    // 下
                    int down = cur[0] + 1;
                    if (down < board.length && board[down][cur[1]] == 'O') {
                        queue.offer(new int[]{down, cur[1]});
                        board[down][cur[1]] = '#';
                    }
                    // 左
                    int left = cur[1] - 1;
                    if (left > -1 && board[cur[0]][left] == 'O') {
                        queue.offer(new int[]{cur[0], left});
                        board[cur[0]][left] = '#';
                    }
                    // 右
                    int right = cur[1] + 1;
                    if (right < board[0].length && board[cur[0]][right] == 'O') {
                        queue.offer(new int[]{cur[0], right});
                        board[cur[0]][right] = '#';
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}