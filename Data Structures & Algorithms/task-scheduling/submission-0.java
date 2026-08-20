class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Queue<int[]> dq = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry.getValue());
        }

        int time = 0;
        while (!maxHeap.isEmpty() || !dq.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0)
                    dq.offer(new int[]{cnt, time + n});
            }

            if (!dq.isEmpty() && time == dq.peek()[1]) {
                maxHeap.offer(dq.poll()[0]);
            }
        }

        return time;
    }
}
