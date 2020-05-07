//让我们一起来玩扫雷游戏！ 
//
// 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）
//地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。 
//
// 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板： 
//
// 
// 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。 
// 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。 
// 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。 
// 如果在此次点击中，若无更多方块可被揭露，则返回面板。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 示例 2： 
//
// 输入: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Click : [1,2]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'X', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 
//
// 注意： 
//
// 
// 输入矩阵的宽和高的范围为 [1,50]。 
// 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。 
// 输入面板不会是游戏结束的状态（即有地雷已被挖出）。 
// 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。 
// Related Topics 深度优先搜索 广度优先搜索

package dfs;

public class Minesweeper {
    public static void main(String[] args) {
        Solution solution = new Minesweeper().new Solution();
        char[][] board = new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        int[] click = new int[]{3, 0};
        solution.updateBoard(board, click);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] dx = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        int[] dy = new int[]{1, 1, 1, 0, -1, -1, -1, 0};

        public char[][] updateBoard(char[][] board, int[] click) {
            // 采用跟沉岛相同的思路
            int row = click[0];
            int col = click[1];
            dfs(board, row, col);
            return board;
        }

        private void dfs(char[][] board, int row, int col) {
            // 终止条件点到雷了
            if (board[row][col] == 'M') {
                board[row][col] = 'X';
                return;
            }
            // 遍历上下左右和对角线的一共8个点 计算雷的数量
            int minesNum = 0;
            for (int i = 0; i < dx.length; i++) {
                int x = row + dx[i];
                int y = col + dy[i];
                // x,y的取值在棋盘内，并且取值是雷
                if (x >= 0 && x < board.length && y >= 0 && y < board[row].length && (board[x][y] == 'M' || board[x][y] == 'X'))
                    minesNum++;
            }
            if (minesNum > 0) {
                board[row][col] = (char) (minesNum + '0');
                return;
            }
            // 否则说明这个点四周无雷
            board[row][col] = 'B';
            // dfs遍历其他点
            for (int i = 0; i < dx.length; i++) {
                int x = row + dx[i];
                int y = col + dy[i];
                // 本身属于E的
                if (x >= 0 && x < board.length && y >= 0 && y < board[row].length && board[x][y] == 'E') {
                    dfs(board, x, y);
                }
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}