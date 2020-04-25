package other;

import base.AlgorithmBase;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（提示： A?B:C）。
 *1 <= n <= 10000
 */
public class SumNumber extends AlgorithmBase {
    @Override
    protected void doExecute() {

    }

    //解法一
    public int sumNums1(int n) {
        return (n > 0 ? n + sumNums1(n-1) : 0);
    }

    //解法二 如果不能用 A ？ B: C 形式
    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
