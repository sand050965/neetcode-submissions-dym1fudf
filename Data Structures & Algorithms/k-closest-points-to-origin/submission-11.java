class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int l = 0, r = n - 1;
        quickSelect(points, k, l, r);

        return Arrays.copyOf(points, k);
    }

    private void quickSelect(int[][] points, int k, int l, int r) {
        int pivot = r, p = l;
        int[] pivotPoint = points[pivot];
        int pivotX = pivotPoint[0], pivotY = pivotPoint[1];
        int pivotDist = computeDist(pivotX, pivotY);

        for (int i = l; i < r; i++) {
            int[] point = points[i];
            int x = point[0], y = point[1];
            int dist = computeDist(x, y);

            if (dist <= pivotDist) {
                swap(points, i, p);
                p++;
            }
        }

        swap(points, pivot, p);

        if (p > k - 1) {
            quickSelect(points, k, l, p - 1);
        } else if (p < k - 1) {
            quickSelect(points, k, p + 1, r);
        }
    }

    private int computeDist(int x, int y) {
        return x * x + y * y;
    }

    private void swap(int[][] arr, int idx1, int idx2) {
        int[] temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
