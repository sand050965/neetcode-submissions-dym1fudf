class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int result = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int time = 0;

            for (int pile : piles) {
                time += pile / mid;
                
                if (pile % mid != 0) {
                    time += 1;
                }
            }

            if (time <= h) {
                result = Math.min(result, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }
}
