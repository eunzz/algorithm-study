package chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Quantization {
    static int testcase;
    static int n, s;
    static int[] nums;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());
        while (testcase>0) {
            String [] strs = br.readLine().split("\\s+");
            n = Integer.parseInt(strs[0]); s = Integer.parseInt(strs[1]);
            nums = new int[n];
            strs = br.readLine().split("\\s+");
            for (int i=0; i<n; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            Arrays.sort(nums);
//            System.out.println(calError(0, 3));
            System.out.println(solve(0, s));
            testcase--;
        }
    }
    public static int solve(int start, int leftS) {
//        if (leftS==0) return 0;
        int Error = Integer.MAX_VALUE;
        for (int size=1; size<=leftS; size++) {
            if (start+size<n) {
                int curError = calError(start, size);
                Error = Math.min(curError+solve(start+size, leftS-1), Error);
                System.out.println("for "+start+ " "+leftS+" "+Error);
            }
        }
        return Error;
    }
    public static int calError(int start, int size) {
        double sum = partialSum(start+size-1) - partialSum(start-1);
        int mean = (int)Math.round(sum/size);
        int sqr = sqr(start+size-1)-sqr(start-1);
        return sqr - 2*mean*(int)sum + (size)*mean*mean;
    }
    public static int partialSum(int a) {
        if (a<0) return 0;
        return nums[a]+partialSum(a-1);
    }
    public static int sqr(int a) {
        if (a<0) return 0;
        return nums[a]*nums[a]+sqr(a-1);
    }
}