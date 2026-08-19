class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[n - k + 1];

        while (r < n) {
            if (!dq.isEmpty() && dq.getFirst() < l) {
                dq.removeFirst();
            }

            int num = nums[r];
            while (!dq.isEmpty() && nums[dq.getLast()] < num) {
                dq.removeLast();
            }
            dq.addLast(r);

            if ((r - l + 1) == k) {
                result[l] = nums[dq.getFirst()];
                l++;
            }
            
            r++;
        }

        return result;
    }
}
