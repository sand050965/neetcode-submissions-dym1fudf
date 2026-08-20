class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int prev1 = 0;
        int prev2 = 1;

        for (int i = 1; i <= n; i++) {
            int curr = 0;
            if (s.charAt(i - 1) != '0') {
                curr = prev2;
            }

            if (
                i >= 2 &&
                (
                    s.charAt(i - 2) == '1' ||
                    s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'
                )
            ) {
                curr += prev1;
            }

            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }
}
