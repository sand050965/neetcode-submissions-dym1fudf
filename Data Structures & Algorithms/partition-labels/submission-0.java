class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int size = 0, end = 0;

        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), i);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            size++;

            if (i == end) {
                result.add(size);
                size = 0;
            }
        }

        return result;
    }
}
