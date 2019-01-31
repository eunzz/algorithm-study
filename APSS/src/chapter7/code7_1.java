package chapter7;
// 분할 정복을 이용한 1에서 n까지의 숫자의 합.
public class code7_1 {
    public static int fastSum(int n) {
//        1. 기저사례
        if (n==1) return 1;
        if (n%2==1) return n+fastSum(n-1);
//      분할
        return 2*fastSum(n/2)+(n/2)*(n/2);
    }
}
