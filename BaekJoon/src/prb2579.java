import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prb2579 {
    static int N;
    static int stairs[];
    static int scores[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N];
        scores = new int[N];
        for (int i=0; i<N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        scores[0] = stairs[0];
        System.out.println(solve(N-1, true));
//        for (int i=0; i<N; i++)  {
//            System.out.println(scores[i]);
//        }
    }
//    1, 2 칸 둘 다 가능하면 T,  아니면 F
    public static int solve(int n, boolean flag) {
        if (n<0) return 0;
        if (n==0) return scores[0];
        if (flag) {
            if (scores[n]!=0) return scores[n];
            return scores[n] = stairs[n]+Math.max(solve(n-1, !flag), solve(n-2, flag));
        }
        else return stairs[n] + solve(n-2, !flag);
    }
}