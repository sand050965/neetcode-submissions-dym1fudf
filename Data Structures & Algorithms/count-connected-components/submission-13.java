class DSU {
    private int components;
    private int[] parent, size;

    public DSU(int n) {
        this.components = n;
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = i;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }

        return parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);

        if (pu == pv) {
            return false;
        }

        if (size[pu] < size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }

        parent[pv] = parent[pu];
        size[pu] += size[pv];
        components--;

        return true;
    }

    public int getComponents() {
        return components;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1];
            dsu.union(n1, n2);
        }

        return dsu.getComponents();
    }
}
