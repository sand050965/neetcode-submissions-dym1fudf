class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int maxFreq = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(num));
        }

        List<Integer>[] bucket = new List[maxFreq + 1];
        
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            bucket[freq].add(num);
        }

        int idx = 0;

        for (int i = maxFreq; idx < k && i > 0; i--) {
            List<Integer> list = bucket[i];

            for (int j = 0; idx < k && j < list.size(); j++) {
                result[idx++] = list.get(j);
            }
        }

        return result;
    }
}
