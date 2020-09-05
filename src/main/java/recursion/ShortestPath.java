package recursion;

import java.util.*;

public class ShortestPath {
    class Path {
        // 出发地名
        public String start;
        // 结束地名
        public String end;
        // 距离
        public Integer distance;
    }

    class Solution {
        public int getShortPath(Map<String, Integer> elevations, List<Path> paths) {
            // 整体使用回溯法，试探每种选择并得出最短路径的一种选择
            Deque<Integer> res = new LinkedList<>();
            backtrack(res, elevations, paths, 0, "Huilongguan", 1, 0);
            return res.pollLast();
        }

        /**
         * 获取最小值
         *
         * @param res                  结果值
         * @param elevations           海拔Map
         * @param paths                路径列表
         * @param currentDistanceCount 当前已跑的距离
         * @param currentPos           当前所在的位置
         * @param changeDirection      剩余可改变方向的次数
         * @param status               0 平走 1 向上 2向下
         */
        private void backtrack(Deque<Integer> res, Map<String, Integer> elevations, List<Path> paths, Integer currentDistanceCount, String currentPos, Integer changeDirection, Integer status) {
            // 已经到达目的地
            if ("Huilongguan".equals(currentPos) && currentDistanceCount != 0) {
                res.addLast(res.isEmpty() ? currentDistanceCount : Math.min(res.pollLast(), currentDistanceCount));
            } else {
                // 找出当前可以跑的路
                List<Path> canPath = new ArrayList<>();
                for (Path path : paths) {
                    if (currentPos.equals(path.start)) {
                        canPath.add(path);
                    }
                }
                Integer elevation = elevations.get(currentPos);
                // 试探每个选择
                for (Path path : canPath) {
                    // 删除此项选择
                    paths.remove(path);
                    Integer targetElevation = elevations.get(path.end);
                    if (targetElevation - elevation > 0) {
                        // 说明是此时要向上跑
                        if (status == 1 || status == 0) {
                            // 此时没有改变方向
                            backtrack(res, elevations, paths, currentDistanceCount + path.distance, path.end, changeDirection, 1);
                        } else if (status == 2) {
                            if (changeDirection > 0) {
                                // 此时改变了方向 但是还有改变方向的次数
                                backtrack(res, elevations, paths, currentDistanceCount + path.distance, path.end, --changeDirection, 1);
                            } else {
                                // 此时改变了方向但不能再改了
                                continue;
                            }
                        }
                    } else if (targetElevation - elevation < 0) {
                        // 说明此时要向下跑
                        if (status == 2 || status == 0) {
                            // 此时没有改变方向
                            backtrack(res, elevations, paths, currentDistanceCount + path.distance, path.end, changeDirection, 2);
                        } else if (status == 1) {
                            if (changeDirection > 0) {
                                // 此时改变了方向 但是还有改变方向的次数
                                backtrack(res, elevations, paths, currentDistanceCount + path.distance, path.end, --changeDirection, 2);
                            } else {
                                continue;
                            }
                        }
                    } else {
                        // 说明此时平走
                        backtrack(res, elevations, paths, currentDistanceCount + path.distance, path.end, changeDirection, status);
                    }
                    // 撤销选择
                    paths.add(path);
                }


            }

        }
    }
}
