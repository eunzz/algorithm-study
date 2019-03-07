import java.util.*;
public class Main{
    public static int mod = 10000000;
    public static long[][] p = new long[101][101];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<101; i++)
            for(int j=0; j<101; j++)
                p[i][j] = -1;
        int num_test = sc.nextInt();
        int n;
        for(int i=0; i<num_test; i++){
            n = sc.nextInt();
            f(n); //number of polyomino from n squares
        }
    }
    public static void f(int n){
        long ret = 0;
        for(int first=1; first<= n; first++)
            ret = (ret+poly(n, first))%mod;
        System.out.println(ret);
    }
    public static long poly(int n, int first){
        if(p[n][first]!=-1)
            return p[n][first];
        if(n==first){
            p[n][first] = 1;
            return 1;
        }
        long ret = 0;
        for(int i=1; i<=n-first; i++)
            ret = (ret + poly(n-first, i)*(first+i-1)%mod)%mod;
        p[n][first] = ret;
        return ret;
    }
}
