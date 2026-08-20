class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character, int[]> map = new HashMap<>();
        int[] substr = new int[2];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new int[]{i, i});
                continue;
            }

            int[] indexes = map.get(ch);
            indexes[1] = Math.max(indexes[1], i);
        }

        for (int i = 0; i <= n; i++) {
            if (i == n) {
                result.add(substr[1] - substr[0] + 1);
                break;
            }

            char ch = s.charAt(i);
            int[] indexes = map.get(ch);
            int minIdx = indexes[0];
            int maxIdx = indexes[1];

            if (minIdx <= substr[1]) {
                substr[0] = Math.min(substr[0], minIdx);
                substr[1] = Math.max(substr[1], maxIdx);
            } else {
                result.add(substr[1] - substr[0] + 1);
                substr[0] = minIdx;
                substr[1] = maxIdx;
            }
        }

        return result;
    }
}
