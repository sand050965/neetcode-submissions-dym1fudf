class Solution {
    public double myPow(double x, int n) {
        double result = helper(x, Math.abs(n));

        return (n >= 0) ? result : 1 / result;
    }

    private double helper(double x, int n) {
        if (x == 0)
            return 0;
        
        if (n == 0)
            return 1;

        double result = helper(x, n / 2);
        result *= result;

        return (n % 2 == 0) ? result : result * x;
    }
}
