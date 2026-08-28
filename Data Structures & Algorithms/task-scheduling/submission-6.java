class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(map.get(b), map.get(a)));
        Queue<Pair<Character, Integer>> dq = new ArrayDeque<>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for (char task : map.keySet()) {
            maxHeap.offer(task);
        }


        while (!maxHeap.isEmpty() || !dq.isEmpty()) {
            if (maxHeap.isEmpty()) {
                time = dq.peek().getValue();
            }

            while (!dq.isEmpty() && time == dq.peek().getValue()) {
                maxHeap.offer(dq.poll().getKey());
            }

            char task = maxHeap.poll();
            map.put(task, map.get(task) - 1);

            if (map.get(task) > 0) {
                dq.offer(new Pair<>(task, time + n + 1));
            }
            
            time++;
        }

        return time;
    }
}
