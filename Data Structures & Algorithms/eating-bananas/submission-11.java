class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int l = 1, r = max + 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canFinishwithinH(piles, h, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private boolean canFinishwithinH(int[] piles, int h, int k) {
        long t = 0;
        for (int pile : piles) {
            t += Math.ceil((double) pile / k);
        }

        return (t <= h);
    }
}
