class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        while (r < n) {
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[r]) {
                dq.removeLast();
            }

            dq.addLast(r);

            if (dq.getFirst() < l) {
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
