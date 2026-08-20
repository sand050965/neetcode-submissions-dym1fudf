class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[n + 1];
        int[] result = new int[k];
        int idx = 0;

        for (int i = 0; i < n + 1; i++)
            bucket[i] = new ArrayList<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            bucket[entry.getValue()].add(entry.getKey());

        for (int i = n; i > 0; i--) {
            for (int num : bucket[i]) {
                result[idx++] = num;

                if (idx == k)
                    return result;
            }
        }

        return result;
    }
}
