class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int left = 0, right = 0;
        List<Integer> result = new ArrayList<>();

        while (right < nums.length) {
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[right]) {
                dq.removeLast();
            }
            dq.addLast(right);

            if (dq.getFirst() < left) {
                dq.removeFirst();
            }

            if (right + 1 >= k) {
                result.add(nums[dq.getFirst()]);
                left++;
            }

            right++;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }   
}
