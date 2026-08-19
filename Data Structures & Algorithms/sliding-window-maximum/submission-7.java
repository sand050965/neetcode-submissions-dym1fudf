class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[n - k + 1];

        while (r < n) {
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[r]) {
                dq.removeLast();
            }
            dq.addLast(r);

            if (l > dq.getFirst()) {
                dq.removeFirst();
            }

            if (r + 1 >= k) {
                result[l] = nums[dq.getFirst()];
                l++;
            }

            r++;
        }

        return result;
    }
}
