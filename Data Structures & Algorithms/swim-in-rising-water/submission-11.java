class DSU {
    int capacity;
    int[] parent;
    int[] size;

    public DSU(int capacity) {
        this.capacity = capacity;
        parent = new int[capacity];
        size = new int[capacity];

        Arrays.fill(size, 1);
        for (int i = 0; i < capacity; i++) {
            parent[i] = i;
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

        return true;
    }

    public boolean connected(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        return pu == pv;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        List<int[]> list = new ArrayList<>();
        DSU dsu = new DSU(N * N);
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int startKey = 0;
        int endKey = N * N - 1;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                list.add(new int[] {r, c, grid[r][c]});
            }
        }

        Collections.sort(list, (a, b) -> Integer.compare(a[2], b[2]));

        for (int[] cell : list) {
            int r = cell[0];
            int c = cell[1];
            int t = cell[2];
            int key = r * N + c;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                int nkey = nr * N + nc;

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || t < grid[nr][nc]) {
                    continue;
                }

                dsu.union(key, nkey);

                if (dsu.connected(startKey, endKey)) {
                    return t;
                }
            }
        }
        
        return 0;
    }
}
