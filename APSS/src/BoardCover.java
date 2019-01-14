import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardCover {
    static int testcase;
    static int H; static int W;
    static int[][] board;
    static block[] blocks = new block[4];
    static int res=0;
    public static void main(String args[]) throws IOException {
        blocks[0] = new block(new int[][]{{0,0}, {1,0}, {0,1}});
        blocks[1] = new block(new int[][]{{0,0}, {1,0}, {1,1}});
        blocks[2] = new block(new int[][]{{0,0}, {0,1}, {1,1}});
//        blocks[3] = new block(new int[][]{{0,0}, {0,1}, {-1,1}});
//        ㄴ block 좌표 표시 잘못했음
        blocks[3] = new block(new int[][]{{0,0}, {1,0}, {1,-1}});

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine().trim());
        for (int test=0; test<testcase; test++) {
            String[] strs = br.readLine().split(" ");
            H = Integer.parseInt(strs[0]); W = Integer.parseInt(strs[1]);
            board = new int[H][W];
            int cnt = 0;
            for (int i=0; i<H; i++) {
                String str = br.readLine();
                for (int j=0; j<W; j++) {
                    if (str.charAt(j)=='#') board[i][j] = 1;
                    else {
                        cnt++;
                        board[i][j] = 0;
                    }
                }
            }
            if (cnt%3==0) solve();
            System.out.println(res);
            res = 0;
        }
    }
    public static int[] getStart() {
        int r = -1; int c = -1;
        for (int row=0; row<H; row++) {
            for (int col=0; col<W; col++) {
                if (board[row][col]==0) {
                    r = row; c = col; return new int[] {r, c};
                }
            }
        }
        return new int[] {r, c};
    }
    public static void solve() {
        int[] start = getStart();
        int row=start[0]; int col=start[1];
        if (row==-1) {
            res++;
            return;
        }
        for (int b=0; b<4; b++) {
            block block = blocks[b];
            if (cover(row, col, block.b, 1)) {
                solve();
            }
            cover(row, col, block.b, -1);
        }
    }
    public static boolean cover(int row, int col, int[][] block, int c) {
        boolean ok=true;
        for (int i=0; i<3; i++) {
            int newrow = row+ block[i][0];
            int newcol = col+ block[i][1];
            if (newrow>=H||newrow<0||newcol>=W||newcol<0) ok=false;
            else if ((board[newrow][newcol] += c) > 1) ok = false;
        }
        return ok;
    }
    public static void printBoard() {
        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
class block {
    int[][] b;
    public block(int[][] block) {
        this.b = block;
    }
}
