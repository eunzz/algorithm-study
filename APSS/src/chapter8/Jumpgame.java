package chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jumpgame {
    static int testcase;
    static int n;
    static int[][] board;
    static boolean isReachable=false;
    static boolean[][] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());
        for (int test=0; test<testcase; test++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            visited = new boolean[n][n];
            for (int i=0; i<n; i++) {
                String[] strs = br.readLine().split(" ");
                for (int j=0; j<n; j++) {
                    board[i][j] = Integer.parseInt(strs[j]);
                }
            }
            solve(0, 0);
            if (isReachable) System.out.println("YES");
            else System.out.println("NO");
            isReachable = false;
        }
    }
    public static void solve(int row, int col) {
        if (row<0||row>=n||col<0||col>=n) return;
        if (row==n-1&&col==n-1) {
            isReachable = true;
            return;
        }
        if (visited[row][col]) return;
        visited[row][col] = true;
        int incr = board[row][col];
        solve(row+incr, col); solve(row, col+incr);
        return;
    }
}
