class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        while (r < n) {
            while (!dq.isEmpty() && nums[r] > nums[dq.getLast()]) {
                dq.removeLast();
            }

            dq.addLast(r);

            if (l > dq.getFirst()) {
                dq.removeFirst();
            }

            if (r + 1 >= k) {
                result[l++] = nums[dq.getFirst()];
            }

            r++;
        }

        return result;
    }
}
