package jianzhioffer;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void sort(int[] arrays){
        sort(arrays,0, arrays.length);
    }

    /**
     * 对[begin,end)进行排序
     * @param begin
     * @param end
     */
    private static  void sort(int[] arrays, int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        // 轴点
        int mid = pivotIndex(arrays, begin, end);
        sort(arrays, 0, mid);
        sort(arrays, mid + 1, end);
    }

    /**
     * 计算出轴点元素
     * @param arrays
     * @param begin
     * @param end
     * @return
     */
    private static  int pivotIndex(int[] arrays, int begin, int end) {
        // 先记录下轴点元素
        int pivot = arrays[begin];
        // 将end指向最后一个元素
        end--;
        while (begin < end) {
            while (begin < end) {
                if (arrays[end] > pivot) {
                    // 右边元素大于轴点元素
                    end--;
                } else {
                    arrays[begin++] = arrays[end];
                    break;
                }
            }
            while (begin < end) {
                if (arrays[begin] < pivot) {
                    // 左边元素小于轴点元素
                    begin++;
                } else {
                    arrays[end--] = arrays[begin];
                    break;
                }
            }
        }
        // 此时begin=end
        arrays[begin] = pivot;
        return begin;
    }


    public static void main(String[] args) {
        int[] arrays = new int[]{2, 32, 24, 12, 4, 645, 234, 231, 123, 6, 567, 2312, 53446, 4, 23, 24, 90};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
