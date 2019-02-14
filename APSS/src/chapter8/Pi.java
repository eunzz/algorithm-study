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
//            System.out.println(getLevel(0, 5));
            System.out.println(solve(0));
            testcase--;
        }
    }
//    1234 1234
    public static int solve(int begin) {
//        System.out.println("func begin"+begin);
        if (begin==pi.length()) return 0;
        if (begin>pi.length()||pi.length()-begin<3) return 20000;
        int res = 20000;
        for (int length=3; length<=5; length++) {
            int level = getLevel(begin, length);
//            System.out.println(begin+" "+length+" "+level);
            int temp = level+solve(begin+length);
//            System.out.println(temp);
            res = Math.min(res, temp);
//            System.out.println(res);
        }
        return res;
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
                if (i%2==0) {
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
    public static int toInteger(char c) {
        return c - '0';
    }
}
