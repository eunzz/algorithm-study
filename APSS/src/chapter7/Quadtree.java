package chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quadtree {
    static int testcase;
    static int pointer=0;
    static String[] res = {"w",
            "xwbbw",
            "xxbwwbbbw",
            "xxwbxwwxbbwwbwbxwbwwxwwwxbbwb"};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine().trim());
        for (int test=0; test<testcase; test++) {
            String input = br.readLine();
            System.out.println(solve2(input));
            pointer = 0;
        }
    }
    public static String solve2(String input) {
//        System.out.println("func"+pointer);
        if (input.charAt(pointer)!='x') return input;
        String[] inputs = new String[4];
        for (int i=0; i<4; i++) {
            pointer++;
            if (input.charAt(pointer)=='x') {
                inputs[i] = solve2(input);
            } else {
                inputs[i] = input.charAt(pointer)+"";
            }
        }
//        System.out.println("ret"+pointer);
        String res = 'x'+inputs[2]+inputs[3]+inputs[0]+inputs[1];
        return res;
    }
    public static String solve(String input) {
        if (input.charAt(0)!='x') return input;
        String[] inputs = new String[4];
        for (int i=1; i<5; i++) {
            if (input.charAt(i) == 'x') {
                inputs[i - 1] = solve(input.substring(i));
            }
            else {
                inputs[i - 1] = input.charAt(i) + "";
            }
        }
        String res = 'x'+inputs[2]+inputs[3]+inputs[0]+inputs[1];
        return res;
    }
}