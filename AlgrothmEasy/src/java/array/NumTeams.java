package java.array;

/**
 * n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 *
 * 每 3 个士兵可以组成一个作战单位，分组规则如下：
 *
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 *
 *
 * 输入：rating = [2,5,3,4,1]
 * 输出：3
 * 解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
 */

/** 思路：
 *  解法一 ：暴力 时间复杂度 n * n * n;
 *
 *
 */
public class NumTeams {

    /**
     *     解法二 ：以3个数的中间为坐标，时间复杂度 n * n
     */
    public int numTeams(int[] rating) {
        if (rating == null || rating.length < 3) {
            return 0;
        }

        int result = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int leftUp = 0, rightUp = 0, leftDown = 0, rightDown = 0;
            for (int j = 0; j < rating.length; j++) {
                if (j < i) {
                    if (rating[j] < rating[i]) {
                        leftDown++;
                    } else {
                        leftUp++;
                    }
                }
                if (j > i) {
                    if (rating[j] < rating[i]) {
                        rightDown++;
                    } else {
                        rightUp++;
                    }
                }
             }
             // 统计升序
             result = result + (leftDown * rightUp);
             // 统计降序
             result = result + (rightDown * leftUp);
        }
        return result;
    }
}
