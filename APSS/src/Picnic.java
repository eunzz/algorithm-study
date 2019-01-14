import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Picnic {
    static int testcase;
    static int n;
    static int m;
    static int[][] isFriend;
    static int[] visited;
    static int res=0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine().trim());
        for (int i=0; i<testcase; i++) {
            String[] strs = br.readLine().split(" ");
            n = Integer.parseInt(strs[0]);
            m = Integer.parseInt(strs[1]);
            isFriend = new int[n][n];
            visited = new int[n];
            strs = br.readLine().split(" ");
            for (int j=0; j<2*m; j+=2) {
                isFriend[Integer.parseInt(strs[j])][Integer.parseInt(strs[j+1])] = 1;
                isFriend[Integer.parseInt(strs[j+1])][Integer.parseInt(strs[j])] = 1;
            }
//            printisFriend();
            solve(0);
            System.out.println(res);
            res = 0;
        }
    }
    public static void printVisited() {
        for (int i=0; i<n; i++) {
            System.out.print(visited[i]);
        }
        System.out.println();
    }
    public static void solve(int prev) {
        int start = getStart(prev);
//        System.out.println("func started" + start);
//        System.out.println("visited:"); printVisited();
        if (start==-1) {
            res++; return;
        }
        if (start==-2) return;
        for (int i=start; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (isFriend[i][j]==1&&visited[i]==0&&visited[j]==0) {
                    visited[i] = visited[j] = 1;
                    solve(i);
                    visited[i] = visited[j] = 0;
                }
            }
        }
    }
    public static int getStart(int prev) {
        for (int i=0; i<n; i++) {
            if (visited[i]==0) {
                if (i>=prev) return i;
                else return -2;
            }
        }
        return -1;
    }
    public static void printisFriend() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(isFriend[i][j]);
            }
            System.out.println();
        }
    }
}
