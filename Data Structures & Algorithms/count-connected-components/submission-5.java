class DSU {
    int[] parent;
    int[] size;
    int components;

    public DSU(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        components = n;

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }

        return parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) {
            return false;
        }

        if (size[pu] < size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }

        parent[pv] = pu;
        size[pu] += size[pv];
        components--;

        return true;
    }

    public int getComponents() {
        return components;
    }
}

class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    int result = 0;

    public int countComponents(int n, int[][] edges) {
        // for (int i = 0; i < n; i++) {
        //     adj.put(i, new ArrayList<>());
        // }

        // for (int[] edge : edges) {
        //     int node1 = edge[0];
        //     int node2 = edge[1];

        //     adj.get(node1).add(node2);
        //     adj.get(node2).add(node1);
        // }

        // for (int i = 0; i < n; i++) {
        //     if (visit.contains(i)) {
        //         continue;
        //     }

        //     bfs(i);
        //     result++;
        // }

        // return result;
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        return dsu.getComponents();
    }

    private void dfs(int node) {
        if (visit.contains(node)) {
            return;
        }

        visit.add(node);

        for (int nei : adj.get(node)) {
            dfs(nei);
        }
    }

    private void bfs(int startNode) {
        Queue<Integer> dq = new ArrayDeque<>();
        dq.offer(startNode);
        visit.add(startNode);

        while (!dq.isEmpty()) {
            int node = dq.poll();

            for (int nei : adj.get(node)) {
                if (visit.contains(nei)) {
                    continue;
                }

                visit.add(nei);
                dq.offer(nei);
            }
        }
    }
}
