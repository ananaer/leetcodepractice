package jianzhioffer;

import java.util.Arrays;

/**
 * ��������
 */
public class QuickSort {
    public static void sort(int[] arrays){
        sort(arrays,0, arrays.length);
    }

    /**
     * ��[begin,end)��������
     * @param begin
     * @param end
     */
    private static  void sort(int[] arrays, int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        // ���
        int mid = pivotIndex(arrays, begin, end);
        sort(arrays, 0, mid);
        sort(arrays, mid + 1, end);
    }

    /**
     * ��������Ԫ��
     * @param arrays
     * @param begin
     * @param end
     * @return
     */
    private static  int pivotIndex(int[] arrays, int begin, int end) {
        // �ȼ�¼�����Ԫ��
        int pivot = arrays[begin];
        // ��endָ�����һ��Ԫ��
        end--;
        while (begin < end) {
            while (begin < end) {
                if (arrays[end] > pivot) {
                    // �ұ�Ԫ�ش������Ԫ��
                    end--;
                } else {
                    arrays[begin++] = arrays[end];
                    break;
                }
            }
            while (begin < end) {
                if (arrays[begin] < pivot) {
                    // ���Ԫ��С�����Ԫ��
                    begin++;
                } else {
                    arrays[end--] = arrays[begin];
                    break;
                }
            }
        }
        // ��ʱbegin=end
        arrays[begin] = pivot;
        return begin;
    }


    public static void main(String[] args) {
        int[] arrays = new int[]{2, 32, 24, 12, 4, 645, 234, 231, 123, 6, 567, 2312, 53446, 4, 23, 24, 90};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
