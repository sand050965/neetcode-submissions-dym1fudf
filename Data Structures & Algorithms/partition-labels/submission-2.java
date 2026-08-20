class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int idx = Math.max(map.getOrDefault(ch, i), i);
            map.put(ch, idx);
        }


        int size = 0, endIdx = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            size++;
            endIdx = Math.max(endIdx, map.get(ch));

            if (i == endIdx) {
                result.add(size);
                size = 0;
            }
        }

        return result;
    }
}
