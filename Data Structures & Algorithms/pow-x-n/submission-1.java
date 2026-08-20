class Solution {
    public double myPow(double x, int n) {
        double result = recurse(x, Math.abs((long) n));

        return (n < 0) ? 1 / result : result;
    }

    private double recurse(double x, long n) {
        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        double result = recurse(x, n / 2);
        result *= result;

        return (n % 2 == 1) ? x * result : result;
    }
}
