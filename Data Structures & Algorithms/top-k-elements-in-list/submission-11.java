class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(num));
        }

        List<Integer>[] buckets = new ArrayList[maxFreq + 1];
        for (int i = 0; i < maxFreq + 1; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            
            buckets[freq].add(num);
        }

        int[] result = new int[k];
        int idx = 0;
        for (int i = maxFreq; i >= 0; i--) {
            List<Integer> bucket = buckets[i];

            for (int num : bucket) {
                result[idx++] = num;

                if (idx == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
