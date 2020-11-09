package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

/**
 *  最接近原点的 K 个点
 */
public class kClosest {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] * o1[0] + o1[1] * o1[1]) -  (o2[0] * o2[0] + o2[1] * o2[1]);
            }
        });
        return Arrays.copyOf(points, K);
    }

    public static void main(String[] args) {
        Integer[] temp = new Integer[]{4,5,6,7,32,65,12,44,56,77};
        Arrays.sort(temp, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < temp.length; i++) {
            System.out.println("~~" + temp[i]);
        }
    }
}
