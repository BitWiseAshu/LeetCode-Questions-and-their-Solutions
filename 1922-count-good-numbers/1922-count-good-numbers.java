class Solution {
    long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = n - odd;

        long evenPow = pow(5, even) % MOD;
        long oddPow = pow(4, odd) % MOD;

        long ans = (evenPow * oddPow) % MOD;
        return (int) ans;
    }

    public long pow(long x, long n) {
        if (n == 0) {
            return 1;
        }

        long temp = pow(x, n / 2);

        if (n % 2 == 0) {
            return (temp * temp) % MOD;
        } else {
            return (x * temp * temp) % MOD;
        }
    }
}
