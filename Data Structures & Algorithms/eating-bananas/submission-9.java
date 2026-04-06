class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (canFinish(piles, h, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private boolean canFinish(int[] piles, int h, int rate) {
        long sum = 0;

        for (int pile : piles) {
            sum += (long) Math.ceil((double) pile / rate);
        }

        return sum <= h;
    }
}
