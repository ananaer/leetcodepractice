package recursion;

import java.util.*;

public class ShortestPath {
    class Path {
        // ��������
        public String start;
        // ��������
        public String end;
        // ����
        public Integer distance;
    }

    class Solution {
        public int getShortPath(Map<String, Integer> elevations, List<Path> paths) {
            // ����ʹ�û��ݷ�����̽ÿ��ѡ�񲢵ó����·����һ��ѡ��
            Deque<Integer> res = new LinkedList<>();
            backtrack(res, elevations, paths, 0, "Huilongguan", 1, 0);
            return res.pollLast();
        }

        /**
         * ��ȡ��Сֵ
         *
         * @param res                  ���ֵ
         * @param elevations           ����Map
         * @param paths                ·���б�
         * @param currentDistanceCount ��ǰ���ܵľ���
         * @param currentPos           ��ǰ���ڵ�λ��
         * @param changeDirection      ʣ��ɸı䷽��Ĵ���
         * @param status               0 ƽ�� 1 ���� 2����
         */
        private void backtrack(Deque<Integer> res, Map<String, Integer> elevations, List<Path> paths, Integer currentDistanceCount, String currentPos, Integer changeDirection, Integer status) {
            // �Ѿ�����Ŀ�ĵ�
            if ("Huilongguan".equals(currentPos) && currentDistanceCount != 0) {
                res.addLast(res.isEmpty() ? currentDistanceCount : Math.min(res.pollLast(), currentDistanceCount));
            } else {
                // �ҳ���ǰ�����ܵ�·
                List<Path> canPath = new ArrayList<>();
                for (Path path : paths) {
                    if (currentPos.equals(path.start)) {
                        canPath.add(path);
                    }
                }
                Integer elevation = elevations.get(currentPos);
                // ��̽ÿ��ѡ��
                for (Path path : canPath) {
                    // ɾ������ѡ��
                    paths.remove(path);
                    Integer targetElevation = elevations.get(path.end);
                    if (targetElevation - elevation > 0) {
                        // ˵���Ǵ�ʱҪ������
                        if (status == 1 || status == 0) {
                            // ��ʱû�иı䷽��
                            backtrack(res, elevations, paths, currentDistanceCount + path.distance, path.end, changeDirection, 1);
                        } else if (status == 2) {
                            if (changeDirection > 0) {
                                // ��ʱ�ı��˷��� ���ǻ��иı䷽��Ĵ���
                                backtrack(res, elevations, paths, currentDistanceCount + path.distance, path.end, --changeDirection, 1);
                            } else {
                                // ��ʱ�ı��˷��򵫲����ٸ���
                                continue;
                            }
                        }
                    } else if (targetElevation - elevation < 0) {
                        // ˵����ʱҪ������
                        if (status == 2 || status == 0) {
                            // ��ʱû�иı䷽��
                            backtrack(res, elevations, paths, currentDistanceCount + path.distance, path.end, changeDirection, 2);
                        } else if (status == 1) {
                            if (changeDirection > 0) {
                                // ��ʱ�ı��˷��� ���ǻ��иı䷽��Ĵ���
                                backtrack(res, elevations, paths, currentDistanceCount + path.distance, path.end, --changeDirection, 2);
                            } else {
                                continue;
                            }
                        }
                    } else {
                        // ˵����ʱƽ��
                        backtrack(res, elevations, paths, currentDistanceCount + path.distance, path.end, changeDirection, status);
                    }
                    // ����ѡ��
                    paths.add(path);
                }


            }

        }
    }
}
