import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n_test = sc.nextInt();
        int n; int d; int p;
        ArrayList<Integer>[] adj;
        int n_check;
        for(int t=0; t<n_test; t++){
            n = sc.nextInt();
            d = sc.nextInt();
            p = sc.nextInt();
            adj = new ArrayList[n];
            for(int i=0; i<n; i++)
                adj[i] = new ArrayList<Integer>();
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++){
                    if(sc.nextInt()==1){
                        adj[i].add(j);
                    }
                }
            double[] curr = new double[n]; //오늘 갈 수 있는 마을의 확률
            double[] tmp = new double[n];
            int day = 1;
            for(int i:adj[p])
                curr[i] += 1.0/adj[p].size();
            while(++day<=d){
                for(int i=0; i<n; i++)
                    if(curr[i]>0){
                        for(int j:adj[i])
                            tmp[j] += 1.0/adj[i].size()*curr[i];
                    }
                for(int i=0; i<n; i++)
                    curr[i] = tmp[i];
                Arrays.fill(tmp, 0.0);
            }
            n_check = sc.nextInt();
            for(int i=0; i<n_check; i++)
                System.out.printf("%.8f ", curr[sc.nextInt()]);
            System.out.println();
        }
    }
}
