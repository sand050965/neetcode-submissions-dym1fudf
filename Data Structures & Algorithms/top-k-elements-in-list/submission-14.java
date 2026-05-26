class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] buckets = new ArrayList[n + 1];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i <= n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), freq = entry.getValue();
            buckets[freq].add(num);
        }

        int[] result = new int[k];
        int idx = 0;
        for (int i = n; i >= 0; i--) {
            List<Integer> list = buckets[i];
            if (list.isEmpty()) {
                continue;
            }

            for (int num : list) {
                if (idx >= k) {
                    return result;
                }

                result[idx++] = num;
            }
        }

        return result;
    }
}
