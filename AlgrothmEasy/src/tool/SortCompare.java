package tool;

import sort.ISort;

public class SortCompare {
    public void compare(ISort sort1, ISort sort2, int seed) {
        int[] a = createNum(seed);
        TimeWatch.start();
        sort1.sortArray(a);
        long time1 = TimeWatch.stop();

        TimeWatch.start();
        sort1.sortArray(a);
        long time2 = TimeWatch.stop();

        System.out.println(sort1.name() + "wast time" + time1);
        System.out.println(sort2.name() + "wast time" + time2);
    }

    private int[] createNum(int num) {
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            final double d = Math.random();
            final int temp = (int)(d);
            result[i] = temp;
        }
        return result;
    }

}
