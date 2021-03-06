import java.util.*;
import java.lang.*;
public class Main{
    public static int n;
    public static int[][] arr;
    public static int[][] mem;
    public static int[][] cnt;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num_test = sc.nextInt();
        for(int t=0; t<num_test; t++){
            n = sc.nextInt();
            arr = new int[n][n];
            mem = new int[n][n];
            cnt = new int[n][n];
            for(int i=0; i<n; i++)
                for(int j=0; j<=i; j++)
                    arr[i][j] = sc.nextInt();
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++){
                    mem[i][j] = -1;
                    cnt[i][j] = -1;
                }
            tripath(0, 0);
            System.out.println(tricnt(0, 0));
        }
    }
    public static int tricnt(int i, int j){
        if(cnt[i][j]!=-1)
            return cnt[i][j];
        if(i==n-1)
            return cnt[i][j] = 1;
        int left = tripath(i+1, j);
        int right = tripath(i+1, j+1);
        if(left<right)
            cnt[i][j] = tricnt(i+1, j+1);
        else if(left>right)
            cnt[i][j] = tricnt(i+1, j);
        else
            cnt[i][j] = tricnt(i+1, j)+tricnt(i+1, j+1);
        return cnt[i][j];
    }
    public static int tripath(int i, int j){
        if(mem[i][j]!=-1)
            return mem[i][j];
        if(i==n-1)
            return mem[i][j] = arr[i][j];
        mem[i][j] = Math.max(tripath(i+1, j), tripath(i+1, j+1)) + arr[i][j];
        return mem[i][j];
    }
}
