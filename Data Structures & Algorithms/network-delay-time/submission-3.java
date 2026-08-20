class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int result = 0;

        for (int[] time: times) {
            edges.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        minHeap.offer(new int[]{k, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int node = curr[0], time = curr[1];
            if (visited.contains(node)) continue;

            visited.add(node);
            result = time;

            if (!edges.containsKey(node)) continue;

            for (int[] nei: edges.get(node)) {
                int neiNode = nei[0], neiTime = nei[1];
                if (visited.contains(neiNode)) continue;
                minHeap.offer(new int[]{neiNode, time + neiTime});
            }
        }

        return (visited.size() != n) ? -1 : result;
    }
}
