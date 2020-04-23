import base.AlgorithmBase;
import sort.ISort;
import sort.InsertSort;
import sort.SelectSort;
import tool.SortCompare;


public class Test {
    public static void main(String[] args) {
        ISort sort1 = new SelectSort();
        ISort sort2 = new InsertSort();
        SortCompare compare = new SortCompare();
        compare.compare(sort1, sort2, 1000 * 1000);
    }
}
