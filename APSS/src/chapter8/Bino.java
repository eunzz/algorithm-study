package chapter8;

public class Bino {
    static int[][] bino;
    public static int slowBino(int n,int r) {
        if (n==r||r==0) return 1;
        return slowBino(n-1, r-1)+slowBino(n-1, r);
    }
    public static int fastBino(int n, int r) {
        if (n==r||r==0) return 1;
        if (bino[n][r]!=0) return bino[n][r];
        return bino[n][r] = fastBino(n-1, r-1)+fastBino(n-1, r);
    }
}
