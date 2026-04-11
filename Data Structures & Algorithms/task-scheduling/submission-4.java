class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        Map<Character, Integer> map = new HashMap<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );
        Queue<int[]> dq = new ArrayDeque<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for (int freq : map.values()) {
            maxHeap.offer(freq);
        }

        while(!maxHeap.isEmpty() || !dq.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                task--;

                if (task > 0) {
                    dq.offer(new int[] {time + n, task});
                }
            }

            if (!dq.isEmpty() && time == dq.peek()[0]) {
                maxHeap.offer(dq.poll()[1]);
            }
        }

        return time;
    }
}
