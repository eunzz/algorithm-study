import java.lang.*;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] p = new int[n][2];
        //p[i][0] = 두 칸 올라서 i번째 계단에 올라갔을 때
	//p[i][1] = 한 칸 올라서 i번째 계단에 올라갔을 때        
        p[0][0] = Integer.parseInt(sc.nextLine());
        int stair = Integer.parseInt(sc.nextLine());
        p[1][1] = stair + p[0][0];
        p[1][0] = stair;

        for(int i=2; i<n; i++){
            stair = Integer.parseInt(sc.nextLine());
            p[i][0] = Math.max(p[i-2][0], p[i-2][1]) + stair; 
            p[i][1] = p[i-1][0] + stair; //연속세번 한칸씩 오르면 안되므로 p[i-1][0]에서 올라온다.  
        }
        System.out.println(Math.max(p[n-1][0], p[n-1][1]));
    }
}
