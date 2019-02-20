import java.util.*;
import java.lang.*;
public class Main{
    public static int[] arr;
    public static int n;
    public static int s;
    public static int[] cu_sum;
    public static int[] cu_sqsum;
    public static int[][] q = new int[101][11];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int i=0; i<test_case; i++){
            n = sc.nextInt();
            s = sc.nextInt();
            arr = new int[n];
            for(int j=0; j<n; j++)
                arr[j] = sc.nextInt();
            Arrays.sort(arr);
            
            cu_sum = new int[n];
            cu_sqsum = new int[n];
            cu_sum[0] = arr[0];
            cu_sqsum[0] = arr[0]*arr[0];
            for(int j=1; j<n; j++){
                cu_sum[j] += cu_sum[j-1] + arr[j];
                cu_sqsum[j] += cu_sqsum[j-1] + arr[j]*arr[j];
            }
            for(int a=0; a<101; a++)
                for(int b=0; b<11; b++)
                    q[a][b] = -1;
            System.out.println(quant(0, s));
        }
    } 
    public static int minerr(int lo, int hi){
        if(arr[lo]==arr[hi])
            return 0;
        int err = Integer.MAX_VALUE;
        int sum = (lo==0)? cu_sum[hi] : (cu_sum[hi]-cu_sum[lo-1]);
        int sqsum = (lo==0)? cu_sqsum[hi] : (cu_sqsum[hi]-cu_sqsum[lo-1]);
        for(int i=arr[lo]; i<=arr[hi]; i++)
            err = Math.min(err, sqsum -2*i*sum + (hi-lo+1)*i*i);
        //System.out.println("err : "+err);
        return err;
    }
    public static int quant(int start, int x){
        if(start==n)
            return 0;
        if(x==0)
            return 987654321;
        if(q[start][x]!=-1)
            return q[start][x];
        int ret = 987654321;
        for(int part=0; start+part<n; part++){
            ret = Math.min(ret , minerr(start, start+part) + quant(start+part+1, x-1));
        }
        q[start][x] = ret;
        return ret;
    }
}
