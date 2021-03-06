package solutions;

/**
 * https://leetcode.com/problems/divide-two-integers/
 *
 * Divide two integers without using multiplication, division and mod
 * operator.
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers_029 {
    /*
     * dividend = divisor * N
     *          = divisor * (a_0*2^0 + a_1*2^1 + a_2*2^2 + ... + a_n*2^n) where a_i = 0 or 1
     * So instead of counting divisor linearly we can count it logarithmically.
     *
     * count linearly:
     * Iteration 1, dividend -= divisor
     * Iteration 2, dividend -= divisor
     * ...
     * Iteration N, dividend -= divisor
     * So time complexity is O(N) where N = dividend / divisor
     *
     * count logarithmically:
     * Iteration 1, dividend -= divisor * a_n*2^n
     * Iteration 2, dividend -= divisor * a_n-1*2^(n-1)
     * ...
     * Iteration X, dividend -= divisor * a_0*2^0
     * So time complexity is X = O(log N) where N = dividend / divisor
     *
     * https://leetcode.com/discuss/38997/detailed-explained-8ms-c-solution
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) throw new ArithmeticException("Divisor is zero.");
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; // one corner case

        boolean isNeg = dividend < 0 != divisor < 0;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int cnt = 0;
        while (a >= b) {
            int i = 0;
            while (a >= (b << i)) {
                ++i;
            }
            a -= (b << (i - 1));
            cnt += (1 << (i - 1));
        }
        return isNeg ? -cnt : cnt;
    }
}
