package java.plan;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int total = 0;
        int buy = 0;
        int sell = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (buy == 0 && prices[i + 1] > prices[i]) {
                buy = prices[i];
            }

            if (sell == 0 && prices[i + 1] < prices[i]) {
                sell = prices[i];
            }

            if (buy != 0 && sell != 0) {
                total = (sell - buy);
                sell = 0;
                buy = 0;
            }
        }
        if (buy != 0 && sell == 0) {
            total += (prices[prices.length - 1] - buy);
        }

        return total;
    }

    public static void main(String[] args) {

    }
}
