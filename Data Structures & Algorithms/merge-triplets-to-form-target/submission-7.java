class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x = false, y = false, z = false;

        for (int[] triplet : triplets) {
            x |= triplet[0] == target[0] && triplet[1] <= target[1] && triplet[2] <= target[2];
            y |= triplet[0] <= target[0] && triplet[1] == target[1] && triplet[2] <= target[2];
            z |= triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] == target[2];

            if (x && y && z) {
                return true;
            }
        }

        return false;
    }
}
