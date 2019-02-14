package chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LIS {
    static int testcase;
    static int n;
    static int seq[];
    static int subseq[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());
        while (testcase>0) {
            n = Integer.parseInt(br.readLine());
            seq = new int[n]; subseq = new int[n];
            String[] strs = br.readLine().split(" ");
            for (int i=0; i<n; i++) {
                seq[i] = Integer.parseInt(strs[i]);
            }
            int ret = 0;
            for (int i=0; i<n; i++) {
                ret = Math.max(ret, getLength(i));
            }
            System.out.println(ret);
            testcase--;
        }
    }
//    감소하는 수에 대해서는 생각할 필요 없이 걍 넘김-> key
//    모든 걸 다 계산할 필요 없이, 증가하는수만 생각하면 됨.
    public static int getLength(int pos) {
//        if (pos>=n) return 0;
        if (subseq[pos]!=0) return subseq[pos];
        subseq[pos]++;
        for (int incr=0; incr+pos<n; incr++) {
            if (seq[pos]<seq[pos+incr]) subseq[pos] = Math.max(subseq[pos], getLength(pos+incr)+1);
        }
        return subseq[pos];
    }
}
