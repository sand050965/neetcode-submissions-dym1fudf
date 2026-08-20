class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long hours = 0L;
            for (int pile : piles) {
                hours += Math.ceil((double) pile / mid);
            }

            if (hours <= h) {
                right = mid - 1;
                result = Math.min(result, mid);
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
