import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardCover {
    static int testcase;
    static int H; static int W;
    static char[][] board;
    static block[] blocks = new block[4];
    static int res=0;
    public static void main(String args[]) throws IOException {
        blocks[0] = new block(new int[][]{{0,0}, {1,0}, {0,1}});
        blocks[1] = new block(new int[][]{{0,0}, {1,0}, {1,1}});
        blocks[2] = new block(new int[][]{{0,0}, {0,1}, {1,1}});
        blocks[3] = new block(new int[][]{{0,0}, {0,1}, {-1,1}});

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());
        for (int test=0; test<testcase; test++) {
            String[] strs = br.readLine().split(" ");
            H = Integer.parseInt(strs[0]); W = Integer.parseInt(strs[1]);
            board = new char[H][W];
            for (int i=0; i<H; i++) {
                String str = br.readLine();
                for (int j=0; j<W; j++) {
                    board[i][j] = str.charAt(j);
                }
            }
            solve();
        }
    }
    public static int[] getStart() {
        int r = -1; int c = -1;
        for (int row=0; row<H; row++) {
            for (int col=0; col<W; col++) {
                if (board[row][col]=='.') {
                    r = row; c = col; return new int[] {r, c};
                }
            }
        }
        return new int[] {r, c};
    }
    public static void solve() {
        int[] start = getStart();
        int row=start[0]; int col=start[1];
        if (row==-1&&col==-1) {
            res++;
            return;
        }
        for (int b=0; b<4; b++) {
            block block = blocks[b];
            cover(row, col, block.b, '#');
            solve();
            cover(row, col, block.b, '.');
        }
    }
    public static void cover(int row, int col, int[][] block, char c) {
        for (int i=0; i<3; i++) {
             row += block[i][0];
            col += block[i][1];
            if (row>=H||col>=W) return;
        }
        for (int i=0; i<3; i++) {
            row += block[i][0];
            col += block[i][1];
            board[row][col] = c;
        }
    }
}
class block {
    int[][] b;
    public block(int[][] block) {
        this.b = block;
    }
}
