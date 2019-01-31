package chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fence {
    static int testcase;
    static int N;
    static int[] fences;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());
        for (int test=0;test<testcase; test++) {
            N = Integer.parseInt(br.readLine());
            fences = new int[N];
            String[] strs = br.readLine().split(" ");
            for (int i=0; i<N; i++) {
                fences[i] = Integer.parseInt(strs[i]);
            }
            System.out.println(solve());
        }
    }
    public static int solve() {
        int res=0;
        for (int i=0; i<N; i++) {
            res = Math.max(res, getSqaure(i));
        }
        return res;
    }
    public static int getSqaure(int index) {
        int sqaure=0;
        int height = fences[index];
        for (int i=index; i<N; i++) {
//            System.out.println("first for: "+i);
            if (fences[i]>=height) sqaure+= height;
            else break;
        }
        for (int i=index-1; i>=0; i--) {
//            System.out.println("second for: "+i);
            if (fences[i]>=height) sqaure+=height;
            else break;
        }
//        System.out.println("height; "+height+"square: "+sqaure);
        return sqaure;
    }
}
