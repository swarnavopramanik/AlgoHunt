Question Link 👇

  https://www.hackerrank.com/contests/algohunt/challenges/minimum-loss/problem

// Solution 

import java.io.IOException;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }

    private void run() throws IOException {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[] prices = new long[n];
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextLong();
        }

        long minimalLoss = fasterGetMinimalLoss(n, prices);

        System.out.println(minimalLoss);
    }

    private long fasterGetMinimalLoss(int n, long[] prices) {
        TreeSet<Long> pos = new TreeSet<>();
        long minimalLoss = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long endPrice = prices[i];

            Long biggerPrevious = pos.ceiling(endPrice);
            if (biggerPrevious != null) {
                long loss = biggerPrevious - endPrice;
                if (loss > 0 && loss < minimalLoss) {
                    minimalLoss = loss;
                }
            }
            pos.add(endPrice);
        }

        return minimalLoss;
    }

    private long dummyGetMinimalLoss(int n, long[] prices) {
        long minimalLoss = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long loss = prices[i] - prices[j];
                if (loss > 0 && loss < minimalLoss) {
                    minimalLoss = loss;
                }
            }
        }
        return minimalLoss;
    }


}
