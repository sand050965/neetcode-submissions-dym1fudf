class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(map.get(b), map.get(a)));
        Queue<Pair<Character, Integer>> dq = new ArrayDeque<>();

        for (char task : map.keySet()) {
            maxHeap.offer(task);
        }

        int time = 0;

        while (!maxHeap.isEmpty() || !dq.isEmpty()) {
            while (!dq.isEmpty() && time == dq.peek().getValue()) {
                maxHeap.offer(dq.poll().getKey());
            }

            if (maxHeap.isEmpty()) {
                Pair<Character, Integer> pair = dq.poll();
                time = pair.getValue();
                maxHeap.offer(pair.getKey());
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
