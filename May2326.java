public class May2326 {

    public static void main(String[] args) {
        May2326 may = new May2326();
        int n = 2;
        System.out.println("climbStairs--->" + may.climbStairs(n));
    }

    public int climbStairs(int n) {
        return combi(n, 0);
    }

    public int combi(int n, int i) {
        if (i >= n)
            return i == n ? 1 : 0;
        return combi(n, i + 1) + combi(n, i + 2);
    }

}
