class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = piles[0];

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int l = 1, r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (canFinish(piles, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private boolean canFinish(int[] piles, int rate, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / rate);
        }

        return hours <= h;
    }
}
