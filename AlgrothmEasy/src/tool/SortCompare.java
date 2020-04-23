package tool;

import sort.base.ISort;

import java.util.List;
import java.util.Random;

public class SortCompare {
    public void compare(List<ISort> sorts, int seed) {
        for (ISort sort : sorts) {
            int[] s = createNum(seed);
            TimeWatch.start();
            sort.sortArray(s);
            long time = TimeWatch.stop();
            System.out.println(sort.name() + "wast time" + time);
        }
    }

    private int[] createNum(int num) {
        int[] result = new int[num];
        Random r = new Random();
        for (int i = 0; i < num; i++) {
            final int temp = r.nextInt(num);
            result[i] = temp;
        }
        return result;
    }

}
