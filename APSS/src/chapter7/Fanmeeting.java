package chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Fanmeeting {
    static int testcase;
    static int idolNum;
    static int fanNum;
    static Stack<Integer> idols;
//    static Stack<Integer> fans;
    static String fans;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());
        for (int test=0; test<testcase; test++) {
            idols=new Stack<Integer>();
            String str = br.readLine();
            idolNum = str.length();
            for (int i=0; i<idolNum; i++) {
                if (str.charAt(i)=='M') idols.push(i);
            }
            fans = br.readLine();
            fanNum = fans.length();
            System.out.println(fanNum-idolNum+1-solve2());
        }

    }
    public static boolean cantHug(int offset) {
        for (int i=0; i<idols.size(); i++) {
            if (fans.charAt(offset+idols.get(i))=='M') return true;
        }
        return false;
    }
    public static int solve2() {
        if (idols.size()==0) return 0;
        int offset=0;
        int canthug=0;
        while (offset<=(fanNum-idolNum)) {
            if (cantHug(offset)) canthug++;
            offset++;
        }
        return canthug;
    }
//    public static void solve() {
//        int offset = 0;
//        while (offset<=(fanNum-idolNum)) {
//            boolean allHug=true;
//            for (int i=0; i<idolNum; i++) {
//                if (idols[i]=='M'&&fans[i+offset]=='M') {
//                    allHug = false;
//                    break;
//                }
//            }
//            if (allHug) res++;
//            offset++;
//        }
//    }
}
