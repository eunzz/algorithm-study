package chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Wildcard {
    static int testcase;
    static String wildcard;
    static String file;
    static int N;
    public static void main(String args[]) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());
        for (int test=0; test<testcase; test++) {
            wildcard = br.readLine();
            N = Integer.parseInt(br.readLine());
            for (int i=0; i<N; i++) {
                file = br.readLine();
                if (match(0, 0)) {
                    list.add(file);
                }
            }
        }
        Collections.sort(list);
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public static boolean match(int w, int f) {
        if (w>=wildcard.length()) {
            if (f<file.length()) return false;
            return true;
        }
        if (wildcard.charAt(w)=='*') {
            if (w==wildcard.length()-1) return true;
            for (; w<wildcard.length()&&wildcard.charAt(w)=='*'; w++);
            for (int i=f; i<file.length(); i++) {
                if (wildcard.charAt(w)==file.charAt(i)||wildcard.charAt(w)=='?') return match(w, i);
            }
            return false;
        }
        if (wildcard.charAt(w)=='?'||wildcard.charAt(w)==file.charAt(f)) {
            return match(++w, ++f);
        }
        return false;
    }
}