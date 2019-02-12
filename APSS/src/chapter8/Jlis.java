package chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Jlis {
    static int testcase;
    static int a, b;
    static ArrayList<Integer> A = new ArrayList<>();
    static ArrayList<Integer> B = new ArrayList<>();
    static int[][] length;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());
        while (testcase>0) {
            String[] strs = br.readLine().split(" ");
            a = Integer.parseInt(strs[0]);
            b = Integer.parseInt(strs[1]);
//            length[i][j] 는 A의 i번째 이후의 수열과 B j번쨰 이후 수열의
//            JLIS 값.
            length = new int[a][b];
            strs = br.readLine().split( " ");
            for (int i=0; i<a; i++) {
                A.add(Integer.parseInt(strs[i]));
            }
            strs = br.readLine().split(" ");
            for (int i=0; i<b; i++) {
                B.add(Integer.parseInt(strs[i]));
            }
//            ArrayList<Integer> list = lis(A);
//            for (int i=0; i<list.size(); i++) {
//                System.out.print(list.get(i)+" ");
//            }
            System.out.println(jlis(0, 0));
            for (int i=0; i<a; i++) {
                for (int j=0; j<b; j++) {
                    System.out.print(length[i][j]+" ");
                }
                System.out.println();
            }
            testcase--;
        }
    }
//    2 10 20 30 1;
//    10 20 30;
    public static int jlis(int posA, int posB) {
//        A가 먼저 끝남 | B가 먼저 끝남 | A, B 동시에 끝남.
        if (posA>=a&&posB>=b) return 0;
        if (posA>=a);
        if (posB>=b);
//            posA보다 i 가 더 커야 한다.
//            posB보다 j가 더 커야 한다.
//            i와 j 사이의 대소관계를 체크해야 한다.
        for (int i=posA; i+posA<a; i++) {
            for (int j=posB; j+posB<b; j++) {
                if (A.get(i)<B.get(j)) {
                    if (A.get(posA)<A.get(i)) {
                        length[posA][posB] = Math.max(length[posA][posB], jlis(i, j));
                    }
                }
                else {

                };
            }
        }
        return length[posA][posB];
    }
}
