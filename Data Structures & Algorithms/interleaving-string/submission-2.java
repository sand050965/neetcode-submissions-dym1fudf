class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3)
            return false;
        
        // if (n1 < n2) {
        //     String temp = s1;
        //     s1 = s2;
        //     s2 = temp;

        //     int tempLen = n1;
        //     n1 = n2;
        //     n2 = tempLen;
        // }

        boolean[] dp = new boolean[n2 + 1];
        dp[n2] = true;

        for (int i = n1; i >= 0; i--) {
            boolean[] nextDP = new boolean[n2 + 1];
            if (i == n1) nextDP[n2] = true;

            for (int j = n2; j >= 0; j--) {
                if (i < n1 && s1.charAt(i) == s3.charAt(i + j) && dp[j])
                    nextDP[j] = true;
                
                if (j < n2 && s2.charAt(j) == s3.charAt(i + j) && nextDP[j + 1])
                    nextDP[j] = true;
            }

            dp = nextDP;
        }

        return dp[0];
    }
}
