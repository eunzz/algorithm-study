package chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snail {
    static int testcase;
    static int n, m;
    final static double RAINY = 0.75;
    final static double SUNNY = 0.25;
    static double[][] dp = new double[1001][1001];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());
        while (testcase>0) {
            String[] strs = br.readLine().split(" ");
            n = Integer.parseInt(strs[0]);
            m = Integer.parseInt(strs[1]);
            System.out.println(snail(n, m));
            testcase--;
        }
    }
    public static double snail(int wellDepth, int rainySeason) {
//        System.out.printf("WELL: %d, RainySeasonLeft: %d\n", wellDepth, rainySeason);
        if (wellDepth<=0) return 1;
        if (rainySeason==0) return 0;
        if (dp[wellDepth][rainySeason]!=0) return dp[wellDepth][rainySeason];
        return dp[wellDepth][rainySeason] = SUNNY*snail(wellDepth-1, rainySeason-1)+RAINY*snail(wellDepth-2, rainySeason-1);
    }
}
