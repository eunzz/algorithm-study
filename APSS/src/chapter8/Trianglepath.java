package chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trianglepath {
    static int testcase;
    static int[][] triangle;
    static int[][] res;
    static int n;
    static int cnt1=0, cnt2 = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());
        while (testcase>0) {
            n = Integer.parseInt(br.readLine());
            triangle = new int[n][n];
            res = new int[n][n];
            for (int i=0; i<n; i++) {
                String strs[] = br.readLine().trim().split("\\s+");
                for (int j=0; j<strs.length; j++) {
                    triangle[i][j] = Integer.parseInt(strs[j]);
                }
            }
            System.out.println(getMax2(0,0));
            res = new int[n][n];
            int res = 0;
            for (int col=n-1; col>=0; col--) {
                res = Math.max(res, getMax(n-1, col));
            }
            System.out.printf("getMax: %d getMax2: %d", cnt1, cnt2);
            testcase--;
        }
    }
    public static void solve(int row, int col) {
        if (row==n-1) return;
        if (col>row) return;
        triangle[row+1][col] += triangle[row][col];
        triangle[row+1][col+1] += triangle[row][col];
        solve(row+1, col); solve(row+1, col+1);
    }
    public static int getMax(int row, int col) {
        cnt1++;
        if (row<0||col<0) return 0;
        if (res[row][col]!=0) return res[row][col];
        return res[row][col] = triangle[row][col] + Math.max(getMax(row-1, col), getMax(row-1, col-1));
    }
    public static int getMax2(int row, int col) {
        cnt2++;
        if (row>=n||col>row) return 0;
        if (res[row][col]!=0) return res[row][col];
        return res[row][col] = triangle[row][col]+Math.max(getMax2(row+1, col), getMax2(row+1, col+1));
    }
}
