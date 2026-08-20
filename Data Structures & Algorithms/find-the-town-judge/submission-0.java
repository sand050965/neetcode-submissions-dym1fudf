class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1)
            return -1;
        
        int[] trustScore = new int[n + 1];
        for (int[] trustArr : trust) {
            trustScore[trustArr[0]]--;
            trustScore[trustArr[1]]++;
        }

        for (int i = 1; i < n + 1; i++) {
            if (trustScore[i] == n - 1)
                return i;
        }

        return -1;
    }
}