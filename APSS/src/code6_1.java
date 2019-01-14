public class code6_1 {
    public static void main(String args[]) {
        int res = 0;
        System.out.printf("recursiveSum: %d\n", recursiveSum(res, 10));
    }
    public static int recursiveSum(int res, int n) {
        if (n==0) return res;
        return recursiveSum(res+n, n-1);
    }
}
