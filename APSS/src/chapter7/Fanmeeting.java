package chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fanmeeting {
    static int testcase;
    static int idolNum;
    static int fanNum;
    static char[] idols;
    static char[] fans;
    static int res=0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());
        for (int test=0; test<testcase; test++) {
            String str = br.readLine();
            idolNum = str.length();
            idols = new char[idolNum];
            for (int i=0; i<idolNum; i++) {
                idols[i] = str.charAt(i);
            }
            str = br.readLine();
            fanNum = str.length();
            fans = new char[fanNum];
            for (int i=0; i<fanNum; i++) {
                fans[i] = str.charAt(i);
            }
            solve();
            System.out.println(res);
            res = 0;
        }

    }
    public static void solve() {
        int offset = 0;
        while (offset<=(fanNum-idolNum)) {
            boolean allHug=true;
            for (int i=0; i<idolNum; i++) {
                if (idols[i]=='M'&&fans[i+offset]=='M') {
                    allHug = false;
                    break;
                }
            }
            if (allHug) res++;
            offset++;
        }
    }
}
