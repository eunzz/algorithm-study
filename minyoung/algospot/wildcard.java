import java.util.*;
public class Main{
    public static int s_size;
    public static int w_size;
    public static String W;
    public static String S;
    public static int[][] mem;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num_test = Integer.parseInt(sc.nextLine());
        for(int t=0; t<num_test; t++){
            W = sc.nextLine();
            w_size = W.length();
            int num_file = Integer.parseInt(sc.nextLine());
            ArrayList<String> matched = new ArrayList<String>();
            for(int i=0; i<num_file; i++){
                S = sc.nextLine();
                s_size = S.length();
                mem = new int[w_size+1][s_size+1];
                for(int a=0; a<w_size+1; a++)
                    for(int b=0; b<s_size+1; b++)
                        mem[a][b] = -1;
                if(match(0, 0)==1)
                    matched.add(S);
            }
            Collections.sort(matched);
            for(int i=0; i<matched.size(); i++)
                System.out.println(matched.get(i));
        }
    }
    public static int match(int w, int s){
        if(mem[w][s] != -1)
            return mem[w][s];
        while(s<s_size && w<w_size && (W.charAt(w)=='?' || W.charAt(w)==S.charAt(s))){
            w++;
            s++;
        }
        if(w == w_size)
            if(s==s_size)
                return mem[w][s]=1;
            else
                return mem[w][s]=0;
        if(W.charAt(w)=='*'){
            for(int i=0; i+s<=s_size; i++){
                if(match(w+1, s+i)==1){
                    return mem[w][s] = 1;
                }
            }
        }
        return mem[w][s] = 0;
    }
}
