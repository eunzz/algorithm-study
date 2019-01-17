import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class prb14889 {
    static int n;
    static int[][] matrix;
    static int diff = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        for (int i=0; i<n; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j=0; j<n; j++){
                matrix[i][j] = Integer.parseInt(strs[j]);
            }
        }
        Stack<Integer> s = new Stack<>();
        char[] list = new char[n];
        solve(n/2, s, list);
        System.out.println(diff);
    }
    public static void printMatrix() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static int getSum(Stack<Integer> s) {
//        System.out.println("getSum");
        int res=0;
        for (int i=0; i<s.size(); i++) {
            for (int j=0; j<s.size(); j++) {
//                System.out.println(s.get(i)+ " " + s.get(j));
                res+=matrix[s.get(i)][s.get(j)];
//                System.out.println("res:"+res);
            }
        }
        return res;
    }
    public static void printStack(Stack<Integer> s) {
        for (int i=0; i<s.size(); i++) {
            System.out.print(s.get(i));
        }
        System.out.println();
    }
    public static void solve(int toPick, Stack<Integer> s, char[] list) {
        if (toPick==0) {
            Stack<Integer> r = new Stack<>();
            for (int i=0; i<n; i++) {
                if (list[i]==0) r.push(i);
            }
            int start = getSum(s); int link = getSum(r);
//            printStack(s); System.out.println(start);
            if (Math.abs(start-link)<diff) diff = Math.abs(start-link);
            return;
        }
        int smallest = s.empty()?0:s.peek()+1;
        for (int i=smallest; i<n; i++) {
            s.push(i);
            list[i] = 1;
            solve(toPick-1, s, list);
            s.pop();
            list[i] = 0;
        }
    }
}
