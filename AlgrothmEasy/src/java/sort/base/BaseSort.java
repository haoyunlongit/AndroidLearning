package java.sort.base;
import java.base.AlgorithmBase;

public abstract class BaseSort extends AlgorithmBase implements ISort {
    @Override
    protected void doExecute() {
        int[] num = new int[]{1};

        sortArray(num);
    }

    @Override
    public abstract int[] sortArray(int[] nums);
}
