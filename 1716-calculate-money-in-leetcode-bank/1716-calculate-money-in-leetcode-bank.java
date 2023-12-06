class Solution {
    public int totalMoney(int n) {
        if (n == 1) {
            return 1;
        }
        return totalMoneyHelper(n, 1, 1, 1);
    }

    public int totalMoneyHelper(int n, int m, int amount, int week) {
        if (m == n) {
            return amount;
        }

        if (m % 7 == 0) {
            week = week + 1;
            amount += week;
        } else {
            amount += week + m % 7;
        }

        return totalMoneyHelper(n, m + 1, amount, week);
    }
}
