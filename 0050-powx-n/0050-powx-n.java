class Solution {
    public double myPow(double x, int n) {
        // Handle negative exponent
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return myPowHelper(x, n);
    }

    public double myPowHelper(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        // Divide and conquer
        double temp = myPowHelper(x, n / 2);

        // If n is even
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            // If n is odd
            return x * temp * temp;
        }
    }
}
