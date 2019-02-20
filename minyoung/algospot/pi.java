import java.util.*;
public class Main{
    public static String s;
    public static int s_len;
    public static int[][] m_sum;
    public static int[][] m;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num_test = Integer.parseInt(sc.nextLine());
        for(int t=0; t<num_test; t++){
            s = sc.nextLine();
            s_len = s.length();
            m_sum = new int[s_len][3];
            m = new int[s_len][3];
            for(int i=0; i<7; i++)
                for(int j=0; j<3; j++)
                    m_sum[i][j] = Integer.MAX_VALUE;
                    
            check(2, 3); m_sum[2][0] = m[2][0];
            check(3, 4); m_sum[3][1] = m[3][1];
            check(4, 5); m_sum[4][2] = m[4][2];
            check(5, 3); m_sum[5][0] = m[2][0]+m[5][0];
            check(6, 3); m_sum[6][0] = m[3][1]+m[6][0];
            check(6, 4); m_sum[6][1] = m[2][0]+m[6][1];
            
            for(int i=7; i<s_len; i++){
                check(i, 3); m_sum[i][0] = min(m_sum[i-3]) + m[i][0];
                check(i, 4); m_sum[i][1] = min(m_sum[i-4]) + m[i][1];
                check(i, 5); m_sum[i][2] = min(m_sum[i-5]) + m[i][2];
            }
            System.out.println( min(m_sum[s_len-1]) );
        }
    }
    public static void check(int i, int d){
        char[] x = s.substring(i-d+1, i+1).toCharArray();
        if(d==3){
            if(x[0]==x[1] && x[1]==x[2])
                m[i][0] = 1;
            else if((x[0]-x[1]==1 && x[1]-x[2]==1) || x[0]-x[1]==-1 && x[1]-x[2]==-1)
                m[i][0] = 2;
            else if(x[0]==x[2])
                m[i][0] = 4;
            else if(x[0]-x[1]==x[1]-x[2])
                m[i][0] = 5;
            else
                m[i][0] = 10;
            return;
        }if(d==4){
            if(m[i-1][0]==1 && x[2]==x[3])
                m[i][1] = 1;
            else if(m[i-1][0]==2 && (x[1]-x[2]==x[2]-x[3]))
                m[i][1] = 2;
            else if(m[i-1][0]==4 && x[1]==x[3])
                m[i][1] = 4;
            else if(m[i-1][0]==5 && (x[1]-x[2]==x[2]-x[3]))
                m[i][1] = 5;
            else
                m[i][1] = 10;
            return;
        } // d==5
        if(m[i-1][1]==1 && x[3]==x[4])
            m[i][2] = 1;
        else if(m[i-1][1]==2 && (x[2]-x[3]==x[3]-x[4]))
            m[i][2] = 2;
        else if(m[i-1][1]==4 && x[2]==x[4])
            m[i][2] = 4;
        else if(m[i-1][1]==5 && (x[2]-x[3]==x[3]-x[4]))
            m[i][2] = 5;
        else
            m[i][2] = 10;
        return;
    }
    public static int min(int[] x){
        if(x[0]<=x[1] && x[0]<=x[2])
            return x[0];
        else if(x[1]<=x[0] && x[1]<=x[2])
            return x[1];
        else
            return x[2];
    }
}
