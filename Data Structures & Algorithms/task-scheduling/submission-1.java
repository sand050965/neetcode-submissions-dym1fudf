class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        Deque<int[]> dq = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.offer(new int[] {entry.getKey(), entry.getValue()});
        }

        while (!maxHeap.isEmpty() || !dq.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int[] curr = maxHeap.poll();
                curr[1]--;

                if (curr[1] > 0) {
                    dq.offer(new int[]{curr[0], curr[1], time + n});
                }
            }

            if (!dq.isEmpty() && time == dq.peek()[2]) {
                int[] wait = dq.poll();
                maxHeap.offer(new int[]{wait[0], wait[1]});
            }
        }

        return time;
    }
}
