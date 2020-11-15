package sort;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayByParityII {
    static public int[] sortArrayByParityII(int[] A) {
        if (A.length == 0 || A.length % 2 == 1) {
            return null;
        }

        Integer[] what = Arrays.stream( A ).boxed().toArray( Integer[]::new );
        Arrays.sort(what, (Comparator<Integer>) (o1, o2) -> (o1 - o2));
        for (int i = 0; i < what.length; i++) {
            Integer targetNum = what[i];
            if ((i+1) % 2 == targetNum % 2) {
                continue;
            } else {
                for (int j = i + 1; j < what.length; j++) {
                    Integer tempNum = what[j];
                    if (tempNum % 2 == (i+1) % 2) {
                        what[j] = what[i];
                        what[i] = tempNum;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = what[i];
        }

        return A;
    }

    public static void main(String[] args) {
        int[] temp = new int[]{4,2,5,7};
        sortArrayByParityII(temp);
    }
}
