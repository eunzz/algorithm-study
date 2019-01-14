import java.net.Inet4Address;
import java.util.Stack;

public class code6_2 {
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        pick(s, 3, 6);
    }
//    0 1 2 3 4 5 6 7
    public static void pick(Stack<Integer> s, int toPick, int n) {
        if (toPick==0) {
            for (int i=0; i<s.size(); i++) {
                System.out.print(s.get(i));
            }
            System.out.println(); return;
        }
        int smallest = s.empty()?0:s.peek()+1;
        for (int i=smallest; i<n; i++) {
            s.push(i);
            pick(s, toPick-1, n);
            s.pop();
        }
    }
}
