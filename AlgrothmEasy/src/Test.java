import sort.QuickSort;
import sort.SelectSort;
import sort.base.ISort;
import sort.InsertSort;
import sort.ShellSort;
import sort.base.SystemSort;
import tool.SortCompare;

import java.util.LinkedList;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        ISort sort3 = new QuickSort();
        ISort sort2 = new ShellSort();
        ISort sort1 = new SystemSort();
        SortCompare compare = new SortCompare();
        List<ISort> sorts = new LinkedList<>();
        sorts.add(sort3);
        sorts.add(sort2);
        sorts.add(sort1);
        compare.compare(sorts, 1000 * 10000);
    }
}
