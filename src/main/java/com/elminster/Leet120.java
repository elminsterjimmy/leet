package com.elminster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet120 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (null == triangle || triangle.isEmpty() || triangle.get(0).isEmpty()) {
            return 0;
        }

        int len = triangle.size();
        int dp[][] = new int[len][len];
        dp[0][0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j > 1 ? j - 1 : 0] + triangle.get(i).get(j), dp[i - 1][j >= i ? i - 1 : j] + triangle.get(i).get(j));
            }
        }

        for (int i = 0; i < len; i++) {
            min = dp[len - 1][i] < min ? dp[len - 1][i] : min;
        }
        return min;
    }

    public static void main(String[] args) {
        // [[2],[3,4],[6,5,7],[4,1,8,3]]

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<Integer>() {{
            add(2);
        }});
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));


        System.out.println(minimumTotal(list));
    }
}
