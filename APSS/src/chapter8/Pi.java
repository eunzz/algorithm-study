package chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pi {
    static int testcase;
    static String pi;
    static int[] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());
        while (testcase>0) {
            pi = br.readLine();
            dp = new int[pi.length()];
//            System.out.println(getLevel(0, 4));
            System.out.println(solve(0));
//            if (solve(0)!=answers[50-testcase]) System.out.printf("false at %d", 50-testcase);
            testcase--;
        }
    }
//    1234 1234
    public static int solve(int begin) {
//        System.out.println("func begin"+begin);
        if (begin==pi.length()) return 0;
//        if (begin>pi.length()||pi.length()-begin<3) return 20000;
        if (dp[begin]!=0) return dp[begin];
        dp[begin] = 20000;
        for (int length=3; length<=5; length++) {
            if (begin+length<=pi.length()) {
                dp[begin] = Math.min(dp[begin], getLevel2(begin, length)+solve(begin+length));
            }
//            int level = getLevel(begin, length);
////            System.out.println(begin+" "+length+" "+level);
//            int temp = level+solve(begin+length);
////            System.out.println(temp);
//            dp[begin] = Math.min(dp[begin], temp);
////            System.out.println(res);
        }
        return dp[begin];
    }
    public static int getLevel(int pos, int length) {
        if (pos+length>pi.length()) return 20000;
        int fst = toInteger(pi.charAt(pos));
        int snd = toInteger(pi.charAt(1+pos));
        int thd = toInteger(pi.charAt(2+pos));

//        1
        if (fst==snd&&snd==thd) {
            for (int i=3+pos; i<pos+length; i++) {
                if (fst!=toInteger(pi.charAt(i))) return 10;
            }
            return 1;
        }
//        2
        if (Math.abs(fst-thd)==2){
            int diff= snd-fst;
            for (int i=3+pos; i<pos+length; i++) {
                if (toInteger(pi.charAt(i))-toInteger(pi.charAt(i-1))!=diff) return 10;
            }
            return 2;
        }
//        3
        if (fst==thd){
            for (int i=3+pos; i<pos+length; i++) {
                if (i%2==1) {
                    if (snd!=toInteger(pi.charAt(i))) return 10;
                } else {
                    if (fst!=toInteger(pi.charAt(i))) return 10;
                }
            }
            return 4;
        }
//        4
        if (fst+thd==2*snd){
            int diff = snd-fst;
            for (int i=3+pos; i<pos+length; i++) {
                if (toInteger(pi.charAt(i))-toInteger(pi.charAt(i-1))!=diff) return 10;
            }
            return 5;
        }
        return 10;
    }
    public static int getLevel2(int pos, int length) {
//        1(diff=0), 2(diff=-1 or 1), 4(diff = something else)
        int diff = toInteger(pi.charAt(pos+1))-toInteger(pi.charAt(pos));
        boolean flag = true;
        for (int i=pos+2; i<pos+length; i++) {
            if (diff!=toInteger(pi.charAt(i))-toInteger(pi.charAt(i-1))) {
                flag = false; break;
            }
        }
        if (flag) {
            if (diff==0) return 1;
            if (diff==-1||diff==1) return 2;
            return 5;
        }
//        3: 번갈아가며 출현
        for (int i=pos+2; i<pos+length; i++) {
            if (pi.charAt(i)!=pi.charAt(i-2)) {
                flag = true; break;
            }
        }
        if (!flag) return 4;
        else return 10;
    }
    public static int toInteger(char c) {
        return c - '0';
    }
}
