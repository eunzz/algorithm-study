import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num_test = sc.nextInt();
        int mod = 1000000007;
        int[] mem = new int[101];
        mem[0] = mem[1] = 1;
        for(int i=2; i<101; i++)
            mem[i] = (mem[i-1] + mem[i-2]) % mod;
        
        int n;
        int ret;
        for(int t=0; t<num_test; t++){
            n = sc.nextInt();
            if(n==1 || n==2){
                System.out.println(0);
                continue;
            }
            if(n%2==1){
                ret = (mem[n]-mem[n/2]+mod) % mod;
            }else{
                ret = (mem[n]-mem[n/2]+mod) % mod;
                ret = (ret-mem[n/2-1]+mod) % mod;
            }
            System.out.println(ret);
        }
    }
}
