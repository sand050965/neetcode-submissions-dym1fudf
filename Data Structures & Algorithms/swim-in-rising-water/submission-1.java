class DSU {
    int[] parent, size;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
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
        int pu = find(u), pv = find(v);

        if (pu == pv) return false;

        if (size[pu] >= size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }

        return true;
    }

    public boolean connected(int u, int v) {
        return find(u) == find(v);
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<int[]> positions = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                positions.add(new int[]{grid[r][c], r, c});
            }
        }

        positions.sort((a, b) -> Integer.compare(a[0], b[0]));
        for (int[] pos: positions) {
            int t = pos[0], r = pos[1], c = pos[2];
            for (int[] dir: dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || grid[nr][nc] > t)
                    continue;
                
                dsu.union(r * n + c, nr * n + nc);
            }

            if (dsu.connected(0, n * n - 1)) return t;
        }

        return n * n;
    }
}
