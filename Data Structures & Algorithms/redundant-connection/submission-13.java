class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        Arrays.fill(size, 1);
        size[0] = 0;
    }

    public int find(int node) {
        if (node != parent[node]) {
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

        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);
        
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            if (!dsu.union(node1, node2)) {
                return edge;
            }
        }

        return new int[0];
    }
}
