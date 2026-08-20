class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        quickSelect(points, k - 1, 0, n - 1);

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }

        return result;
    }

    private void quickSelect(int[][] points, int k, int l, int r) {
        int[] pivot = points[r];
        int pivotX = pivot[0], pivotY = pivot[1];
        int pivotDist = computeDist(pivotX, pivotY);
        int p = l;
        for (int i = l; i < r; i++) {
            int[] point = points[i];
            int x = point[0], y = point[1];
            int dist = computeDist(x, y);
            if (dist <= pivotDist) {
                swap(points, p, i);
                p++;
            }
        }

        swap(points, p, r);

        if (p > k) {
            quickSelect(points, k, l, p - 1);
        } else if (p < k) {
            quickSelect(points, k, p + 1, r);
        }
    }

    private int computeDist(int x, int y) {
        return x * x + y * y;
    }

    private void swap(int[][] arr, int i1, int i2) {
        int[] temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
