//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package dfs;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        int i = solution.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        char[][] g;

        public int numIslands(char[][] grid) {
            // 主要思路：遇到陆地就把它炸成水，同时DFS直到遇不见陆地，这就是一个小岛
            int islandNum = 0;
            g = grid;
            // 遍历地图的每一个点
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '0') continue;
                    // 否则是陆地的话还是炸岛
                    islandNum += sink(i, j);
                }
            }
            return islandNum;
        }

        // 这里就是用dfs的思想
        private int sink(int i, int j) {
            // 终止条件
            if (g[i][j] == '0') {
                return 0;
            }
            // 本层要干的事:炸岛
            g[i][j] = '0';

            for (int k = 0; k < dx.length; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x >= 0 && x < g.length && y >= 0 && y < g[i].length) {
                    if (g[x][y] == '0') continue;
                    sink(x, y);
                }
            }
            return 1;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}