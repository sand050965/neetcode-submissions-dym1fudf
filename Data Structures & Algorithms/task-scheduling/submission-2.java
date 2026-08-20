class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Deque<int[]> dq = new ArrayDeque<>();
        int[] count = new int[26];
        int time = 0;

        for (char task : tasks) {
            count[task - 'A']++;
        }

        for (int cnt : count) {
            if (cnt == 0) {
                continue;
            }

            maxHeap.offer(cnt);
        }

        while (!maxHeap.isEmpty() || !dq.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int cnt = maxHeap.poll();
                cnt--;

                if (cnt > 0) {
                    dq.offer(new int[] {time + n, cnt});
                }
            }

            if (!dq.isEmpty() && time == dq.peek()[0]) {
                maxHeap.offer(dq.poll()[1]);
            }
        }

        return time;
    }
}
