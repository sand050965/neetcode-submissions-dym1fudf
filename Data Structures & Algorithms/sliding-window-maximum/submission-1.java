class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int n = nums.length;
        int l = 0, r = 0;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        while (r < n) {
            while (!dq.isEmpty() && nums[r] > nums[dq.peekLast()])
                dq.removeLast();

            dq.addLast(r);

            while (!dq.isEmpty() && dq.peekFirst() < l)
                dq.removeFirst();

            if (r + 1 >= k) {
                result[l++] = nums[dq.peekFirst()];
            }
            
            r++;
        }

        return result;
    }
}
