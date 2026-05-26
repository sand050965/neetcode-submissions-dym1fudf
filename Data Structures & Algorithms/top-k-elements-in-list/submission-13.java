class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] buckets = new List[n + 1];
        int[] result = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i <= n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            buckets[value].add(key);
        }

        int idx = 0;
        for (int i = n; i >= 0; i--) {
            List<Integer> list = buckets[i];
            for (int j = 0; j < list.size(); j++) {
                if (idx >= k) {
                    return result;
                }

                result[idx++] = list.get(j);
            }
        }

        return result;
    }
}
